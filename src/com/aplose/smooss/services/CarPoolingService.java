package com.aplose.smooss.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplose.smooss.model.CarPooling;
import com.aplose.smooss.model.CarPoolingModule;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.TypeModule;
import com.aplose.smooss.model.User;

@Service
public class CarPoolingService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EventService es;
	
	@Transactional
	public void create(Long id, CarPooling cp) {
		
		Event e = es.read(id);
		CarPoolingModule cpm = (CarPoolingModule)es.findModuleByEvent(e, TypeModule.CarpoolingModule);
		
		List<CarPooling> carPoolings = cpm.getCarPooling();
		carPoolings.add(cp);
		cpm.setCarPooling(carPoolings);
		
		em.persist(cp);
		this.updateCarPoolingModule(cpm);
	}
	
	@Transactional(readOnly = true)
	public CarPooling read(Long id) {
		CarPooling cp = em.find(CarPooling.class, id);
		return cp;
	}
	
	@Transactional
	public CarPooling update(CarPooling cp) { 
		CarPooling carPooling = em.find(CarPooling.class, cp);
		em.merge(carPooling);
		return carPooling;
	}
	
	@Transactional
	public void delete(Long id) {
		
		// FIX ME : find an event by carpooling item ?
//		CarPooling cp = this.read(id);
//		CarPoolingModule cpm = (CarPoolingModule)es.findModuleByEvent(e, TypeModule.CarpoolingModule);
//		List<CarPooling> carPoolings = cpm.getCarPooling();
//		carPoolings.remove(cp);
//		cpm.setCarPooling(carPoolings);
//		em.remove(cp);
//		this.updateCarPoolingModule(cpm);
		
	}
	
	@Transactional
	public Module updateCarPoolingModule(Module cpm) {
		Module carPoolingModule = em.find(Module.class, cpm);
		em.merge(cpm);
		return carPoolingModule;
	}
	
	@Transactional(readOnly = true)
	public List<CarPooling> findCarPoolingByEvent(Long id){
		
		Event e = es.read(id);
		List<CarPooling> carPooling = null;
		
		for(Module m : e.getModules()) {
			if(m instanceof CarPoolingModule) {
				carPooling = ((CarPoolingModule)m).getCarPooling();
			}
		}
		if(carPooling == null) {
			carPooling = new ArrayList<CarPooling>();
		}
		
		return carPooling;
	}

}