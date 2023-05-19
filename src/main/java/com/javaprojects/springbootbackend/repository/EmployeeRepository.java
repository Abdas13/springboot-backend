package com.javaprojects.springbootbackend.repository;

import com.javaprojects.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
}
