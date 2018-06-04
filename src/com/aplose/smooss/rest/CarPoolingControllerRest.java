package com.aplose.smooss.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.smooss.model.CarPooling;
import com.aplose.smooss.model.Login;
import com.aplose.smooss.services.CarPoolingService;

@RestController
@RequestMapping("carpooling")
public class CarPoolingControllerRest {
	
	@Autowired
	private CarPoolingService cps;
	
	
	@CrossOrigin
    @PostMapping(path="/create/{id}", consumes="application/json")
    public ResponseEntity<Object> createCarPooling(@RequestBody @PathVariable("id")Long idEvent, CarPooling cp){
		//cps.create(idEvent, cp);
		System.out.println(idEvent+cp.getId());
		return new ResponseEntity<Object>(cp, HttpStatus.ACCEPTED);
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
