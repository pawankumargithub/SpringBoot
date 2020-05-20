package com.pawan.mvc.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.mvc.bo.PatientBO;
import com.pawan.mvc.dao.PatientDAO;
import com.pawan.mvc.dto.PatientDTO;
import com.pawan.mvc.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired

	private PatientDAO dao;

	@Override
	public String savePatient(PatientDTO dto) {

		 PatientBO bo=new PatientBO();
		 BeanUtils.copyProperties(dto, bo);
		Integer id= dao.insertPatient(bo);
		return "patient having id:"+id+" "+"registered successfully";
	}

}
