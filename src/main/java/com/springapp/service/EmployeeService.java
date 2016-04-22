package com.springapp.service;


import com.springapp.entity.Employee;
import com.springapp.exeption.ValidationException;

import java.util.List;

/**
 * Created on 05.04.16.
 */
public interface EmployeeService {


    Employee read(Integer id);

    void delete(Integer id);

    List<Employee> getAllEmployeesInDepartment(Integer id);

    void createOrUpdateEmployee(Employee employee) throws ValidationException;

}
