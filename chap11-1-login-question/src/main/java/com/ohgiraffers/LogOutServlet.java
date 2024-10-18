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
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue() + "-=---" + cookies[i].getMaxAge());
            if(cookies[i].getName().equals("loggedIn")){
                cookies[i].setMaxAge(1);
                System.out.println(cookies[i].getName());
                System.out.println(cookies[i].getValue());
                System.out.println(cookies[i].getMaxAge());
                System.out.println("2222");
            }
        }
        resp.sendRedirect("/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue()  + "-====" + cookies[i].getMaxAge());
            if(cookies[i].getName().equals("loggedIn")){
                cookies[i].setMaxAge(1);
                System.out.println("1111");
            }
        }
        resp.sendRedirect("/login.jsp");

    }
}
