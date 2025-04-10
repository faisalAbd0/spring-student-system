//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket;

import com.atypon.student_grading_system.Socket.userHandler.AdminHandler;
import com.atypon.student_grading_system.Socket.userHandler.InstructorHandler;
import com.atypon.student_grading_system.Socket.userHandler.StudentHandler;
import com.atypon.student_grading_system.Socket.userHandler.UserHandler;
import com.atypon.student_grading_system.data.DAO.AdminDao;
import com.atypon.student_grading_system.data.DAO.CourseDao;
import com.atypon.student_grading_system.data.DAO.GradeDao;
import com.atypon.student_grading_system.data.DAO.InstructorDao;
import com.atypon.student_grading_system.data.DAO.StudentDao;
import com.atypon.student_grading_system.data.MySqlDao.AdminDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.CourseDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.GradeDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.InstructorDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.StudentDaoMySql;
import com.atypon.student_grading_system.global.ValidateCredential;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.USER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Optional;

class ClientHandler implements Runnable, AutoCloseable {
    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static final StudentDao studentDao = StudentDaoMySql.getInstance();
    private static final InstructorDao instructorDao = InstructorDaoMySql.getInstance();
    private static final AdminDao adminDao = AdminDaoMySql.getInstance();
    private static final CourseDao courseDao = CourseDaoMySql.getInstance();
    private static final GradeDao gradeDao = GradeDaoMySql.getInstance();

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    private void getUserMenu(USER userType, IUser user) throws IOException {
        UserHandler userHandler = null;
        if (userType == USER.STUDENT) {
            userHandler = new StudentHandler(studentDao, courseDao, gradeDao);
        } else if (userType == USER.INSTRUCTOR) {
            userHandler = new InstructorHandler(instructorDao, gradeDao);
        } else if (userType == USER.ADMIN) {
            userHandler = new AdminHandler(adminDao, studentDao, courseDao, instructorDao);
        }

        if (userHandler != null) {
            userHandler.handleUserRequest(user, this.out, this.in);
        }

    }

    private void handleUserCredentials(String username, String password, USER userType) throws IOException {
        Optional<IUser> user = ValidateCredential.checkUserCredentials(username, password, userType);
        if (user.isPresent()) {
            this.out.println("true");
            this.out.println("Your password is correct");
            System.out.printf("[%s] Login successful: %s%n", userType, username);
            this.getUserMenu(userType, (IUser)user.get());
        } else {
            this.out.println("false");
            this.out.println("Your password is incorrect");
            System.out.printf("[%s] Login failed: %s (Incorrect password)%n", userType, username);
        }

    }

    private void handleInput(Character c) throws IOException {
        String[] input = this.in.readLine().split(" ");
        if (input.length < 2) {
            this.out.println("false");
            this.out.println("Invalid input. Expected format: <username> <password>");
        } else {
            String username = input[0];
            String password = input[1];
            switch (c) {
                case '1':
                    this.handleUserCredentials(username, password, USER.STUDENT);
                    break;
                case '2':
                    this.handleUserCredentials(username, password, USER.INSTRUCTOR);
                    break;
                case '3':
                    this.handleUserCredentials(username, password, USER.ADMIN);
                    break;
                default:
                    this.out.println("false");
                    this.out.println("Invalid selection.");
            }

        }
    }

    public void run() {
        try {
            this.out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            String line;
            while((line = this.in.readLine()) != null && !line.equalsIgnoreCase("exit")) {
                this.handleInput(line.charAt(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }

    }

    public void close() {
        try {
            if (this.out != null) {
                this.out.close();
            }

            if (this.in != null) {
                this.in.close();
            }

            if (this.clientSocket != null && !this.clientSocket.isClosed()) {
                this.clientSocket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
