package com.ohgiraffers.section01.queryString;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;


@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    // 동적 바인딩으로 어느 doGet으로 갈지는 실행된 시점에 결정된다

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // service 로 부터 전달받은 HttpServletRequest 는
        // 요청시 전달한 값을 getParameter() 로 추출할 수 있다..
        // 이 때 인자로 input 태그에 지정한 name 속성의 값을 문자열 형태로 전달하면 된다..

        String name = req.getParameter("name");
        System.out.println("이름 : " + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 : " + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        // radio 태그는 여러 값 중 선택된 하나의 값만 전달된다..
        String gender = req.getParameter("gender");
        System.out.println("성병 : " + gender);

        // selectbox 도 동일하다
        String nationality = req.getParameter("national");
        System.out.println("국적 : " + nationality);

        // checkbox 는 다중으로 입력을 받을수 있어, 선택된 값이 문자열 배열로 전달된다.
        System.out.println("취미 : ");
        String[] hobbys = req.getParameterValues("hobbies");
        for (String hobby : hobbys) {
            System.out.println(hobby);
        }


        /*
        *   getParameterMap() - 모든 데이터를 key, value 형태로 일괄 반환
        * */

        Map<String, String[]> requestMap = req.getParameterMap();

        for (Map.Entry<String, String[]> entry : requestMap.entrySet()){
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        }

        System.out.println("==========================");

        for (Map.Entry<String, String[]> entry : requestMap.entrySet()){
            Iterator<String> iterator = Arrays.asList(entry.getValue()).iterator();
            System.out.print(entry.getKey() + " : " );
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

        System.out.println("==========================");

        for (Map.Entry<String, String[]> entry : requestMap.entrySet()){
//            Iterator<String> iterator = Arrays.asList(entry.getValue()).iterator();
            System.out.print(entry.getKey() + " : " );
            for (String value : entry.getValue()){
                System.out.println(value);
            }
        }

    }
}
