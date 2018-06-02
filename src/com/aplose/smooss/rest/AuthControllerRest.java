package com.aplose.smooss.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.ApiError;
import com.aplose.smooss.model.Login;
import com.aplose.smooss.model.User;
import com.aplose.smooss.services.UserService;

@RestController
@RequestMapping("user")
public class AuthControllerRest {
	
	@Autowired
	private UserService uS;
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User showUser(@PathVariable("id") Long id){
		return uS.read(id);
	}
	
	@CrossOrigin
	@PostMapping(path="/create", consumes="application/json")
	public ResponseEntity<Object> createUser(@RequestBody User u) throws EmailException {
//		System.out.println("nice");
		
		User test = uS.findUserByEmail("email");
		if (null == test) {
			uS.create(u);
			return new ResponseEntity<Object>(u, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST, "Email déjà existant"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
    @PostMapping(path="/login", consumes="application/json")
    public ResponseEntity<Object> login(@RequestBody Login l){
        if(uS.findByEmailAndPassword(l.getEmail(), l.getPassword()) != null)
        {
        	return new ResponseEntity<Object>(l, HttpStatus.ACCEPTED);
        }
        else
        {
        	System.out.println("non nice");
        	return new ResponseEntity<Object>("non nice", HttpStatus.BAD_REQUEST);
        }
        
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
