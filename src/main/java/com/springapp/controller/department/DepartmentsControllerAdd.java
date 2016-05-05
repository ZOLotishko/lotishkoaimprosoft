package com.springapp.controller.department;

import com.springapp.controller.InternalController;
import com.springapp.entity.Department;
import com.springapp.exeption.ValidationException;
import com.springapp.service.DepartmentService;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
@Component("/saveDepartment")
public class DepartmentsControllerAdd implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department department = new Department();
        String id = request.getParameter("id");
        String name = request.getParameter("n");

        department.setId(Utils.parseStringToInteger(id));
        department.setName(name);

        try {
            departmentService.createOrUpdate(department);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}