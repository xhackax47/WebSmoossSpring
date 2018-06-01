package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * This class extends Module and create a CarPoolingModule 
 * that contains a list of zero or more CarPooling Objects.
 * @author Formation
 */
@Entity
public class CarPoolingModule extends Module {

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CarPooling> carPooling;
 
	public List<CarPooling> getCarPooling() {
		return carPooling;
	}

	public void setCarPooling(List<CarPooling> carPooling) {
		this.carPooling = carPooling;
	}
	
}
