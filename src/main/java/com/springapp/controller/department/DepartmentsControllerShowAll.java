package com.springapp.controller.department;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springapp.controller.InternalController;
import com.springapp.entity.Department;
import com.springapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created on 04.04.16.
 */
@Component("/list")
public class DepartmentsControllerShowAll implements InternalController {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try(Reader reader = new InputStreamReader(DepartmentsControllerShowAll.class.getResourceAsStream("/Server1.json"), "UTF-8")) {
//            Gson gson = new GsonBuilder().create();
//            Department p = gson.fromJson(reader, Department.class);
//            response.getWriter().write(String.valueOf(p));
//        }
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(departmentService.getAll());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);


//        List<Department> dep;
//        dep = departmentService.getAll();
//        request.setAttribute("dep", dep);
//        request.getRequestDispatcher("/jsp/listDepartment.jsp").forward(request, response);
    }
}
