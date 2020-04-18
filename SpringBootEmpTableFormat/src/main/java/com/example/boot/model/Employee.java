package com.example.boot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empdata_table")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer employeeId;
	private String employeeName;
	private Double employeeSal;
	private String employeeGen;
	private String employeeMail;
	private Integer employeeDeptNo;
	private String employeeDeptName;

}
