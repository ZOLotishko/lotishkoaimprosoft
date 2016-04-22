package com.springapp.validation;

import com.springapp.dao.DepartmentDAO;
import com.springapp.entity.Department;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created
 */
@Component
public class CheckWithDepartment implements CheckWithCheck.SimpleCheck {
    @Autowired
    DepartmentDAO departmentService;

    @Override
    public boolean isSatisfied(Object validatedObject, Object value) {

        try {
            return departmentService.checkName(((Department) validatedObject).getName(), ((Department) validatedObject).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
