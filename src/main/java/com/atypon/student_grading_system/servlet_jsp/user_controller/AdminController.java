//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.servlet_jsp.user_controller;

import com.atypon.student_grading_system.data.MySqlDao.CourseDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.InstructorDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.StudentDaoMySql;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Instructor;
import com.atypon.student_grading_system.models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/admin/*"}
)
public class AdminController extends HttpServlet {
    public AdminController() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println("Path info: " + pathInfo);
        switch (pathInfo) {
            case "/addCourse" -> this.addCourse(req, resp);
            case "/addInstructor" -> this.addInstructor(req, resp);
            case "/addStudent" -> this.addStudent(req, resp);
            case "/deleteCourse" -> this.deleteCourse(req, resp);
            case "/deleteInstructor" -> this.deleteInstructor(req, resp);
            case "/deleteStudent" -> this.deleteStudent(req, resp);
            default -> resp.sendError(404, "Invalid action.");
        }

    }

    private void addCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String courseName = req.getParameter("courseName");
        int studentLimit = Integer.parseInt(req.getParameter("studentLimit"));
        Course course = Course.createCourse(courseName, studentLimit);
        CourseDaoMySql.getInstance().addCourse(course);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    private void addInstructor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("instructorUsername");
        String password = req.getParameter("instructorPassword");
        Instructor instructor = Instructor.createInstructor(username, password);
        InstructorDaoMySql.getInstance().createInstructor(instructor);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("studentUsername");
        String password = req.getParameter("studentPassword");
        double gpa = Double.parseDouble(req.getParameter("studentGpa"));
        int age = Integer.parseInt(req.getParameter("studentAge"));
        Student student = (new Student.Builder()).setUsername(username).setPassword(password).setAge(age).setGpa(gpa).build();
        StudentDaoMySql.getInstance().saveStudent(student);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    private void deleteCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        CourseDaoMySql.getInstance().deleteCourse(courseId);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    private void deleteInstructor(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int instructorId = Integer.parseInt(req.getParameter("instructorId"));
        InstructorDaoMySql.getInstance().deleteInstructor(instructorId);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        StudentDaoMySql.getInstance().deleteStudent(studentId);
        resp.sendRedirect(req.getContextPath() + "/admin/dashboard");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Admin Controller");
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userId") != null) {
            String pathInfo = req.getPathInfo();
            System.out.println("Path info: " + pathInfo);
            String action = "dashboard";
            if (pathInfo != null && pathInfo.length() > 1) {
                action = pathInfo.substring(1);
            }

            System.out.println("Action: " + action);
            int id = (Integer)session.getAttribute("userId");
            switch (action) {
                case "dashboard" -> this.handleDashboard(req, resp);
                default -> this.handleDashboard(req, resp);
            }

        } else {
            req.setAttribute("errorMessage", "You are not logged in!");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }
    }

    private void handleDashboard(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("userId", session.getAttribute("userId"));
        List<Student> students = StudentDaoMySql.getInstance().getAllStudents();
        List<Course> courses = CourseDaoMySql.getInstance().getAllCourses();
        List<Instructor> instructors = InstructorDaoMySql.getInstance().getInstructors();
        req.setAttribute("courses", courses);
        req.setAttribute("students", students);
        req.setAttribute("instructors", instructors);

        for(Course course : courses) {
            System.out.println(course);
        }

        for(Instructor instructor : instructors) {
            System.out.println(instructor);
        }

        for(Student student : students) {
            System.out.println(student);
        }

        req.getRequestDispatcher("/WEB-INF/views/admin/dashboard.jsp").forward(req, resp);
    }
}
