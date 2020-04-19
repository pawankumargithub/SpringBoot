package com.example.boot.model;

import javax.persistence.Column;
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
@Table(name="prodtab")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pname",length = 10)
	private String prodName;
	@Column(name="pcost")
	private Double prodCost;
	@Column(name="pqty")
	private Integer prodQty;
}
