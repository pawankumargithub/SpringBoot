package com.example.boot.service;

import java.util.List;

import com.example.boot.model.EmployeeBO;

public interface IEmployeeService {

	EmployeeBO saveEmployee(EmployeeBO bo);

	List<EmployeeBO> findAll();

	public EmployeeBO findById(Integer id);

	public void delteById(Integer id);

	public EmployeeBO updateById(EmployeeBO bo);

	public EmployeeBO findByName(String name);

}
