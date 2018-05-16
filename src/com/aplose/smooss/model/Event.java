package com.aplose.smooss.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * This class will create an Event with a User admin, 
 * a list of Module and a list of User.
 * @author Formation
 */
@Entity
public class Event{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User admin ;
	private String name;
	@Column (length=280)
	private String description;
	private String localisation;	
	private Instant start;
	private Instant end;
	@Lob
	private String picture;
	
	@Transient
	private String startDateEvent;
	@Transient
	private String startTimeEvent;
	@Transient
	private String endDateEvent;
	@Transient
	private String endTimeEvent;
	
	@OneToMany
	List<Module> modules = new ArrayList<Module>();

	@ManyToMany
	List<User> participants = new ArrayList<User>();

	public Event() {}
	
	public Event(User admin, String name, String description, String localisation, Instant start, Instant end, String picture) {	
		this.admin = admin;
		this.name = name;
		this.description = description;
		this.localisation = localisation;
		this.start = start;
		this.end = end;
		this.picture = picture;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public User getAdmin() {
		return admin;
	}
	
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocalisation() {
		return localisation;
	}
	
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	public Instant getStart() { 
		return this.start;
	}
	
	public void setStart(Instant s) { 
		this.start = s;
	}
	
	public Instant getEnd() {
		return end;
	}
	
	public void setEnd(Instant end) {
		this.end = end;
	}
	
	public List<User> getParticipants() {
		return participants;
	}

	public List<Module> getModules() {
		return modules;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStartDateEvent() {
		return startDateEvent;
	}

	public void setStartDateEvent(String startDateEvent) {
		this.startDateEvent = startDateEvent;
	}

	public String getStartTimeEvent() {
		return startTimeEvent;
	}

	public void setStartTimeEvent(String startTimeEvent) {
		this.startTimeEvent = startTimeEvent;
	}

	public String getEndDateEvent() {
		return endDateEvent;
	}

	public void setEndDateEvent(String endDateEvent) {
		this.endDateEvent = endDateEvent;
	}

	public String getEndTimeEvent() {
		return endTimeEvent;
	}

	public void setEndTimeEvent(String endTimeEvent) {
		this.endTimeEvent = endTimeEvent;
	}
	
	
}