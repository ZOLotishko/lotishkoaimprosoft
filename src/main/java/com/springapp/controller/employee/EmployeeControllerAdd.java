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
import java.sql.Date;

/**
 * Created on 06.04.16.
 */
@Component("/saveEmployee")
public class EmployeeControllerAdd implements InternalController {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String salary = request.getParameter("salary");
        String department_id = request.getParameter("department_id");
        if (id != "") {
            employee.setId(Integer.parseInt(id));
        }

        employee.setName(name);
        employee.setEmail(email);
        employee.setDate(Date.valueOf(date));
        employee.setSalary(Utils.parseStringToDouble(salary));
        employee.setDepartment_id(Integer.parseInt(department_id));

        System.out.println(employee);

        try {
            employeeService.createOrUpdateEmployee(employee);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

    }
}
