package com.aplose.smooss.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * This class creates a comment with an User author.
 * @author Formation
 */
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String comment;
	private Instant date;
	private Instant hour;
	@ManyToOne
	private User author;

	
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Instant getDate() {
		return date;
	}
	
	public void setDate(Instant date) {
		this.date = date;
	}
	
	public Instant getHour() {
		return hour;
	}
	
	public void setHour(Instant hour) {
		this.hour = hour;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
}