package com.example.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.boot.model.EmployeeBO;
import com.example.boot.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Override
	public EmployeeBO saveEmployee(EmployeeBO bo) {
	
		return repo.save(bo);
	}

	@Override
	public List<EmployeeBO> findAll() {
	
		return repo.findAll();
	}
	public EmployeeBO findById(Integer id) {
		
		
		return repo.findById(id).get();
		
		
	}

	@Override
	public void delteById(Integer id) {
		repo.deleteById(id);
		
	}
	@Override
	public EmployeeBO updateById(EmployeeBO bo) {
		
		return repo.save(bo);
	}
	@Override
	public EmployeeBO findByName(String name) {
		
		return repo.findByName(name);
	}

}
