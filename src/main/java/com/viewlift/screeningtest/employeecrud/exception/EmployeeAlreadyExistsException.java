package com.viewlift.screeningtest.employeecrud.exception;

public class EmployeeAlreadyExistsException extends RuntimeException {

	public EmployeeAlreadyExistsException() {
		super();
	}

	public EmployeeAlreadyExistsException(String message) {
		super(message);
	}
}
