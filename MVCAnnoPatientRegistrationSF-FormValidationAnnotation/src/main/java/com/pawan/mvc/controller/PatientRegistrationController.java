 package com.pawan.mvc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pawan.mvc.cmd.PatientCommand;
import com.pawan.mvc.dto.PatientDTO;
import com.pawan.mvc.service.PatientService;


@Controller
@SessionAttributes("patCmd")
public class PatientRegistrationController {

	@Autowired
	private PatientService service;
	@Autowired
	
	//patCmd object will be in session scope so for every rqst only one obj will be created
	@ModelAttribute("patCmd")
	public PatientCommand getPatientCommand() {
		
		return new PatientCommand();
	}
	
	@GetMapping("/corona.htm")
	public String showHome(@ModelAttribute("patCmd") PatientCommand cmd) {
		cmd.setHospital("image hospital");
		cmd.setLocation("hyderabad");
		return"patient_register";
	}
	@PostMapping("/corona.htm")
	public String register(Map<String,Object> map,@Valid @ModelAttribute("patCmd") PatientCommand cmd,BindingResult br) {
		PatientDTO dto=null;
		String message=null;
		if(br.hasErrors()) {
			return"patient_register";
		}
		if(cmd.getVflag().equalsIgnoreCase("no")) {
			System.out.println("server side validation is going on");
		}
		
		if(cmd.getLocation().equalsIgnoreCase("hyderabad")) {
			br.rejectValue("location", "loc.blocked");
			return "patient_register";
		}
		dto=new PatientDTO();
		BeanUtils.copyProperties(cmd, dto);
		 message=service.savePatient(dto);
		map.put("msg", message);
		map.put("cmd", cmd);
		
		return "patient_register";
	}
}
