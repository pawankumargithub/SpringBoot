package com.pawan.mvc.dto;

import lombok.Data;

@Data
public class PatientDTO {

	private Integer patId;

	private String patName;

	private Integer patAge;

	private String hospital;

	private String location;
}
