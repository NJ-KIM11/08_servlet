package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet("/joinmember")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");


        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        String password2 = req.getParameter("passwordConfirm");
        String type = String.valueOf(name.getClass());

        PrintWriter out = resp.getWriter();

        if(name.length() >= 2 && phoneNumber.length() == 11 && password.length() >= 8 && password.equals(password2)
            && Pattern.matches("^[a-z|A-Z|ㄱ-ㅎ|가-힣| ]*$", name) && Pattern.matches("^[0-9]*$", phoneNumber)){
            out.print("<h1>환영합니다. " + name+ "님</h1>");
        }else if(name.length() < 2){
            out.print("<h1>이름은 2글자 이상이어야 합니다</h1>");
            out.print("<h1>"+ type +"</h1>");
            out.print("<h1>"+ name +"</h1>");

        }else if(!Pattern.matches("^[a-z|A-Z|ㄱ-ㅎ|가-힣| ]*$", name)){
            out.print("<h1>이름은 한글 혹은 영문만 가능</h1>");
        }else if(!Pattern.matches("^[0-9]*$", phoneNumber)){
            out.print("<h1>전화번호는 숫자만 가능</h1>");
        }else if(phoneNumber.length() != 11){
            out.print("<h1>전화번호는 11자리로 입력되어야 합니다.</h1>");
        }else if(password.length() < 8 || !(password.equals(password2))){
            out.print("<h1>비밀번호는 8자 이상이며 비밀번호 확인과 일치해야 합니다.</h1>");
        }
        else{
            out.print("<h1>회원가입 실패!! 입력정보를 확인 해주세요!</h1>");
        }
        out.close();
    }
}
