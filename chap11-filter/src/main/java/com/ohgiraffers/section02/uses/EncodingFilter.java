package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encodingType;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // filterConfig 는 parameter 를 가져올수 있는 객체
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;
        hresponse.setContentType(encodingType);

        filterChain.doFilter(servletRequest, hresponse);

        // web.xml 에서 mapping에 /* 을 주었기 때문에 모든 request는 이 filter(EncodingFilter)를 거치게 된다..
        // EncodingFilter 에서 setContentType 을 해주기 때문에 모든 request 는 자동으로 contentType 이 정해진다..
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
