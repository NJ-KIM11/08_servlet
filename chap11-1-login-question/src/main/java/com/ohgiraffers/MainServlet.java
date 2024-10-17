package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loggedIn = "";
        Cookie[] cookies = req.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("[cookie] " + cookies[i].getName() + " : " + cookies[i].getValue());
            if(cookies[i].getName().equals("loggedIn")){
                loggedIn=cookies[i].getValue();
            }
        }
        if(loggedIn.equals("")){
            resp.sendRedirect("/login.jsp");
        }
        else{
//            String userId = (String)req.getAttribute("userId");
            StringBuilder responseText = new StringBuilder();
            resp.setContentType("text/html;charset=UTF-8");
            responseText.append("<!doctype html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("<title>Main</title>\n") // 페이지 제목
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>환영합니다! ")
                    .append(loggedIn)
                    .append(" 님 </h1>\n")
                    .append("<a href=\"logout\">로그아웃</a>")
                    .append("</body>\n")
                    .append("</html>");
            PrintWriter out = resp.getWriter();
            out.print(responseText);
            out.flush();
            out.close();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String userId = (String)req.getAttribute("userId");
            StringBuilder responseText = new StringBuilder();
            resp.setContentType("text/html;charset=UTF-8");
            responseText.append("<!doctype html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("<title>Main</title>\n") // 페이지 제목
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>환영합니다! ")
                    .append(userId)
                    .append(" 님 </h1>\n")
                    .append("<a href=\"logout\">로그아웃</a>")
                    .append("</body>\n")
                    .append("</html>");
            PrintWriter out = resp.getWriter();
            out.print(responseText);
            out.flush();
            out.close();

    }
}
