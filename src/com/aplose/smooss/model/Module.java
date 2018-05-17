package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * This abstract parent class gives default template for a module,
 * a name and a TypeModule enum.
 * @author Formation
 */
@Entity
public abstract class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String name = "Default Module Name";
	private TypeModule type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public enum TypeModule {
		PlaylistModule,
		TriCountModule,
		PicturesModule,
		ChatModule,
		MiniGameModule,
		CarpoolingModule,
		BringModule;
	}
	
	public TypeModule getType() {
		return this.type;
	}
	
	public void setType(TypeModule type) {
		this.type = type;
	}
}