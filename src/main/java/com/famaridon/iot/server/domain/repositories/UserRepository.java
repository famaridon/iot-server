package com.famaridon.iot.server.domain.repositories;

import com.famaridon.iot.server.domain.entities.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * Created by famaridon on 23/05/2016.
 */
@Repository
public interface UserRepository extends EntityRepository<User, Long>
{
	
}
