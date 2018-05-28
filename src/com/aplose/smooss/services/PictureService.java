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
import com.aplose.smooss.model.TypeModule;
import com.aplose.smooss.model.User;

@Service
public class PictureService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EventService eventService;
	
	
	
	@Transactional
	public Picture create(Event e, String imgBase64, String name, String description, User author) {
		
		Picture p = new Picture(imgBase64, name, description, author);
		PicturesModule pm = (PicturesModule)eventService.findModuleByEvent(e, TypeModule.PicturesModule);
		
		
		List<Picture> pictures = pm.getPictures();
		pictures.add(p);
		pm.setPictures(pictures);
		
		//Persist picture and merge to event
		entityManager.persist(p);
		this.updatePictureModule(pm);
		return p;
		
	}
	
	@Transactional(readOnly = true)
	public Picture read(Long id) {
	
		Picture p = entityManager.find(Picture.class, id);
		
		return p;	
	}
	
	@Transactional
	public Picture update(Picture p) { 
		Picture picture = entityManager.find(Picture.class, p);
		entityManager.merge(p);
		return picture;
	}
	
	@Transactional
	public void delete(Picture p, Event e) {
		
		PicturesModule pm = (PicturesModule)eventService.findModuleByEvent(e, TypeModule.PicturesModule);
		List<Picture> pictures = pm.getPictures();
		pictures.remove(p);
		pm.setPictures(pictures);
		
		entityManager.remove(p);
		this.updatePictureModule(pm);
	}
	
	@Transactional
	public Module updatePictureModule(Module pm) {
		Module pictureModule = entityManager.find(Module.class, pm);
		entityManager.merge(pm);
		return pictureModule;
	}
	
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