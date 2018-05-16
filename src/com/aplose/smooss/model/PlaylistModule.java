package com.aplose.smooss.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * This class extends Module and create a PlaylistModule
 * It contains a list of Playlist.
 * @author SmoossTeam
 */
@Entity
public class PlaylistModule extends Module {
	@OneToMany
	private List<Playlist> playlists;

	public List<Playlist> getPlaylists() {
		return playlists;
	}
	
}
