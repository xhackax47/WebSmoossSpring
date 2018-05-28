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
import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@RestController
@RequestMapping("/user")
public class AuthControllerRest {
	
	@Autowired
	private UserService uS;
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User showUser(@PathVariable("id") Long id){
		return uS.read(id);
	}
	
	@PostMapping
	public void createUser(User u) throws EmailException {
		uS.create(u);
	}
	
	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		uS.deleteById(id);
	}
	
	@PutMapping("{id}")
	public void updateUser(@PathVariable("id") User u) {
		uS.update(u);
	}
	
}
