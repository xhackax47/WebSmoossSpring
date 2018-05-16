package com.aplose.smooss.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This class extends Module and create a PicturesModule 
 * containing a list of Picture.
 * @author SmoossTeam
 */
@Entity
public class PicturesModule extends Module {

	@OneToMany
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
