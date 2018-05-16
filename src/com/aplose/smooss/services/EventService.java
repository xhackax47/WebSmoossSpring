package com.aplose.smooss.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.aplose.smooss.factory.FactoryModule;
import com.aplose.smooss.model.Event;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.Module.TypeModule;
import com.aplose.smooss.model.User;

@Service
public class EventService {

	@PersistenceContext
	private EntityManager em;
	private TypedQuery<Event> queryFindEventByUser;
	private static FactoryModule fm = new FactoryModule();

	@Transactional
	public void create(Event evt) {
		em.persist(evt);
	}

	@Transactional(readOnly = true)
	public Event read(long id) {
		Event evt = em.find(Event.class, id);
		return evt;
	}
	
	@Transactional(readOnly = true)
	public List<Event> findEventsByUser(User user) {
		if (queryFindEventByUser == null) {
			queryFindEventByUser = em.createQuery("SELECT e FROM Event e WHERE admin = :user ", Event.class);
		}
		queryFindEventByUser.setParameter("user", user);
		List<Event> result = null;
		try {
			result = queryFindEventByUser.getResultList();
		} catch (NoResultException nre) {
			result = new ArrayList<Event>();
		}
		return result;
	}

	public Module findModuleByEvent(Event e, TypeModule t) {
		Module module = null;
		for (Module m : e.getModules()) {
			if (m.getType() == t) {
				module = m;
			}
		}
		return module;
	}

	@Transactional
	public void addModuleByEvent(Event evt, TypeModule tm) {
		Module m = fm.createModule(tm);
		evt.getModules().add(m);
		em.persist(m);
		em.merge(evt);
	}

	@Transactional
	public void deleteModuleByEvent(Event evt, TypeModule tm) {
		Module m = this.findModuleByEvent(evt, tm);
		if (m != null) {
			evt.getModules().remove(m);
			em.merge(evt);
			em.remove(m);
		}
	}

	@Transactional
	public void modify(Event evt) {
		em.merge(evt);
	}

	@Transactional
	public void delete(Event evt) {
		em.remove(evt);
	}

	@Transactional
	public void addUserByEvent(Event evt, User user) {
		if (!evt.getParticipants().contains(user)) {
			evt.getParticipants().add(user);
			em.merge(evt);
		}
	}
}