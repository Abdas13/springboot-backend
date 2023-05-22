package com.javaprojects.springbootbackend.service.impl;

import com.javaprojects.springbootbackend.exception.ResourceNotFoundException;
import com.javaprojects.springbootbackend.model.Employee;
import com.javaprojects.springbootbackend.repository.EmployeeRepository;
import com.javaprojects.springbootbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent())
            return employee.get();
        else
            throw new ResourceNotFoundException("Employee", "Id", id );

//        return  employeeRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // we need to check whether employee with given id exist in DB or not

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // check if employee exist in db
        employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","Id", id));
        employeeRepository.deleteById(id);
    }
}
