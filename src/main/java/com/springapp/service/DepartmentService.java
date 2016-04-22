package com.springapp.service;


import com.springapp.entity.Department;
import com.springapp.exeption.ValidationException;

import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentService {


    Department read(Integer id);

    void delete(Integer id);

    List<Department> getAll();

    void createOrUpdate(Department department) throws ValidationException;
}
