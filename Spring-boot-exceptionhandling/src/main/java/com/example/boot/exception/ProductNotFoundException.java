package com.example.boot.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String messge) {
		super(messge);
	}

}
