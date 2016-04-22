package com.springapp.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 04.04.16.
 */
public interface InternalController {

    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
