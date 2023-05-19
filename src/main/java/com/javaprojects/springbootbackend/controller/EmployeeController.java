package com.javaprojects.springbootbackend.controller;


import com.javaprojects.springbootbackend.model.Employee;
import com.javaprojects.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
   //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    // build get all employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // build get employee by id

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }
   // build update employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId),HttpStatus.OK);
    }

    // build delete employee by id REST API

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully...",HttpStatus.OK);
    }




}
