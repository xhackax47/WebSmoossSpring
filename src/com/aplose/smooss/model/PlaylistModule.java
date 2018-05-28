package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * Class PlaylistModule that will manage the playlist for an event
 * @author formation
 *
 */

@Entity
public class PlaylistModule extends Module {
	
	@OneToMany
	private List<Playlist> playlists;
	
	

	public List<Playlist> getPlaylists() {
		return playlists;
	}	
}