package com.ohgiraffers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class RequestWrapper extends HttpServletRequestWrapper {

    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = "";
        if(name.equals("password")){
            BCryptPasswordEncoder pswEncoder = new BCryptPasswordEncoder();
            value = pswEncoder.encode(super.getParameter(name));
        }else{
            value = super.getParameter(name);
        }
        return value;
    }
}
