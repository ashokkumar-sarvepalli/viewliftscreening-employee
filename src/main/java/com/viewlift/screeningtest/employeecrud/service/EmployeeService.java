package com.viewlift.screeningtest.employeecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewlift.screeningtest.employeecrud.exception.EmployeeAlreadyExistsException;
import com.viewlift.screeningtest.employeecrud.model.Employee;
import com.viewlift.screeningtest.employeecrud.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.findByEmail(employee.getEmail());
		if (existingEmployee != null) {
			throw new EmployeeAlreadyExistsException("Employee with the given email id already exists");
		}
		return employeeRepository.save(employee);
	}

}
