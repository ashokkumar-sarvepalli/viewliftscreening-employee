package com.viewlift.screeningtest.employeecrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="employee")

public class Employee {
	
	@NotNull(message = "email cannot have null values")
	@NotBlank(message = "email cannot be blank")
	@Email(message = "email is not in correct format")
	@Id
	private String email;


	@NotNull(message = "name cannot have null values")
	@NotBlank(message = "name cannot be blank")
	@Pattern(regexp = "[a-z-A-Z]*", message = "invalid characters entered for name")
	@Column(name="name")
	private String name;

	
	@NotNull(message = "name cannot have null values")
	@NotBlank(message = "name cannot be blank")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})", message = " 6 to 15 characters string with at least one digit, one upper case letter, one lower case letter and one special symbol (“@#$%”)")
	@Column(name="password")

	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
