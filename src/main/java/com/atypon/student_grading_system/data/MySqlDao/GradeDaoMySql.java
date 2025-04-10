//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.data.MySqlDao;

import com.atypon.student_grading_system.data.DAO.GradeDao;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoMySql implements GradeDao {
    static Connection connection = MySQLConnection.getConnection();
    private static GradeDaoMySql instance;

    private GradeDaoMySql() {
    }

    public static GradeDaoMySql getInstance() {
        if (instance == null) {
            instance = new GradeDaoMySql();
        }

        return instance;
    }

    public List<Grade> getGradesById(int studentId) {
        List<Grade> grades = new ArrayList();
        String query = "SELECT c.*, cs.Grade FROM course c JOIN course_student cs ON c.ID = cs.COURSE_ID WHERE cs.student_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentId);
            ResultSet res = preparedStatement.executeQuery();

            while(res.next()) {
                Course course = Course.createCourse(res.getString("name"), res.getInt("student_limit"));
                course.setCourseId(res.getInt("id"));
                Grade grade = Grade.createGrade(res.getInt("grade"), course, studentId);
                grades.add(grade);
            }
        } catch (SQLException e) {
            System.out.println("getGradeById failed");
            e.printStackTrace();
        }

        return grades;
    }

    public boolean setGrade(int studentId, int courseId, int grade) {
        String query = "UPDATE course_student SET grade = ? WHERE STUDENT_ID = ? AND COURSE_ID = ?";

        try {
            boolean var7;
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, grade);
                preparedStatement.setInt(2, studentId);
                preparedStatement.setInt(3, courseId);
                int res = preparedStatement.executeUpdate();
                var7 = res > 0;
            }

            return var7;
        } catch (SQLException e) {
            System.out.println("Failed to set grade");
            e.printStackTrace();
            return false;
        }
    }

    public Grade getGradeById(int studentId, int courseId) {
        Grade grade1 = null;
        String query = "SELECT * FROM course_student WHERE STUDENT_ID = ? AND COURSE_ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, courseId);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Course course = CourseDaoMySql.getInstance().getCourseById(res.getInt("course_id"));
                grade1 = Grade.createGrade(res.getInt("grade"), course, res.getInt("student_id"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to set grade");
            e.printStackTrace();
        }

        return grade1;
    }
}
