package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cant be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name invalid")
    public String name;

    @Min(value = 500, message = "min wage should be more than 500")
    public long salary;

    public EmployeePayrollDTO(String name, long salary){
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "name="+name+":salary="+salary;
    }
}
