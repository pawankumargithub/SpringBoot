package com.pawan.boot.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCommand {

	private Integer bookId;
	private String bookName;
	private Double bookPrice;
	private String bookAuthor;
}
