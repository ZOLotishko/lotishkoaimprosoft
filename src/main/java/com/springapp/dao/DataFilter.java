package com.springapp.dao;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created on 12.04.16.
 */
public class DataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

//    private String encoding;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        encoding = filterConfig.getInitParameter("requestEncoding");
//        if( encoding == null) encoding = "UTF-8";
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        request.setCharacterEncoding("UTF-8");
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {}


}
