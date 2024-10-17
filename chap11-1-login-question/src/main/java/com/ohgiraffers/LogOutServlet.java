package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());
            if(cookies[i].getName().equals("loggedIn")){
                cookies[i].setMaxAge(1);
            }
        }
        resp.sendRedirect("/login.jsp");

    }
}
