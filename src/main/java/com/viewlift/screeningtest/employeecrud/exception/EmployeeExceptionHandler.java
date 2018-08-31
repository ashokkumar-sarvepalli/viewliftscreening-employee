package com.viewlift.screeningtest.employeecrud.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {
	
	  @ExceptionHandler(EmployeeAlreadyExistsException.class)
	  public final ResponseEntity<Error> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException ex, WebRequest request) {
	    Error error = new Error(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	  }

	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
	    Error errorDetails = new Error(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  } 
	
	  
}
