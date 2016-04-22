package com.springapp.dao;


import com.springapp.entity.Department;

import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface DepartmentDAO {

    @com.springapp.dao.support.Connection
    Department readDepartmentByID(Integer id);

    @com.springapp.dao.support.Connection
    List<Department> readDepartments();

    @com.springapp.dao.support.Connection
    void deleteDepartment(Integer id);

    @com.springapp.dao.support.Connection
    boolean checkName(String name, Integer id);

    @com.springapp.dao.support.Connection
    void createOrUpdateDepartment(Department department);
}
