package com.bridgelabz.employeepayrollapp.controllers;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData(){
        return new ResponseEntity<>("Get call success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<>("Get call success for id: "+empId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1, empPayrollDTO.name, empPayrollDTO.salary);
        ResponseDTO resDTO=new ResponseDTO("Created employee payroll data successfully", empData);
        return new ResponseEntity<>(resDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(){
        return new ResponseEntity<>("update employee data successful", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<>("delete call success for id: "+empId, HttpStatus.OK);
    }
}
