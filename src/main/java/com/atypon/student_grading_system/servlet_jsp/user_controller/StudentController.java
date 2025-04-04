//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.servlet_jsp.user_controller;

import com.atypon.student_grading_system.data.MySqlDao.GradeDaoMySql;
import com.atypon.student_grading_system.data.MySqlDao.StudentDaoMySql;
import com.atypon.student_grading_system.models.Grade;
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
        urlPatterns = {"/student/*"}
)
public class StudentController extends HttpServlet {
    public StudentController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                case "dashboard" -> this.handleDashboard(req, resp, id);
                case "profile" -> this.handleProfile(req, resp, id);
                default -> this.handleDashboard(req, resp, id);
            }

        } else {
            req.setAttribute("errorMessage", "You are not logged in!");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }
    }

    private void handleDashboard(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
        List<Grade> grades = GradeDaoMySql.getInstance().getGradesById(id);
        req.setAttribute("grades", grades);
        req.getRequestDispatcher("/WEB-INF/views/student/dashboard.jsp").forward(req, resp);
    }

    private void handleProfile(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException {
        Student student = StudentDaoMySql.getInstance().getStudentById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/WEB-INF/views/student/profile.jsp").forward(req, resp);
    }
}
