package com.pawan.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pawan.mvc.model.Employee;
import com.pawan.mvc.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@RequestMapping("/")
	public String register() {
		
		return "employee";
	}
	@RequestMapping("/save")
	public String save(@ModelAttribute("employee")Employee employee,Model model) throws Exception {
	Integer id=	service.insertEmployee(employee);
	String message="Employee Registered With Id:"+id;
	Iterable<Employee> emps=	service.findAll();
		model.addAttribute("emplist", emps);
		return "employee";
	}
	/*
	 * @RequestMapping("/find") public String findAll(Model model) throws Exception
	 * { Iterable<Employee> emps= service.findAll(); model.addAttribute("emplist",
	 * emps); return "register"; }
	 */
	 @RequestMapping("/show")
	public String showList() {
		return "employee";
	}
}
