package com.example.boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="emptab")

public class EmployeeBO {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double fee;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="eidfk")
	private List <Address> addr;
}
