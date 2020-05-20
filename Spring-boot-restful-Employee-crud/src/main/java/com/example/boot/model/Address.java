package com.example.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.ManyToOne;



import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	private String hno;
	private String city;
	private String dist;
	@ManyToOne
	
	private EmployeeBO bo;
}
