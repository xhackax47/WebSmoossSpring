package com.aplose.smooss.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.naming.spi.DirStateFactory.Result;
//import java.util.List;
//import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplose.smooss.model.Invite;
import com.aplose.smooss.model.User;

@Service
public class InviteService {
	
	@PersistenceContext
	private EntityManager em;

	
	
	@Transactional
	public void create(Invite ivt) {
		em.persist(ivt);
	}
	
	@Transactional
	public Invite read(long id) {
		Invite ivt = em.find(Invite.class, id);
		return ivt;
	}
	
	@Transactional
	public List<Invite> findInvitesByUser(User login) {
		List<Invite> result = new ArrayList<Invite>();
//		Invite i = null;
		TypedQuery<Invite> findInviteByUser = em.createQuery("SELECT i FROM Invite i, User u WHERE event=:event, invited=:invited",Invite.class);
		findInviteByUser.setParameter("login", login);
		
		try {
			result = findInviteByUser.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}