package com.springapp.controller.employee;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springapp.controller.InternalController;
import com.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 12.05.16.
 */
@Component("/showAddEmp")
public class EmployeeControllerShowAdd implements InternalController {
    @Autowired
    EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        if (!s.equals("")) {
            Integer id = Integer.parseInt(s);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            String json = gson.toJson(employeeService.read(id));
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
}
