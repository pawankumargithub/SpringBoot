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
@Table(name = "shipment_type_tab")
public class ShipmentType {

	@Id
	@GeneratedValue(generator = "shipment_type_sequence")
	@SequenceGenerator(name = "uom_sequence",sequenceName = "uom_sequence")
	@Column(name = "shipment_id_col")
	private Integer id;
	@Column(name = "shipment_mode_col",length = 6,nullable = false)
	private String shipmentMode;
	@Column(name = "shipment_code_col",length = 10,nullable = false)
	private String shipmentCode;
	@Column(name = "enable_shipment_col",length = 3,nullable = false)
	private String enableShipment;
	@Column(name = "shipment_grade_col",length = 1,nullable = false)
	private String shipmentGrade;
	@Column(name = "shipment_description_col",length = 200,nullable = false)
	private String description;
}
