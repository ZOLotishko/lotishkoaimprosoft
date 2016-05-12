package com.springapp.controller.department;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springapp.controller.InternalController;
import com.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 12.05.16.
 */
@Component("/showAddDep")
public class DepartmentControllerShowAdd implements InternalController {
    @Autowired
    DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getParameter("id");
        if (!s.equals("")) {
            Integer id = Integer.parseInt(s);
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(departmentService.read(id));
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
    }
}
