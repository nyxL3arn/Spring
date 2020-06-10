package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//add exception handling code here
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
	}
	//add another Exception handler ... to catch any type of exception(catch all)
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		//create an ErrorResponse
				StudentErrorResponse error = new StudentErrorResponse();
				
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage("please insert a number");
				error.setTimeStamp(System.currentTimeMillis());
				
				//return ResponseEntity
				return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
	
}
