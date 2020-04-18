package com.example.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.boot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
