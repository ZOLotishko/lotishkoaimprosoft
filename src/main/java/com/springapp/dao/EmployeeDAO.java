package com.springapp.dao;


import com.springapp.entity.Employee;

import java.util.List;

/**
 * Created on 04.04.16.
 */
public interface EmployeeDAO {

    @com.springapp.dao.support.Connection
    Employee readEmployeeByID(Integer id);

    @com.springapp.dao.support.Connection
    void deleteEmployee(Integer id);

    @com.springapp.dao.support.Connection
    List<Employee> readEmployeeByIDDepartment(Integer id);

    @com.springapp.dao.support.Connection
    boolean checkEmail(String email, Integer id);

    @com.springapp.dao.support.Connection
    void createOrUpdateEmployee(Employee employee);
}
