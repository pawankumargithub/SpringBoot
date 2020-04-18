package com.example.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.boot.model.Employee;
import com.example.boot.service.EmployeeService;

@Controller

public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String home() {
		return "goto";
	}
	@GetMapping("/register")
	public ModelAndView register() {
		
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("command",new Employee());
		return mv;
	}
	@ResponseBody
	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.addEmployee(employee);
		return "data inserted";
	}
	@GetMapping("/find")
	public ModelAndView findAll() {
		Iterable<Employee> emp=service.findAllEmployee();
		System.out.println(emp);
		return new ModelAndView("welcome", "emplist", emp);
	}
}
