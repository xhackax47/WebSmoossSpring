package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This class extends Module and create a TriCountModule.
 * It contains a list of Count.
 * @author SmoossTeam
 */
@Entity
public class TriCountModule extends Module{

	@OneToMany
	List<Count> counts  = new ArrayList<>();

	public List<Count> getCounts() {
		return counts;
	}

	public void setCounts(List<Count> counts) {
		this.counts = counts;
	}
}