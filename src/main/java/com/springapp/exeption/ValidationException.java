package com.springapp.exeption;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 08.04.16.
 */
public class ValidationException extends Exception {

    private Map<String, String> error = new HashMap<String, String>();

    public ValidationException(Map<String, String> error){
        this.error = error;
    }

    public Map<String, String > getError(){
        return error;
    }

}
