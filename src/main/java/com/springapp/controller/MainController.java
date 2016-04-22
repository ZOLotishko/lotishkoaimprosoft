package com.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 04.04.16.
 */
@Component(value = "aimprosoft")
public class MainController implements HttpRequestHandler {

    @Autowired
    private ApplicationContext applicationContext;


    @Override
    public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String url = httpServletRequest.getRequestURI();
        InternalController internalController = (InternalController) applicationContext.getBean(url);
        internalController.execute(httpServletRequest, httpServletResponse);
    }
}
