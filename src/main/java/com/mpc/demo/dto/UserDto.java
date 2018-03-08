package com.mpc.demo.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class UserDto {
	
	@NotEmpty(message = "First name required")
    private String name;
	
	@NotEmpty
	private String lastName;
	
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "An email required")
    private String email;
     
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty
    private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
