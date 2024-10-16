package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        RequestWrapper wrapper = new RequestWrapper(hrequest);

        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
