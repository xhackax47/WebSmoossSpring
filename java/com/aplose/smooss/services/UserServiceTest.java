package com.aplose.smooss.services;

import com.aplose.smooss.exception.EmailException;
import com.aplose.smooss.model.User;

import junit.framework.TestCase;

public class UserServiceTest extends TestCase {

	// public void testFindByLoginAndPassword() {
	//
	// UserService us = UserService.getInstance();
	// User u = new User();
	// u.setEmail("Gustave");
	// u.setPassword("password");
	// us.create(u);
	//
	// User u2 = us.findByLoginAndPassword("Gustave", "password");
	// assertNotNull(u2);
	// assertEquals(u.getId(), u2.getId());
	//
	// User u3 = us.findByLoginAndPassword("Gustave", "badpassword");
	// assertNull(u3);
	//
	// }

	// test sur une exception on met dans le try {assertTrue(false)} parce qu'on ne
	// veut pas y arriver
	// et dans le catch, là où on veut arriver, car on veut que ça échoue, on met
	// donc {assertTrue(true)} pour que le test ne soit pas en erreur

	public void testCreate() throws EmailException {
		UserService us = UserService.getInstance();
		User u = createGustave("gustave@gmail.com");
		
		us.create(u);
		assertTrue(u.getId() > 0);
		
		try {
			User u2 = createGustave("gustave@gmail.com");
			us.create(u2);
			assertTrue(false);
		} catch (EmailException e) {
			assertTrue(true);
		}

	}

	public void testUpdate() {

		UserService us = UserService.getInstance();
		User u = new User();
		u.setEmail("bouboudbz@gmail.com");
		u.setFirstName("boubou");
		long id = u.getId();
		u.setEmail("bouboulogin");
		u.setFirstName("majinbou");
		u.setPassword("bouboukiki");

		if (u.getId() > 0) {
			System.out.println("On récupère l'id : " + id);
			// us.update(u);
		}

		User u3 = us.findByEmailAndPassword("Gustave", "badpassword");
		assertNull(u3);

	}

	private User createGustave(String email) {
		User u = new User();
		u.setEmail(email);
		u.setFirstName("Gustave");
		u.setLastName("Flaubert");
		u.setPassword("password");
		return u;
	}
}