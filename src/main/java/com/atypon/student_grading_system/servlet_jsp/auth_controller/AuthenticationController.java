//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.servlet_jsp.auth_controller;

import com.atypon.student_grading_system.global.ValidateCredential;
import com.atypon.student_grading_system.models.IUser;
import com.atypon.student_grading_system.models.USER;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(
        urlPatterns = {"/login"}
)
public class AuthenticationController extends HttpServlet {
    public AuthenticationController() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");
        System.out.println("Username: " + username + " Password: " + password + " UserType: " + userType);
        USER type = null;
        if (userType.equals("student")) {
            type = USER.STUDENT;
        } else if (userType.equals("instructor")) {
            type = USER.INSTRUCTOR;
        } else if (userType.equals("admin")) {
            type = USER.ADMIN;
        } else {
            req.setAttribute("errorMessage", "Invalid user type selected");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }

        Optional<IUser> user = ValidateCredential.checkUserCredentials(username, password, type);
        if (user.isPresent()) {
            this.sessionLogin(req, resp, ((IUser)user.get()).getId(), type, username);
        } else {
            req.setAttribute("errorMessage", "Invalid user credentials");
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        }

    }

    private void sessionLogin(HttpServletRequest req, HttpServletResponse resp, int id, USER type, String username) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("userId", id);
        session.setAttribute("userType", type);
        session.setAttribute("username", username);
        session.setMaxInactiveInterval(1800);
        String targetController;
        switch (type) {
            case STUDENT -> targetController = "/student/dashboard";
            case INSTRUCTOR -> targetController = "/instructor/dashboard";
            case ADMIN -> targetController = "/admin/dashboard";
            default -> targetController = "/";
        }

        String var10001 = req.getContextPath();
        resp.sendRedirect(var10001 + targetController);
    }
}
