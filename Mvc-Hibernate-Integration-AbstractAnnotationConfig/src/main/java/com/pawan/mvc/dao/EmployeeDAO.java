package com.pawan.mvc.dao;

import com.pawan.mvc.model.Employee;

public interface EmployeeDAO {

	public Integer saveEmployee(Employee employee);
	public Iterable<Employee> fetchAll() throws Exception;
}
