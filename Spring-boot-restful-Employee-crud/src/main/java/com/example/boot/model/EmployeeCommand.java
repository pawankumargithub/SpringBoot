package com.example.boot.model;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeCommand {

	private Integer id;
	private String name;
	private Double fee;
	private List <Address> addr;
}
