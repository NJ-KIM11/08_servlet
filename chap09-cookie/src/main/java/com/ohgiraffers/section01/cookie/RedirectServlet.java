package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        Cookie[] cookies = req.getCookies();
        // request 에서 쿠키 목록을 쿠키 배열로 꺼내온다..
        // getName 과 getValue 를 이용해 쿠키에 담긴 값을 사용한다..

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())) {
                firstName = cookies[i].getValue();
            } else if("lastName".equals(cookies[i].getName())) {
                lastName = cookies[i].getValue();
            }
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h3> your first name is " + firstName + " and last name is " + lastName + "</h3>");
        out.flush();
        out.close();
    }
}


/*
*  쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다..
*  그렇게 때문에 개인 PC 는 크게 상관없지만 공용 PC 등 다른 사용자와
*  함께 쓰는 컴퓨터이면 보안에 취약하다..
*  따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다는 세션을 이용한다.
*  세션은 쿠키와 유사한 형태로 저장되지만 서버에서 관리되므로 보안에 더 우수하다는 장점을 가진다.
* */