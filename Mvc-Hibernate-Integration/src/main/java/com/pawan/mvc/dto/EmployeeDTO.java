package com.pawan.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

	private Integer empId;

	private String empName;

	private Double empSal;

	private String empAddr;

}
