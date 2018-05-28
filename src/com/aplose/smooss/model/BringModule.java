package com.aplose.smooss.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;


/**
 * This class extends Module.
 * TypeOfBring enum is used.
 * @author Sonia
 */
@Entity
public class BringModule extends Module {
	
	@Enumerated
	private TypeOfBring bringModuleType;
	private String who;
	private String howMany;
	private String what;
	
	
	public TypeOfBring getBringModuleType() {
		return bringModuleType;
	}
	
	public void setBringModuleType(TypeOfBring bringModuleType) {
		this.bringModuleType = bringModuleType;
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