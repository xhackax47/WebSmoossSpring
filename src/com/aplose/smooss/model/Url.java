package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class will create an Url. 
 * @author SmoossTeam
 */
@Entity
public class Url {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String url;

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}