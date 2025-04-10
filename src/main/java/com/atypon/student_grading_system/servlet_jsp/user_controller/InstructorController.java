//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.servlet_jsp.user_controller;

import com.atypon.student_grading_system.data.MySqlDao.CourseDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.GradeDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.InstructorDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.StudentDaoMySql;
import com.atypon.student_grading_system.models.Course;
import com.atypon.student_grading_system.models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(
        urlPatterns = {"/instructor/*"}
)
public class InstructorController extends HttpServlet {
    public InstructorController() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        int newGrade = Integer.parseInt(req.getParameter("newGrade"));
        this.setGrade(req, resp, studentId, newGrade);
    }

    private void setGrade(HttpServletRequest req, HttpServletResponse resp, int studentId, int newGrade) throws ServletException, IOException {
        req.getParameterNames().asIterator().forEachRemaining((name) -> System.out.println(name + ": " + req.getParameter(name)));
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        GradeDaoMySql.getInstance().setGrade(studentId, courseId, newGrade);
        String var10001 = req.getContextPath();
        resp.sendRedirect(var10001 + "/instructor/students?courseId=" + courseId);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor Controller");
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
                case "dashboard":
                    this.handleDashboard(req, resp, id);
                    break;
                case "students":
                    this.handleStudents(req, resp);
                    this.handleStatus(req, resp);
                    break;
                default:
                    this.handleDashboard(req, resp, id);
            }

        } else {
            req.setAttribute("errorMessage", "You are not logged in!");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }
    }

    private void handleStudents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Student, Integer> students = new HashMap();
        int id = this.getCurrentCourseId(req);
        if (id == 0) {
            req.setAttribute("errorMessage", "Course ID is required.");
            req.getRequestDispatcher("/WEB-INF/views/instructor/dashboard.jsp").forward(req, resp);
        } else {
            System.out.println("ID:IDID:" + id);

            for(Student student : StudentDaoMySql.getInstance().getStudentsInCourse(id)) {
                int grade = GradeDaoMySql.getInstance().getGradeById(student.getId(), id).getGrade();
                System.out.println("Grade: " + grade);
                students.put(student, grade);
            }

            req.setAttribute("students", students);
        }
    }

    private void handleStatus(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = this.getCurrentCourseId(req);
        if (id == 0) {
            req.setAttribute("errorMessage", "Course ID is required.");
            req.getRequestDispatcher("/WEB-INF/views/instructor/dashboard.jsp").forward(req, resp);
        } else {
            List<Integer> status = CourseDaoMySql.getInstance().getCourseStatus(id);

            for(Integer statu : status) {
                System.out.println("Status: " + statu);
            }

            req.setAttribute("status", status);
            req.setAttribute("courseId", id);
            req.getRequestDispatcher("/WEB-INF/views/instructor/students.jsp").forward(req, resp);
        }
    }

    private void handleDashboard(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
        List<Course> courses = InstructorDaoMySql.getInstance().getInstructorCourses(id);
        req.setAttribute("courses", courses);
        req.getRequestDispatcher("/WEB-INF/views/instructor/dashboard.jsp").forward(req, resp);
    }

    private int getCurrentCourseId(HttpServletRequest req) {
        String courseIdParam = req.getParameter("courseId");
        if (courseIdParam == null) {
            return 0;
        } else {
            int id = Integer.parseInt(courseIdParam);
            return id;
        }
    }
}
