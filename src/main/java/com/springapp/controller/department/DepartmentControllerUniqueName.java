package com.springapp.controller.department;

import com.springapp.controller.InternalController;
import com.springapp.dao.DepartmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 11.05.16.
 */
@Component("/uniqueName")
public class DepartmentControllerUniqueName implements InternalController {

    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idd = null;
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        if (!id.equals("")) {
            idd = Integer.parseInt(id);
        }
        String i = String.valueOf(departmentDAO.checkName(name, idd));
        response.getWriter().write(i);
    }
}
