package com.aplose.smooss.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.smooss.model.CarPooling;
import com.aplose.smooss.services.CarPoolingService;

@RestController
@RequestMapping("carpooling")
public class CarPoolingControllerRest {
	
	@Autowired
	private CarPoolingService cps;
	
	@PostMapping("/event/{id}")
	public void createCarPooling(@PathVariable("id") Long idEvent, CarPooling cp) {
		cps.create(idEvent, cp);
	}

	@GetMapping("/event/{id}")
	public List<CarPooling> showCarPoolings(@PathVariable("id") Long idEvent) {
		return cps.findCarPoolingByEvent(idEvent);
	}
	
	@GetMapping("{id}")
	public CarPooling showCarPooling(@PathVariable("id") Long id) {
		CarPooling car = cps.read(id);
		return car;
	}
	
	@PostMapping("{id}")
	public void updateCarPooling(CarPooling cp) {
		cps.update(cp);
	}
	
	@DeleteMapping("{id}")
	public void deleteCarPooling(@PathVariable("id") Long id) {
		cps.delete(id);
	}

}
