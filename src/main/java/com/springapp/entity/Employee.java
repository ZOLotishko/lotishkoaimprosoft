package com.springapp.entity;

import com.springapp.validation.CheckWithEmployee;
import net.sf.oval.constraint.*;

import java.util.Date;

/**
 * Created on 04.04.16.
 */
public class Employee {

    private Integer id;

    @NotEmpty(message = "Field name is empty")
    @NotNull(message = "Field name is empty")
    @Length(min = 1, max = 20, message = "insert minimum 1 char")
    private String name;

    @NotNull(message = "Field email is empty")
    @NotEmpty(message = "Field email is empty")
    @Email(message = "incorrect email format")
    @CheckWith(value = CheckWithEmployee.class, message = "This email already exist")

    private String email;

    @NotNull(message = "Incorrect date format")
    @NotEmpty(message = "Field date is empty")
    private Date date;

    @NotNull(message = "Field salary is empty")
    @NotEmpty(message = "Field salary is empty")
    @Length(min = 1, message = "insert minimum 1 int")
    @NotNegative(message = "Salary can't be negative")
    private Double salary;

    private Integer department_id;

    public Employee() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", date=" + date +
                ", department_id=" + department_id +
                '}';
    }
}
