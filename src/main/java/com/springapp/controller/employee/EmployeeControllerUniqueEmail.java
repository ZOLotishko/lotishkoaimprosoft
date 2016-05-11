package com.springapp.controller.employee;

import com.springapp.controller.InternalController;
import com.springapp.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 11.05.16.
 */
@Component("/uniqueEmail")
public class EmployeeControllerUniqueEmail implements InternalController {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idd = null;
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        if (!id.equals("")) {
            idd = Integer.parseInt(id);
        }
        String i = String.valueOf(employeeDAO.checkEmail(email, idd));
        response.getWriter().write(i);
    }
}
