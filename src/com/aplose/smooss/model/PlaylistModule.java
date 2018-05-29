package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 * Class PlaylistModule that will manage the playlist for an event
 * @author formation
 *
 */

@Entity
public class PlaylistModule extends Module {
	
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Playlist> playlists;
	
	

	public List<Playlist> getPlaylists() {
		return playlists;
	}	
}