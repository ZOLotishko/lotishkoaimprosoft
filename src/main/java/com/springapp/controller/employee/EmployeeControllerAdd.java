package com.springapp.controller.employee;

import com.springapp.controller.InternalController;
import com.springapp.entity.Employee;
import com.springapp.exeption.ValidationException;
import com.springapp.service.EmployeeService;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 06.04.16.
 */
@Component("/aimprosoft/addEmployees")
public class EmployeeControllerAdd implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Employee employee = new Employee();
//
//        employee.setId(Utils.parseStringToInteger(request.getParameter("id")));
//        employee.setName(request.getParameter("name"));
//        employee.setEmail(request.getParameter("email"));
//        employee.setDate(Utils.parseStringToDate(request.getParameter("date")));
//        employee.setSalary(Utils.parseStringToDouble(request.getParameter("salary")));
//        employee.setDepartment_id(Utils.parseStringToInteger(request.getParameter("department_id")));
//
//        try {
////            try {
//            employeeService.createOrUpdateEmployee(employee);
////            } catch (SQLException e) {
////                response.sendRedirect("/error");
////            }
//            response.sendRedirect("/aimprosoft/listEmployees?department_id=" + employee.getDepartment_id());
//        } catch (ValidationException e) {
//            request.setAttribute("emp", employee);
//            request.setAttribute("department_id", request.getParameter("department_id"));
//            request.setAttribute("error", e.getError());
//            request.getRequestDispatcher("/jsp/addEmployee.jsp").forward(request, response);
//
//        }
    }
}
