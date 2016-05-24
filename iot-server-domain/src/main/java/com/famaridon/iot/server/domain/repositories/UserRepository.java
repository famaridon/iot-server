package com.famaridon.iot.server.domain.repositories;

import com.famaridon.iot.server.domain.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by famaridon on 23/05/2016.
 */
@ApplicationScoped
public class UserRepository
{
	@PersistenceContext
	private EntityManager em;

	public User findById(Long id) {
		return em.find(User.class, id);
	}

	public User save(User user) {
		return em.merge(user);
	}

}
