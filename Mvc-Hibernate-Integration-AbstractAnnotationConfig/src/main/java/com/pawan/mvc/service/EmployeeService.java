package com.pawan.mvc.service;

import com.pawan.mvc.model.Employee;

public interface EmployeeService {

	public Integer insertEmployee(Employee employee);
	public Iterable<Employee> findAll() throws Exception ;
}
