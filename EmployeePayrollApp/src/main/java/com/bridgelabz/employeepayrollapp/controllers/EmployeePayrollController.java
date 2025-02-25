package com.bridgelabz.employeepayrollapp.controllers;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/service")
public class EmployeePayrollController {

    @Autowired EmployeePayrollService empService;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList=null;
        empDataList=empService.getEmployeePayrollData();
        ResponseDTO resDTO=new ResponseDTO("Get call success", empDataList);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId){
        EmployeePayrollData empData=null;
        empData=empService.getEmployeePayrollDataById(empId);
        ResponseDTO resDTO=new ResponseDTO("Get call success for id: ", empData);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData=null;
        empData=empService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO resDTO=new ResponseDTO("Created employee payroll data successfully", empData);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData=null;
        empData=empService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO resDTO=new ResponseDTO("update employee data successful", empData);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        empService.deleteEmployeePayrollData(empId);
        ResponseDTO resDTO=new ResponseDTO("deleted successfully", "delete id: "+empId);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }
}
