package com.springapp.controller.employee;

import com.springapp.controller.InternalController;
import com.springapp.entity.Employee;
import com.springapp.service.EmployeeService;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 06.04.16.
 */
@Component("/listEmployees")
public class EmployeeControllerShowList implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("department_id");

        if (id != null) {
            Integer depId = Utils.parseStringToInteger(id);
            List<Employee> employees;
//            try {
            employees = employeeService.getAllEmployeesInDepartment(depId);
//            } catch (SQLException e) {
//                response.sendRedirect("/aimprosoft/error");
//            }
            if (employees != null) {
                request.setAttribute("department_id", depId);
                request.setAttribute("emp", employees);
            }
        }
        request.getRequestDispatcher("/jsp/listEmployee.jsp").forward(request, response);
    }
}
