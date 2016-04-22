package com.springapp.service.impl;

import com.springapp.dao.DepartmentDAO;
import com.springapp.dao.EmployeeDAO;
import com.springapp.entity.Department;
import com.springapp.entity.Employee;
import com.springapp.exeption.ValidationException;
import com.springapp.service.DepartmentService;
import com.springapp.validation.MyValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
//@Component
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private MyValidation myValidation;
    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public Department read(Integer id) {
        return departmentDAO.readDepartmentByID(id);
    }

    @Override
    public void delete(Integer id) {

        List<Employee> employees = employeeDAO.readEmployeeByIDDepartment(id);
        if (!employees.isEmpty()) {
            for (Employee emp : employees) {
                employeeDAO.deleteEmployee(emp.getId());
            }
            departmentDAO.deleteDepartment(id);
        } else {
            departmentDAO.deleteDepartment(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> getAll() {
        return departmentDAO.readDepartments();
    }

    @Override
    public void createOrUpdate(Department department) throws ValidationException {

        Map<String, String> errors = myValidation.validation(department);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        }
        departmentDAO.createOrUpdateDepartment(department);
    }
}
