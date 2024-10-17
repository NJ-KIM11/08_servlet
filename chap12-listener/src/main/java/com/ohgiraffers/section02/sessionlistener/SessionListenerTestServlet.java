package com.ohgiraffers.section02.sessionlistener;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("발급받은 session id : " + session.getId());

        session.setAttribute("username", "honggildong");

        session.setAttribute("username", "hong");

        session.invalidate();
    }
}
