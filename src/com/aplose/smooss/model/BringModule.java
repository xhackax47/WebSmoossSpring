package com.aplose.smooss.model;

import javax.persistence.Entity;

/**
 * This class extends Module.
 * TypeOfBring enum is used.
 * @author Sonia
 */
@Entity
public class BringModule extends Module {
	
	private TypeOfBring typeOfBrings;
	private String what;
	private String howMany;
	private String who;
	
	public enum TypeOfBring {
		drink,
		sugared,
		salted,
		others;	
	}
	
	public TypeOfBring getBringModuleType() {
		return typeOfBrings;
	}
	
	public void setBringModuleType(TypeOfBring typeOfBrings) {
		this.typeOfBrings = typeOfBrings;
	}
		
	public String getWhat() {
		return what;
	}
	public void setWhat (String what) {
		this.what = what;
	}
	
	public String getHowMany() {
		return howMany;
	}
	public void setHowMany (String howmany) {
		this.howMany = howmany;
	}
	
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
		
}
