package com.aplose.smooss.services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import com.aplose.smooss.exception.EmailException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.aplose.smooss.model.User;

@Service
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	

	@Transactional
	public void create(User u) throws EmailException {
		u.setPassword(new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(u.getPassword()));
		em.persist(u);
	}
	
	
	public User read(long id) { 
		User u = em.find(User.class, id);
		return u;
	}

	/**
	 * L'opération Update
	 * @param u La personne à mettre à jour dans la base de données.
	 * @return La personne mise à jour
	 */
	@Transactional
	public void update(User u) { 
		em.merge(u);
	}
	
	@Transactional
	public void delete(User u) {
		em.remove(u);
	}
	
	@Transactional
	public void deleteById(long id) {
		User u = em.find(User.class, id);
		em.remove(u);
	}
	
	
	/**
	 * findByEmailAndPassword
	 * Method that will find a user with a specific email and password
	 * @param email
	 * @param password
	 * @return u
	 */
	public User findByEmailAndPassword(String email, String password) {

		User u = null;
		
		TypedQuery<User> findByEmailAndPasswords = em.createQuery("Select u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
		
		
		findByEmailAndPasswords.setParameter("email", email);
		findByEmailAndPasswords.setParameter("password", new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(password));
		
		try {
			u = findByEmailAndPasswords.getSingleResult();
		} catch (NoResultException e) {
			//e.printStackTrace();
		}
		return u; 
	}
	
	/**
	 * findUserByEmail
	 * Method that will look for an existingEmail
	 * @param email 
	 * @return u
	 */
	public User findUserByEmail(String email) {
		User u = null;
		TypedQuery<User> findUserByEmail =  em.createNamedQuery("User.findByEmail", User.class);
		
		findUserByEmail.setParameter("email", email);
		
		try {
			u = findUserByEmail.getSingleResult();
		} catch (NoResultException e) {
			// TODO ajouter une log si nécessaire
		}
		return u;
	}
}
