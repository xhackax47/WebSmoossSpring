package com.aplose.smooss.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * This class will be called in PlaylistModule
 * It contains a list of Url and a MusicGenre enum.
 * @author SmoossTeam
 */
@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToMany
	private List<Url> urls;
	private MusicGenre genre;
	
	public enum MusicGenre {
		Afro,
		Blues,
		Classical,
		Disco,
		Dub,
		Electro,
		Folk,
		French_Variety,
		HardRock,
		HardTek,
		Hip_Hop,
		Jazz,
		Latino,
		Metal,
		New_Age,
		Pop,
		Punk,
		Ragga,
		Raï,
		Rap,
		Reggae,
		RnB,
		Rock,
		Techno,
		Zouk,
		World,
		End_Of_The_Night,
		Other_unclassified;
	}

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
