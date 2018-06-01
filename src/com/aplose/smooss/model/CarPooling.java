package com.aplose.smooss.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private User driver;
	private int seats;
	@OneToMany
	private List<User> passengers = new ArrayList<>();
	private String startLocation;
	private String endLocation;
	private Instant departureTime;
	private Instant returnTime;
	
	public CarPooling(User driver, int seats, String startLocation, String endLocation, Instant departureTime, Instant returnTime){
		this.driver = driver;
		this.seats = seats;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		this.departureTime = departureTime;
		this.returnTime = returnTime;	
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public List<User> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<User> passengers) {
		this.passengers = passengers;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Instant getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Instant departureTime) {
		this.departureTime = departureTime;
	}

	public Instant getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Instant returnTime) {
		this.returnTime = returnTime;
	}

}