package com.pawan.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="umo_tab")
public class Uom {

	@Id
	
	@GeneratedValue(generator = "uom_sequence")
	@SequenceGenerator(name = "uom_sequence",sequenceName = "uom_sequence")
	@Column(name="umo_id_col")
	private Integer id;
	
	@Column(name="umotype_col",length = 10,nullable = false)
	private String umoType;
	@Column(name="umomodel_col",length = 8,nullable = false)
	private String uomModel;
	@Column(name="umotype_description_col",length = 200,nullable = false)
	private String description;
}
