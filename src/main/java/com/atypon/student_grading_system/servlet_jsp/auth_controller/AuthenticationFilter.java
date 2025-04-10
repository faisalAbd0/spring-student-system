//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.atypon.student_grading_system.servlet_jsp.auth_controller;

import com.atypon.student_grading_system.models.USER;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/student/*", "/instructor/*", "/admin/*"}
)
public class AuthenticationFilter implements Filter {
    public AuthenticationFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        HttpSession session = req.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("userId") != null;
        if (loggedIn) {
            USER userType = (USER)session.getAttribute("userType");
            String requestURI = req.getRequestURI();
            if (userType == USER.STUDENT && !requestURI.contains("/student/") || userType == USER.INSTRUCTOR && !requestURI.contains("/instructor/") || userType == USER.ADMIN && !requestURI.contains("/admin/")) {
                resp.sendRedirect(req.getContextPath() + "/unauthorized.jsp");
                return;
            }

            filterChain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
        }

    }
}
