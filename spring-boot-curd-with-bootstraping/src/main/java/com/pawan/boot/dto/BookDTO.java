package com.pawan.boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="book")
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	@Id
	@GeneratedValue
	@Column(name="bid")
	private Integer bookId;
	@Column(name="bname")
	private String bookName;
	@Column(name="bprice")
	private Double bookPrice;
	@Column(name="bauthor")
	private String bookAuthor;
}
