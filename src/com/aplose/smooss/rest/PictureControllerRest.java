package com.aplose.smooss.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.smooss.model.Picture;
import com.aplose.smooss.services.PictureService;

@RestController
@RequestMapping("picture")
public class PictureControllerRest {
	
	@Autowired
	private PictureService ps;
	
	@PostMapping("/event/{id}")
	public void createPicture(@PathVariable("id") Long idEvent, Picture p) {
		ps.createPictureRest(idEvent, p);
	}

	@CrossOrigin
	@GetMapping("/event/{id}")
	public List<Picture> showPictures(@PathVariable("id") Long idEvent) {
		return ps.findPicturesByEventRest(idEvent);
	}
	
    @CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "{id}")
	public Picture showPicture(@PathVariable("id") Long idPicture) {
		Picture pict = ps.read(idPicture);
		//Picture p = new Picture(null, pict.getName(), pict.getDescription(), pict.getAuthor());
		return pict;
	}
	
	@PostMapping("{id}")
	public void updatePicture(Picture p) {
		ps.update(p);
	}
	
	@DeleteMapping("{id}")
	public void deletePicture(@PathVariable("id") Long idPicture) {
		//ps.delete(p, e); A FIXER
	}

}
