package com.springapp.validation;

import com.springapp.dao.EmployeeDAO;
import com.springapp.entity.Employee;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by
 */
@Component
public class CheckWithEmployee implements CheckWithCheck.SimpleCheck {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {
        try {
            return employeeDAO.checkEmail(((Employee) validatedObject).getEmail(), ((Employee) validatedObject).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
