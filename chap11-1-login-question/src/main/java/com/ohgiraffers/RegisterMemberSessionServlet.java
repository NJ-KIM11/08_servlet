package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register/member")
public class RegisterMemberSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("password", password);
        session.setAttribute("email", email);

        resp.sendRedirect("/login.jsp");
    }
}
