package com.aplose.smooss.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.aplose.smooss.exception.EmailException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplose.smooss.model.User;

@Service
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	private TypedQuery<User> findByEmailAndPasswords;

	@Transactional
	public void create(User u) throws EmailException {

		try {
			em.persist(u);
			
		}catch(PersistenceException e) {
			((EntityTransaction) em).rollback();
			u.setId(0);
			
			throw new EmailException("Oh mec t'as déjà un compte SMOOS Connecte-toi!");
		}

	}
	
	@Transactional(readOnly=true)
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
	
	@Transactional(readOnly=true)
	public User findByEmailAndPassword(String email, String password) {

		User u = null;
		
		if(findByEmailAndPasswords == null) {
			findByEmailAndPasswords = em.createQuery("Select u from User u where email = :email AND password = :password", User.class);
		}
		
		findByEmailAndPasswords.setParameter("email", email);
		findByEmailAndPasswords.setParameter("password", new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(password));
		
		try {
			u = findByEmailAndPasswords.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u; 
	}
	
	@Transactional(readOnly=true)
	public User read(String email, String password, String firstName, String lastName, String nickName,
			String picture) {
		// TODO Auto-generated method stub
		return null;
	}
}
