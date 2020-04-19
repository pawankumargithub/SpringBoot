package com.example.boot.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.boot.dto.ExceptionDTO;
import com.example.boot.exception.ProductNotFoundException;

@ControllerAdvice
public class CentralExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleException(ProductNotFoundException ex){
		
		ExceptionDTO dto=new ExceptionDTO(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<ExceptionDTO>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
