package com.springapp.dao.impl;

import com.springapp.dao.EmployeeDAO;
import com.springapp.entity.Employee;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee readEmployeeByID(Integer id) {

        String sql = "SELECT * From employee WHERE id = ?";
        Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Employee.class));
        return employee;
    }

    //    @Override
    public List<Employee> readEmployees() {
        String sql = "SELECT id, name, email, date, salary, department_id FROM employee ";
        List<Employee> employees = fillEmployee(sql);
        return employees;
    }

    @Override
    public void deleteEmployee(Integer id) {
        String sql = "DELETE FROM employee WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Employee> readEmployeeByIDDepartment(Integer id) {
        String sql = "SELECT id, name, email, date, salary, department_id FROM employee WHERE department_id = " + id;
        List<Employee> employees = fillEmployee(sql);
        return employees;
    }

    @Override
    public boolean checkEmail(String email, Integer id) {
        String sql = "SELECT * FROm employee WHERE email = ? ";
        try {
            Employee employee = (Employee) jdbcTemplate.queryForObject(sql, new Object[]{email}, new BeanPropertyRowMapper(Employee.class));
            Integer emp_id = employee.getId();
            if (emp_id != id) {
                return false;
            }
        } catch (EmptyResultDataAccessException e) {
            return true;
        }
        return true;
    }

    @Override
    public void createOrUpdateEmployee(Employee employee) {

        String sql;
        Integer id = employee.getId();
        if (id != null) {
            sql = "UPDATE employee SET name = ?, email = ?, date = ?, salary = ?, department_id = ? WHERE id = " + id;
            jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()});
        } else {
            sql = "INSERT into employee (name, email, date, salary, department_id) VALUES(?,?,?,?,?) ";
            jdbcTemplate.update(sql, new Object[]{employee.getName(), employee.getEmail(), employee.getDate(), employee.getSalary(), employee.getDepartment_id()});
        }
    }

    private List<Employee> fillEmployee(String sql) {
        List<Employee> employees = new ArrayList<Employee>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Employee employee = new Employee();
            employee.setId(Utils.parseStringToInteger(String.valueOf(row.get("id"))));
            employee.setName((String) row.get("name"));
            employee.setEmail((String) row.get("email"));
            employee.setDate((Date) row.get("date"));
            employee.setSalary(Utils.parseStringToDouble(String.valueOf(row.get("salary"))));
            employee.setDepartment_id(Utils.parseStringToInteger(String.valueOf(row.get("department_id"))));
            employees.add(employee);
        }
        return employees;
    }
}
