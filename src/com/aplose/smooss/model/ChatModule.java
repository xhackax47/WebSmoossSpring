package com.aplose.smooss.model;

import javax.persistence.Entity;

/**
 * This class extends Module and create a ChatModule.
 * @author Formation
 */
@Entity
public class ChatModule extends Module{
	
	private String name;
	private String message; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
