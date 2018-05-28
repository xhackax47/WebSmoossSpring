package com.aplose.smooss.model;


public enum TypeModule {

		PlaylistModule ("Playlist", "fas fa-music"),
		TriCountModule ("Tri-Count", "fas fa-dollar-sign"),
		PicturesModule ("Pictures", "fas fa-camera-retro"),
		ChatModule ("Chat", "fas fa-comments"),
		MiniGameModule ("Mini Game", "fas fa-gamepad"),
		CarpoolingModule ("Car pooling", "fas fa-car"),
		BringModule ("Bring", "fas fa-people-carry");
	
	private String name = "";
	private String iJspClass = "";
	
	private TypeModule(String name, String iJspClass) {
		this.name = name;
		this.iJspClass = iJspClass;
	}

	public String getName() {
		return name;
	}

	public String getiJspClass() {
		return iJspClass;
	}
	
	
}