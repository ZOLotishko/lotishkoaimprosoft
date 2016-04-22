package com.springapp.exeption;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 21.04.16.
 */
@Component
public class NotFoundException {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {

        ModelAndView mav = new ModelAndView("exception");
        mav.addObject("name", e.getClass().getSimpleName());
        mav.addObject("message", e.getMessage());

        return mav;
    }
}