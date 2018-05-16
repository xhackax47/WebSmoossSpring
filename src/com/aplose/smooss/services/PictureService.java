package com.aplose.smooss.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.Picture;
import com.aplose.smooss.model.PicturesModule;
import com.aplose.smooss.model.User;
import com.aplose.smooss.model.Module.TypeModule;

@Service
public class PictureService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private EventService es;
	
	@Transactional
	public Picture create(Event e, String imgBase64, String name, String description, User author) {
		
		//Construct the picture and add it into PictureModule's list of pictures.
		Picture p = new Picture(imgBase64, name, description, author);
		PicturesModule pm = (PicturesModule)es.findModuleByEvent(e, TypeModule.PicturesModule);
		
		
		List<Picture> pictures = pm.getPictures();
		pictures.add(p);
		pm.setPictures(pictures);
		
		//Persist picture and merge to event
		em.persist(p);
		this.updatePictureModule(pm);
		return p;
	}
	
	@Transactional(readOnly = true)
	public Picture read(Long id) {
		Picture p = em.find(Picture.class, id);
		return p;
	}
	
	@Transactional
	public Picture update(Picture p) { 
		Picture picture = em.find(Picture.class, p);
		em.merge(p);
		return picture;
	}
	
	@Transactional
	public void delete(Picture p, Event e) {
		
		PicturesModule pm = (PicturesModule)es.findModuleByEvent(e, TypeModule.PicturesModule);
		List<Picture> pictures = pm.getPictures();
		pictures.remove(p);
		pm.setPictures(pictures);
		
		em.remove(p);
		this.updatePictureModule(pm);
	}
	
	@Transactional
	public Module updatePictureModule(Module pm) {
		Module pictureModule = em.find(Module.class, pm);
		em.merge(pm);
		return pictureModule;
	}
	
	@Transactional(readOnly = true)
	public List<Picture> findPicturesByEvent(Event e){
		
		List<Picture> pictures = null;
		
		for(Module m : e.getModules()) {
			if(m instanceof PicturesModule) {
				pictures = ((PicturesModule)m).getPictures();
			}
		}
		if(pictures == null) {
			pictures = new ArrayList<Picture>();
		}
		
		return pictures;
	}

}