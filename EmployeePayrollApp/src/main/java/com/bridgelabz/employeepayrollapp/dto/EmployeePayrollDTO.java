package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.NonNull;
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

    @Pattern(regexp = "male|female", message = "gender needs to be male or female")
    private String gender;

    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "startDate should not be empty")
    @PastOrPresent(message = "startDate should be past or today's date")
    private LocalDate startDate;

    @NotBlank(message = "note cannot be empty")
    private String note;

    @NotBlank(message = "profilePic cannot be empty")
    private String profilePic;

    @NotNull(message = "department should not be empty")
    private List<String> departments;
}
