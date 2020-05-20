package com.example.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "prodtab")
public class Product {

	@Id
	@GeneratedValue
	@Column(name="poid")
	private Integer prodId;
	@Column(name="pname")
	@NotEmpty(message = "name must be required")
	private String prodName;
	@Column(name="pcost")
	@NotNull(message = "cost must be required")
	private Double prodCost;
	@Column(name="pdis")
	private Double prodDis;
	@Column(name="pgst")
	private Double prodGst;
	@NotEmpty(message = "vendor name must required")
	private String vendor;

}
