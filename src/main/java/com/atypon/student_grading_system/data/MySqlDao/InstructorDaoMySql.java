//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.MySqlDao;

import com.atypon.student_grading_system.data.DAO.InstructorDao;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Instructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InstructorDaoMySql implements InstructorDao {
    private final Connection connection = MySQLConnection.getConnection();
    private static InstructorDaoMySql instructorDaoMySql;

    private InstructorDaoMySql() {
    }

    public static InstructorDaoMySql getInstance() {
        if (instructorDaoMySql == null) {
            instructorDaoMySql = new InstructorDaoMySql();
        }

        return instructorDaoMySql;
    }

    public void createInstructor(Instructor instructor) {
        String query = "INSERT INTO instructor (username, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, instructor.getUsername());
            preparedStatement.setString(2, instructor.getPassword());
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                System.out.println("Instructor created successfully");
            } else {
                System.out.println("Instructor not created");
            }
        } catch (SQLException e) {
            System.out.println("Failed to create instructor");
            e.printStackTrace();
        }

    }

    public void deleteInstructor(int instructorId) {
        String query = "DELETE FROM instructor WHERE id = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, instructorId);
            int var4 = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to delete instructor");
            e.printStackTrace();
        }

    }

    public Instructor getInstructor(String username) {
        Instructor instructor = null;
        String query = "SELECT * FROM instructor WHERE username = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                instructor = Instructor.createInstructor(resultSet.getString("username"), resultSet.getString("password"));
                instructor.setId(resultSet.getInt("id"));
                return instructor;
            }
        } catch (SQLException e) {
            System.out.println("Failed to get instructor");
            e.printStackTrace();
        }

        return null;
    }

    public List<Course> getInstructorCourses(int instructorId) {
        List<Course> courses = new ArrayList();
        String query = "SELECT * FROM course WHERE ID IN (SELECT COURSE_ID FROM course_instructor where instructor_id = ?)";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, instructorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Course course = Course.createCourse(resultSet.getString("name"), resultSet.getInt("student_limit"));
                course.setCourseId(resultSet.getInt("id"));
                courses.add(course);
            }
        } catch (SQLException e) {
            System.out.println("Failed to get instructor");
            e.printStackTrace();
        }

        return courses;
    }

    public List<Instructor> getInstructors() {
        List<Instructor> instructors = new ArrayList();
        String query = "SELECT * FROM instructor";

        try (Statement statement = this.connection.createStatement()) {
            ResultSet res = statement.executeQuery(query);

            while(res.next()) {
                Instructor instructor = Instructor.createInstructor(res.getString("username"), res.getString("password"));
                instructor.setId(res.getInt("id"));
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            System.out.println("getAllCourses failed");
            e.printStackTrace();
        }

        return instructors;
    }
}
