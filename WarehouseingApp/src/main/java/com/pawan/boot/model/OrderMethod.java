package com.pawan.boot.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_method_tab")
public class OrderMethod {

	@Id
	@GeneratedValue(generator = "order_method_sequence")
	@SequenceGenerator(name = "order_method_id",sequenceName = "order_method_sequence")
	@Column(name="order_method_id")
	private Integer id;
	@Column(name="order_method_mode")
	private String orderMode;
	@Column(name="order_method_code")
	private String orderCode;
	@Column(name="order_method_type")
	private String orderType;
	@Column(name="order_method_accept")
	@ElementCollection
	@CollectionTable(name="order_accept_tab",joinColumns = @JoinColumn(name="order_method_id"))
	private List<String> orderAccept;
	@Column(name="order_method_description")
	private String description;

}
