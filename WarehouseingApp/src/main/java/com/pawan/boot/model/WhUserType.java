package com.pawan.boot.model;

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
@Table(name = "whuser_type_tab")
public class WhUserType {

	@Id
	@GeneratedValue(generator = "whuser_sequence")
	@SequenceGenerator(name = "whuser_sequence", sequenceName = "whuser_sequence")
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "usertype_col")
	private String userType;
	@Column(name = "usercode_col")
	private String userCode;
	@Column(name = "userfor_col")
	private String userFor;
	@Column(name = "user_email_col")
	private String userEmail;
	@Column(name = "user_contact_col")
	private String userContact;
	@Column(name = "userid_type_col")
	private String userIdType;
	@Column(name = "idNumber_col")
	private String idNumber;
}
