//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket.userHandler;

import com.atypon.student_grading_system.data.DAO.CourseDao;
import com.atypon.student_grading_system.data.DAO.GradeDao;
import com.atypon.student_grading_system.data.DAO.StudentDao;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Grade;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentHandler implements UserHandler {
    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final GradeDao gradeDao;

    public StudentHandler(StudentDao studentDao, CourseDao courseDao, GradeDao gradeDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.gradeDao = gradeDao;
    }

    public void handleUserRequest(IUser user, PrintWriter out, BufferedReader in) throws IOException {
        Student student = (Student)user;

        while(true) {
            out.println("MENU");
            out.println("1. View Courses");
            out.println("2. View Grades");
            out.println("3. Exit");
            out.println("Enter your choice:");
            out.flush();
            String choice = in.readLine();
            if (choice == null) {
                return;
            }

            switch (choice) {
                case "1":
                    this.viewCourse(student, out);
                    break;
                case "2":
                    this.viewGrades(student, out);
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

    private void viewCourse(Student student, PrintWriter out) {
        List<Course> courses = this.courseDao.getStudentCourseById(student.getId());
        if (courses.isEmpty()) {
            out.println("No courses found.");
        } else {
            out.println("Courses:");

            for(Course course : courses) {
                out.println(course);
            }
        }

        out.println("END");
        out.flush();
    }

    private void viewGrades(Student student, PrintWriter out) {
        List<Grade> grades = this.gradeDao.getGradesById(student.getId());
        if (grades.isEmpty()) {
            out.println("No grades found.");
        } else {
            out.println("Grades:");

            for(Grade grade : grades) {
                out.println(grade);
            }
        }

        out.println("END");
        out.flush();
    }
}
