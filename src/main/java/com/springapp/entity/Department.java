package com.springapp.entity;

import com.google.gson.annotations.Expose;
import com.springapp.validation.CheckWithDepartment;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * Created by on 04.04.16.
 */
public class Department {


    private Integer id;
    @NotNull(message = "Name can`t be empty")
    @NotEmpty(message = "Name can`t be empty")
    @Length(min = 2, max = 20, message = "Error Length")
    @CheckWith(value = CheckWithDepartment.class, message = "This name already exists")

    private String name;

    public Department(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
