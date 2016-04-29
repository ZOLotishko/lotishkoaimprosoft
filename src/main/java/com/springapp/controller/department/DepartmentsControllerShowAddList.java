package com.springapp.controller.department;

import com.springapp.controller.InternalController;
import com.springapp.entity.Department;
import com.springapp.service.DepartmentService;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 07.04.16.
 */
@Component("/aimprosoft/addDepartment")
public class DepartmentsControllerShowAddList implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("department_id");

        if (id != null) {
            Department department;
            department = departmentService.read(Utils.parseStringToInteger(id));
            if (department != null) {
                request.setAttribute("department", department);
            }
        }
        request.getRequestDispatcher("/jsp/addDepartments.jsp").forward(request, response);
    }
}
