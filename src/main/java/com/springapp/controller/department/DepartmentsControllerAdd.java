package com.springapp.controller.department;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springapp.controller.InternalController;
import com.springapp.entity.Department;
import com.springapp.exeption.ValidationException;
import com.springapp.service.DepartmentService;
import com.springapp.util.Utils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        String json = request.getParameter("department");
        System.out.println(json);
        String id = request.getParameter("id");
        department.setId(Utils.parseStringToInteger(id));
        department.setName(request.getParameter("name"));

//        String department = request.getParameter("department");
        try {
            departmentService.createOrUpdate(department);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


//

//        if (id != null) {
//            department = departmentService.read(Utils.parseStringToInteger(id));
//            if (department != null) {
//                request.setAttribute("department", department);
//            }
//        }
//        request.getRequestDispatcher("/jsp/addDepartments.jsp").forward(request, response);
//        try {
////            List<FileItem> list = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
////            for (FileItem item : list) {
//                String id = new String(item.get(), "UTF-8");
//                if (id != null) {
//                    department = departmentService.read(Utils.parseStringToInteger(id));
//                    if (department != null) {
//                        request.setAttribute("department", department);
//                    }
////                }
////                if (item.getFieldName().equals("id")) {
//
//                    department.setId(Utils.parseStringToInteger(id));
////                } else if (item.getFieldName().equals("name")) {
//                    String name = new String(item.get(), "UTF-8");
//                    department.setName(name);
////                }
//            }
//            departmentService.createOrUpdate(department);
//            response.sendRedirect("/");
//        } catch (ValidationException e) {
//            request.setAttribute("department", department);
//            request.setAttribute("error", e.getError());
//            request.getRequestDispatcher("/jsp/addDepartments.jsp").forward(request, response);
//        }
//        catch (Exception ex){
//
        }
//    }
//}
