package com.famaridon.iot.server.domain.repositories;

import com.famaridon.iot.server.domain.entities.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

/**
 * Created by famaridon on 23/05/2016.
 */
@Repository
public interface UserRepository extends EntityRepository<User, Long>
{
	public User findByLogin(String login);
}
