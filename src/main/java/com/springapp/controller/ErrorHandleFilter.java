package com.springapp.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by
 */
public class ErrorHandleFilter implements Filter {
//    private final Logger logger = LoggerFactory.getLogger(ErrorHandleFilter.class);

    //Your custom bean to handle error
//    ErrorHandlerSpecialForce errHandle;

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        //Get bean from Spring container
//        errHandle = (ErrorHandlerSpecialForce) WebApplicationContextUtils
//                .getRequiredWebApplicationContext(filterConfig.getServletContext())
//                .getBean("errorHandlerSpecialForce");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex);
            request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
        }
    }
}
