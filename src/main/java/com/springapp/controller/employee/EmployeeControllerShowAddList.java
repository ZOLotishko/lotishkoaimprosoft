package com.springapp.controller.employee;

import com.springapp.controller.InternalController;
import com.springapp.entity.Employee;
import com.springapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07.04.16.
 */
@Component("/aimprosoft/addEmployee")
public class EmployeeControllerShowAddList implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            Employee employee;
           /* try {*/
            employee = employeeService.read(Integer.parseInt(id));
            /*} catch (SQLException e) {
                response.sendRedirect("/aimprosoft/error");
            }*/
            if (employee != null) {
                request.setAttribute("emp", employee);
                request.setAttribute("department_id", request.getParameter("department_id"));
            }
        }
        request.getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);
    }
}
