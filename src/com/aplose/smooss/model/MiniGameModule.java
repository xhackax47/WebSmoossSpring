package com.aplose.smooss.model;

import javax.persistence.Entity;

/**
 * This class extends Module. It creates a MiniGameModule.
 * @author Formation
 */
@Entity
public class MiniGameModule extends Module{

	private String nameGame;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameGame() {
		return nameGame;
	}
	public void setNameGame(String nameGame) {
		this.nameGame = nameGame;
	} 
}