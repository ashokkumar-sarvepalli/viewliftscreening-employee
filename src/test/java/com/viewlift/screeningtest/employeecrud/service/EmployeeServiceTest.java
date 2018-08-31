package com.viewlift.screeningtest.employeecrud.service;


import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.viewlift.screeningtest.employeecrud.exception.EmployeeAlreadyExistsException;
import com.viewlift.screeningtest.employeecrud.model.Employee;
import com.viewlift.screeningtest.employeecrud.repo.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService empService;
	
	@Mock
	private EmployeeRepository empRepository;
	
    @Before
    public void clear(){
    	//Mockito.ini
    }

	@Test
	public void testEmployeeSave(){
		Employee inputEmployee = new Employee();
		inputEmployee.setEmail("ashok.ssn@gmail.com");
		when(empRepository.findByEmail("ashok.ssn@gmail.com")).thenReturn(null);
		when(empRepository.save(any(Employee.class))).thenReturn(new Employee());
		Employee employee = empService.createEmployee(inputEmployee);
		assertNotNull(employee);
	}
	
	@Test(expected = EmployeeAlreadyExistsException.class)
	public void testEmployeeSaveNegative(){
		Employee existingEmployee = new Employee();
		Employee inputEmployee = new Employee();
		inputEmployee.setEmail("ashok.ssn@gmail.com");
		when(empRepository.findByEmail("ashok.ssn@gmail.com")).thenReturn(existingEmployee);
		empService.createEmployee(inputEmployee);
	}
}
