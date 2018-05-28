package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToMany
	private List<Url> urls;
	@Enumerated
	private MusicGenre genre;
	
	
	
	public MusicGenre getGenre() {
		return genre;
	}
	
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}
	
	public List<Url> getUrls() {
		return urls;
	}
}