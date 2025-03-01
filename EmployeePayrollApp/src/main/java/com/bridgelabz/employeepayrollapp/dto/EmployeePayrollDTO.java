package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cant be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name invalid")
    public String name;

    @Min(value = 500, message = "min wage should be more than 500")
    public long salary;

    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> departments;
}
