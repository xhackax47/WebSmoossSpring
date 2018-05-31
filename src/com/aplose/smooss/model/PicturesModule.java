package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class PicturesModule extends Module {

	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Picture> pictures;

	
	
	public List<PicturesModule> asList(PicturesModule[] picture) {

		List<PicturesModule> result = new ArrayList<PicturesModule>();
		for (PicturesModule pict : result) {

			result.add(pict);

		}
		
		return result;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
}