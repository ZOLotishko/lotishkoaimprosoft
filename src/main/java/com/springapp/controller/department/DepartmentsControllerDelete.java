package com.springapp.controller.department;

import com.springapp.controller.InternalController;
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
@Component("/aimprosoft/deleteDepartment")
public class DepartmentsControllerDelete implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer action = Utils.parseStringToInteger(request.getParameter("department_id"));

//        try {
        departmentService.delete(action);
//        } catch (Exception e) {
//            response.sendRedirect("/aimprosoft/error");
//        }
        response.sendRedirect("/aimprosoft/");
    }
}
