package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class TriCountModule extends Module{

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	List<Count> counts  = new ArrayList<>();
	
	

	public List<Count> getCounts() {
		return counts;
	}

	public void setCounts(List<Count> counts) {
		this.counts = counts;
	}
}