package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class will be called in CarPoolingModule 
 * each time a Carpooling object is created
 * @author Formation
 */
@Entity
public class CarPooling {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
}