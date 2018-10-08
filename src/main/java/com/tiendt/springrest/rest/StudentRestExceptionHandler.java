package com.tiendt.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tiendt.springrest.entity.Student;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorRespond> handlerException(StudentNotFoundException exc){

		StudentErrorRespond studentErr = new StudentErrorRespond();
		
		studentErr.setStatus(HttpStatus.NOT_FOUND.value());
		studentErr.setMessage(exc.getMessage());
		studentErr.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentErr,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorRespond> allException(Exception exc){
		StudentErrorRespond studentError = new StudentErrorRespond();
		
		studentError.setStatus(HttpStatus.BAD_REQUEST.value());
		studentError.setMessage(exc.getMessage());
		studentError.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(studentError,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
}





