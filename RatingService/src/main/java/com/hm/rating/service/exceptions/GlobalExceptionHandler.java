package com.hm.rating.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hm.rating.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> HandleResourceNotFoundException(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(ApiResponse.builder().message(ex.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build(), HttpStatus.NOT_FOUND) ;
		
	}

}
