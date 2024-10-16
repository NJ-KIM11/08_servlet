package com.ohgiraffers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/checkvalid")
public class LoginCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        String checkId = (String)session.getAttribute("userId");
        String checkPassword = (String)session.getAttribute("password");

        BCryptPasswordEncoder pswEncoder = new BCryptPasswordEncoder();

        boolean validCheck = pswEncoder.matches(password, checkPassword);
        boolean idCheck = userId.equals(checkId);

        if (validCheck && idCheck) {
            req.setAttribute("userId", userId);

            Cookie loggedInCookie = new Cookie("loggedIn", userId);
            loggedInCookie.setMaxAge(20);
            resp.addCookie(loggedInCookie);

            RequestDispatcher rd = req.getRequestDispatcher("main");
            rd.forward(req, resp);


        }else{
            String checkStatement = "id나비밀번호가다릅니다.";
            Cookie statementCookie = new Cookie("checkStatement", checkStatement);
            resp.addCookie(statementCookie);
            resp.sendRedirect("/login.jsp");

//            req.setAttribute("checkStatement", checkStatement);
//            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//            rd.forward(req, resp);
        }

    }
}
