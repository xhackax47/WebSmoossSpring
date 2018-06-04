package com.aplose.smooss.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@RestController
@RequestMapping("profile/user")
public class ProfileControllerRest {

		@Autowired
		private UserService userS;
		
		@CrossOrigin
		@GetMapping("{id}")
		public User getUser(@PathVariable("id") long id) {
			return userS.read(id);		
		}
		@CrossOrigin
		@PostMapping(path="/update", consumes="application/json")
		public void updateProfile(@RequestBody User u) {
			userS.update(u);
		}
		
	}