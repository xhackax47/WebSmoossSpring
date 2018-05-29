package com.aplose.smooss.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.smooss.model.Event;
import com.aplose.smooss.services.EventService;

@RestController
@RequestMapping("/events")
public class EventControllerRest {
	
	@Autowired
	private EventService eS;
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event showEvent(@PathVariable("id") Long id){
		return eS.read(id);
	}
	
	@PostMapping
	public void createEvent(Event evt) {
		eS.create(evt);
	}
	
	@DeleteMapping("{id}")
	public void deleteEvent(@PathVariable("id") Long id) {
		eS.deleteById(id);
	}
	
	@PutMapping("{id}")
	public void updateEvent(@PathVariable("id") Event evt) {
		eS.update(evt);
	}
}
