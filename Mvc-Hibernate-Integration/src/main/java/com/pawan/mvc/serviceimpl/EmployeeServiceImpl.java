package com.pawan.mvc.serviceimpl;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.mvc.dao.EmployeeDAO;
import com.pawan.mvc.model.Employee;
import com.pawan.mvc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	@Override
	public Integer insertEmployee(Employee employee) {
		
		return dao.saveEmployee(employee);
	}
	@Override
	public Iterable<Employee> findAll() throws Exception  {
		
		return dao.fetchAll();
	}

}
