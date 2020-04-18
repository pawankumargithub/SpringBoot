package com.example.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.Employee;
import com.example.boot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	@Override
	public Employee addEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Iterable<Employee> findAllEmployee() {
		return repository.findAll();
	}

}
