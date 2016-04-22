package com.springapp.controller.employee;

import com.springapp.controller.InternalController;
import com.springapp.service.EmployeeService;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by on 11.04.2016.
 */
@Component("/aimprosoft/deleteEmployee")
public class EmployeeControllerDelete implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Utils.parseStringToInteger(request.getParameter("id"));
        Integer depId = Utils.parseStringToInteger(request.getParameter("department_id"));
//        try {
        employeeService.delete(id);
//        } catch (SQLException e) {
//            response.sendRedirect("/error");
//        }
        String url = "/aimprosoft/listEmployees?department_id=" + depId;
        response.sendRedirect(url);

    }
}
