package com.pawan.boot.globalexception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pawan.boot.exception.NoBookFoundException;

@ControllerAdvice
public class BookGlobalExceptionHandler {

	
	@ExceptionHandler(NoBookFoundException.class)
	public String showBookNotFoundExceptionPage() {
		
		return "error";
	}
}
