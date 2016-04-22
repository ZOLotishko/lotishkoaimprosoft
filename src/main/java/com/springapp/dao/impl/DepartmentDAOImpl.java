package com.springapp.dao.impl;

import com.springapp.dao.DepartmentDAO;
import com.springapp.entity.Department;
import com.springapp.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 04.04.16.
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Department readDepartmentByID(Integer id) {
        try {
            String sql = "SELECT id, name FROM department WHERE id = ?";
            return (Department) jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(Department.class));
        } catch (EmptyResultDataAccessException e) {
            Department department = new Department();
            return department;
        }
    }

    @Override
    public List<Department> readDepartments() {
        String sql = "SELECT * FROM department ";
        List<Department> departments = new ArrayList<Department>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Department department = new Department();
            department.setId(Utils.parseStringToInteger(String.valueOf(row.get("id"))));
            department.setName((String) row.get("name"));
            departments.add(department);
        }
        return departments;
    }

    @Override
    public void deleteDepartment(Integer id) {
        String sql = "DELETE FROM department WHERE id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public boolean checkName(String name, Integer id) {
        try {
            String sql = "SELECT * FROM department WHERE name = ?";
            Department department = (Department) jdbcTemplate.queryForObject(sql, new Object[]{name}, new BeanPropertyRowMapper(Department.class));
            Integer dep_id = department.getId();
            if (dep_id != id) {
                return false;
            }
        } catch (EmptyResultDataAccessException e) {
            return true;
        }
        return true;
    }

    @Override
    public void createOrUpdateDepartment(Department department) {
        String sql;
        Integer id = department.getId();
        if (id != null) {
            sql = "UPDATE department SET name = ? WHERE id = ?";
            jdbcTemplate.update(sql, department.getName(), id);
        } else {
            sql = "INSERT into department (name) VALUES (?)";
            jdbcTemplate.update(sql, department.getName());

        }
    }
}
