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

@Service("userService")
public class UserService {
	
	@PersistenceContext
	private EntityManager em;
	

	@Transactional
	public void create(User u) throws EmailException {

//		try {
			u.setPassword(new DigestUtils(DigestUtils.getDigest("MD5")).digestAsHex(u.getPassword()));
			em.persist(u);
			
//		}catch(PersistenceException e) {
//			((EntityTransaction) em).rollback();
//			u.setId(0);
//			
//			throw new EmailException("Oh mec t'as déjà un compte SMOOS Connecte-toi!");
//		}

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
	
	
	public User findByEmailAndPassword(String email, String password) {

		User u = null;
		
		TypedQuery<User> findByEmailAndPasswords = em.createQuery("Select u FROM User u WHERE u.email = :email AND u.password = :password", User.class);
		
		
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
	
	public User read(String email, String password, String firstName, String lastName, String nickName,
			String picture) {
		// TODO Auto-generated method stub
		return null;
	}
}
