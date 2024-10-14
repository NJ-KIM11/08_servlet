package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 지금 받아온 것들 ServletRequest req, ServletResponse res 이 사실은 HttpServletRequest, HttpServletResponse 이기 때문에
        // 다운캐스팅 해주어야 한다.
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        // httpRequest의 getMethod() 는 어떠한 http method 요청이 들어온 건지
        // 문자열로 반환한다.
        String httpMethod = httpRequest.getMethod();
        System.out.println("httpMethod : " + httpMethod);

        if(("GET").equals(httpMethod)) {
            doGet(httpRequest, httpResponse);
        }else if(("POST").equals(httpMethod)) {
            doPost(httpRequest, httpResponse);
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }


}
