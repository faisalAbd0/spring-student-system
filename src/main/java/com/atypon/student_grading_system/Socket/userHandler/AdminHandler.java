//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket.userHandler;

import com.atypon.student_grading_system.data.DAO.AdminDao;
import com.atypon.student_grading_system.data.DAO.CourseDao;
import com.atypon.student_grading_system.data.DAO.InstructorDao;
import com.atypon.student_grading_system.data.DAO.StudentDao;
import com.atypon.student_grading_system.models.Admin;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.Instructor;
import com.atypon.student_grading_system.models.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminHandler implements UserHandler {
    private final AdminDao adminDao;
    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final InstructorDao instructorDao;

    public AdminHandler(AdminDao adminDao, StudentDao studentDao, CourseDao courseDao, InstructorDao instructorDao) {
        this.adminDao = adminDao;
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.instructorDao = instructorDao;
    }

    public void handleUserRequest(IUser user, PrintWriter out, BufferedReader in) throws IOException {
        Admin admin = (Admin)user;

        while(true) {
            out.println("MENU");
            out.println("1. Create a new instructor");
            out.println("2. Create a new student");
            out.println("3. Create a new course");
            out.println("4. Delete a student");
            out.println("5. Delete an instructor");
            out.println("6. Delete a course");
            out.println("-1. Exit");
            out.println("Enter your choice:");
            out.flush();
            String choice = in.readLine();
            if (choice == null) {
                return;
            }

            switch (choice) {
                case "1":
                    out.println("Enter instructor username:");
                    out.flush();
                    String instUsername = in.readLine();
                    out.println("Enter instructor password:");
                    out.flush();
                    String instPassword = in.readLine();
                    this.createInstructor(instUsername, instPassword);
                    out.println("Instructor created successfully!");
                    out.flush();
                    break;
                case "2":
                    out.println("Enter student username:");
                    out.flush();
                    String stuUsername = in.readLine();
                    out.println("Enter student password:");
                    out.flush();
                    String stuPassword = in.readLine();
                    out.println("Enter student age:");
                    out.flush();
                    int stuAge = Integer.parseInt(in.readLine());
                    out.println("Enter student GPA:");
                    out.flush();
                    double stuGPA = Double.parseDouble(in.readLine());
                    this.createStudent(stuUsername, stuPassword, stuAge, stuGPA);
                    out.println("Student created successfully!");
                    out.flush();
                    break;
                case "3":
                    out.println("Enter course name:");
                    out.flush();
                    String courseName = in.readLine();
                    out.println("Enter student limit:");
                    out.flush();
                    int courseLimit = Integer.parseInt(in.readLine());
                    this.createCourse(courseName, courseLimit);
                    out.println("Course created successfully!");
                    out.flush();
                    break;
                case "4":
                    out.println("Enter student ID to delete:");
                    out.flush();
                    int stuId = Integer.parseInt(in.readLine());
                    this.deleteStudent(stuId);
                    out.println("Student deleted successfully!");
                    out.flush();
                    break;
                case "5":
                    out.println("Enter instructor ID to delete:");
                    out.flush();
                    int instId = Integer.parseInt(in.readLine());
                    this.deleteInstructor(instId);
                    out.println("Instructor deleted successfully!");
                    out.flush();
                    break;
                case "6":
                    out.println("Enter course ID to delete:");
                    out.flush();
                    int courseId = Integer.parseInt(in.readLine());
                    this.deleteCourse(courseId);
                    out.println("Course deleted successfully!");
                    out.flush();
                    break;
                case "-1":
                    out.println("Goodbye!");
                    return;
                default:
                    out.println("Invalid choice. Try again.");
                    out.flush();
            }
        }
    }

    public void createInstructor(String username, String password) {
        Instructor instructor = Instructor.createInstructor(username, password);
        this.instructorDao.createInstructor(instructor);
    }

    public void deleteInstructor(int id) {
        this.instructorDao.deleteInstructor(id);
    }

    public void createCourse(String courseName, int limit) {
        Course course = Course.createCourse(courseName, limit);
        this.courseDao.addCourse(course);
    }

    public void deleteCourse(int id) {
        this.courseDao.deleteCourse(id);
    }

    public void createStudent(String username, String password, int age, double gpa) {
        Student student = (new Student.Builder()).setUsername(username).setPassword(password).setAge(age).setGpa(gpa).build();
        this.studentDao.saveStudent(student);
    }

    public void deleteStudent(int id) {
        this.studentDao.deleteStudent(id);
    }
}
