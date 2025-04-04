//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.Socket.userHandler;

import com.atypon.student_grading_system.data.DAO.GradeDao;
import com.atypon.student_grading_system.data.DAO.InstructorDao;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.Instructor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class InstructorHandler implements UserHandler {
    private final InstructorDao instructorDao;
    private final GradeDao gradeDao;

    public InstructorHandler(InstructorDao instructorDao, GradeDao gradeDao) {
        this.instructorDao = instructorDao;
        this.gradeDao = gradeDao;
    }

    public void handleUserRequest(IUser user, PrintWriter out, BufferedReader in) throws IOException {
        Instructor instructor = (Instructor)user;

        while(true) {
            out.println("MENU");
            out.println("1. View Courses");
            out.println("2. Set Grades");
            out.println("3. Exit");
            out.println("Enter your choice:");
            out.flush();
            String choice = in.readLine();
            if (choice == null) {
                return;
            }

            switch (choice) {
                case "1":
                    this.viewCourses(instructor, out, in);
                    break;
                case "2":
                    System.out.println(">Enter Course ID:");
                    out.println("Enter Course ID:");
                    out.flush();
                    String courseId = in.readLine();
                    int courseIdInt = Integer.parseInt(courseId);
                    out.println("Enter Student ID:");
                    out.flush();
                    String studentId = in.readLine();
                    int studentIdInt = Integer.parseInt(studentId);
                    out.println("Enter Grade:");
                    out.flush();
                    String grade = in.readLine();
                    int gradeInt = Integer.parseInt(grade);
                    this.setGrades(courseIdInt, studentIdInt, gradeInt, out, in);
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

    public void viewCourses(Instructor instructor, PrintWriter out, BufferedReader in) throws IOException {
        List<Course> courses = this.instructorDao.getInstructorCourses(instructor.getId());

        for(Course course : courses) {
            System.out.println(course.toString());
        }

        if (courses.isEmpty()) {
            out.println("No courses found.");
        } else {
            out.println("Courses:");

            for(Course course : courses) {
                out.println(course.toString());
            }
        }

        out.println("END");
        out.flush();
    }

    public void setGrades(int courseId, int studentId, int grade, PrintWriter out, BufferedReader in) throws IOException {
        boolean isOK = this.gradeDao.setGrade(studentId, courseId, grade);
        if (isOK) {
            System.out.println("Grade set successfully");
            out.println("grade set successfully");
        } else {
            System.out.println("Grade not set");
            out.println("grade not set");
        }

    }
}
