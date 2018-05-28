package com.aplose.smooss.model;

import javax.validation.constraints.NotEmpty;

public class Login {
	
	@NotEmpty(message = "*Ce champ est obligatoire.")
	private String email;
	@NotEmpty(message = "*Ce champ est obligatoire.")
	private String password;

	
	
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