package com.springapp.controller.department;

import com.springapp.controller.InternalController;
import com.springapp.entity.Department;
import com.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created on 04.04.16.
 */
@Component("/aimprosoft/")
public class DepartmentsControllerShowAll implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> dep;
//        try {
        dep = departmentService.getAll();
//        } catch (SQLException e) {
//            response.sendRedirect("/aimprosoft/error");
//        }
        request.setAttribute("dep", dep);
        request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
    }
}
