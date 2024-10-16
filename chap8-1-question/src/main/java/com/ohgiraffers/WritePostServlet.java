package com.ohgiraffers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/writepost")
public class WritePostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean titleIsValid = title.length() >= 5;
        boolean contentIsValid = content.length() >= 10;

        if (titleIsValid && contentIsValid) {
            RequestDispatcher rd = req.getRequestDispatcher("print");
            rd.forward(req, resp);
        }else{
            req.setAttribute("titleIsValid", titleIsValid);
            req.setAttribute("contentIsValid", contentIsValid);

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);
        }


    }
}
