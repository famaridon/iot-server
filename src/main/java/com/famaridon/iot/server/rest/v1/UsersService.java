package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.entities.User;
import com.famaridon.iot.server.domain.repositories.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Path("/users")
public class UsersService
{
	
	@Inject
	UserRepository repository;
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User create(User user, @QueryParam("password") String password)
	{
		user.setPassword(password);
		repository.save(user);
		return user;
	}
	
	@GET
	@Path("/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public User get(@PathParam("login") String login)
	{
		return repository.findByLogin(login);
	}
	
}
