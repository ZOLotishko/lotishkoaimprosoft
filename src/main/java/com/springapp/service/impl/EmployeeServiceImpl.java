package com.springapp.service.impl;


import com.springapp.dao.EmployeeDAO;
import com.springapp.entity.Employee;
import com.springapp.exeption.ValidationException;
import com.springapp.service.EmployeeService;
import com.springapp.validation.MyValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created on 05.04.16.
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private MyValidation myValidation;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public Employee read(Integer id) {
        return employeeDAO.readEmployeeByID(id);
    }

    @Override
    public void delete(Integer id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeesInDepartment(Integer id) {
        return employeeDAO.readEmployeeByIDDepartment(id);
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) throws ValidationException {
        Map<String, String> errors = myValidation.validation(employee);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        employeeDAO.createOrUpdateEmployee(employee);
    }
}
