package com.springapp.validation;


//import net.sf.oval.ConstraintViolation;
//import net.sf.oval.Validator;
//import net.sf.oval.context.FieldContext;
//import net.sf.oval.context.OValContext;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 08.04.16.bb
 *
 */
@Repository("MyValidation")
public class MyValidation {

    private Validator validator ;

    public Map<String, String> validation(Object object) {

        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        myConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        validator = new Validator(myConfigurer);
        Map<String, String> error = new HashMap<>();

        List<ConstraintViolation> violations = validator.validate(object);
        if (violations.size() > 0) {
            for (ConstraintViolation constraintViolation : violations) {
                OValContext context = constraintViolation.getContext();
                if (context instanceof FieldContext) {
                    Field fieldContext = ((FieldContext) context).getField();
                    error.put(fieldContext.getName(), constraintViolation.getMessage());

                }
            }
        }
        return error;
    }
}
