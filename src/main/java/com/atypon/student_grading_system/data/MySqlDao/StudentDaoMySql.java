//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.MySqlDao;

import com.atypon.student_grading_system.data.DAO.StudentDao;
import com.atypon.student_grading_system.models.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoMySql implements StudentDao {
    private final Connection connection = MySQLConnection.getConnection();
    private static StudentDaoMySql studentDaoMySql;

    private StudentDaoMySql() {
    }

    public static StudentDaoMySql getInstance() {
        if (studentDaoMySql == null) {
            studentDaoMySql = new StudentDaoMySql();
        }

        return studentDaoMySql;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList();
        String query = "SELECT * FROM student";

        try {
            try (
                    Statement statement = this.connection.createStatement();
                    ResultSet res = statement.executeQuery(query);
            ) {
                while(res.next()) {
                    Student student = (new Student.Builder()).setId(res.getInt("id")).setUsername(res.getString("username")).setPassword(res.getString("password")).setAge(res.getInt("age")).setGpa(res.getDouble("gpa")).build();
                    students.add(student);
                }
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving students", e);
        }
    }

    public Student getStudentByUsername(String username) {
        Student student = null;
        String query = "SELECT * FROM student WHERE username = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                student = (new Student.Builder()).setId(res.getInt("id")).setUsername(res.getString("username")).setPassword(res.getString("password")).setAge(res.getInt("age")).setGpa(res.getDouble("gpa")).build();
            }
        } catch (SQLException e) {
            System.out.println("getStudentByUsername failed");
            e.printStackTrace();
        }

        return student;
    }

    public Student getStudentById(int id) {
        Student student = null;
        String query = "SELECT * FROM student WHERE id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                student = (new Student.Builder()).setId(res.getInt("id")).setUsername(res.getString("username")).setPassword(res.getString("password")).setAge(res.getInt("age")).setGpa(res.getDouble("gpa")).build();
            }
        } catch (SQLException e) {
            System.out.println("getStudentByUsername failed");
            e.printStackTrace();
        }

        return student;
    }

    public void saveStudent(Student student) {
        String query = "INSERT INTO student (username, password, age, gpa) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setString(1, student.getUsername());
            statement.setString(2, student.getPassword());
            statement.setInt(3, student.getAge());
            statement.setDouble(4, student.getGpa());
            int res = statement.executeUpdate();
            if (res > 0) {
                System.out.println("Student inserted successfully");
            } else {
                System.out.println("Insert failed");
            }
        } catch (SQLException e) {
            System.out.println("Insert failed");
            e.printStackTrace();
        }

    }

    public boolean updateStudent(Student student) {
        String query = "UPDATE student SET password = ?, age = ?, gpa = ? WHERE username = ?";

        try {
            boolean var4;
            try (PreparedStatement statement = this.connection.prepareStatement(query)) {
                statement.setString(1, student.getPassword());
                statement.setInt(2, student.getAge());
                statement.setDouble(3, student.getGpa());
                statement.setString(4, student.getUsername());
                var4 = statement.executeUpdate() > 0;
            }

            return var4;
        } catch (SQLException e) {
            System.out.println("Update failed");
            e.printStackTrace();
            return false;
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM student WHERE id = ?";

        try (PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Delete failed");
            e.printStackTrace();
        }

    }

    public List<Student> getStudentsInCourse(int courseId) {
        List<Student> students = new ArrayList();
        String query = "SELECT * FROM student WHERE ID IN (SELECT Student_ID FROM course_student WHERE course_id = ?)";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courseId);
            ResultSet res = preparedStatement.executeQuery();

            while(res.next()) {
                Student student = (new Student.Builder()).setUsername(res.getString("username")).setPassword(res.getString("password")).setGpa(res.getDouble("gpa")).setAge(res.getInt("age")).setId(res.getInt("id")).build();
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("getCourseById failed");
            e.printStackTrace();
        }

        return students;
    }
}
