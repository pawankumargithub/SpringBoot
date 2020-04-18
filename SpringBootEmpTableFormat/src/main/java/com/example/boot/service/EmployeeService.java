package com.example.boot.service;

import com.example.boot.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	public Iterable<Employee> findAllEmployee();
}
