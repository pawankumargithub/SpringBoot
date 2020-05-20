package com.pawan.mvc.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="patient_info")
public class PatientBO {
    
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer patId;
	@Column(name="pname")
	private String patName;
	@Column(name="page")
	private Integer patAge;
	@Column(name="hospital")
	private String hospital;
	@Column(name="loc")
	private String location;
}
