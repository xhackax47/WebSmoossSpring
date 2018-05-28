package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class will be called in TriCountModule each 
 * time a Count object is created 
 * @author Formation
 */
@Entity
public class Count {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

}
