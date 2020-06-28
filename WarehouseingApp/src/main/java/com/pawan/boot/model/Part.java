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
@Table(name = "Part_tab")
public class Part {

	@Id
	@GeneratedValue(generator = "part_sequence")
	@SequenceGenerator(sequenceName = "part_sequence", name = "part_sequence")
	@Column(name = "part_id")
	private Integer id;
	@Column(name = "part_code")
	private String partCode;
	@Column(name = "part_width")
	private Double partWdth;
	@Column(name = "part_length")
	private Double partLen;
	@Column(name = "part_height")
	private Double partHgh;
	@Column(name = "base_cost")
	private Double baseCost;
	@Column(name = "base_curr")
	private String baseCurr;
	@Column(name = "part_description")
	private String description;
}
