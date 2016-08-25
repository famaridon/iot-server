package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.entities.User;
import com.famaridon.iot.server.domain.repositories.UserRepository;
import com.famaridon.iot.server.rest.v1.dto.UserDto;
import com.famaridon.iot.server.rest.v1.mapper.UserMapper;

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
	
	@Inject
	UserMapper userMapper;
	
	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserDto create(User user, @QueryParam("password") String password)
	{
		user.setPassword(password);
		repository.save(user);
		return userMapper.userToUserDto(user);
	}
	
	@GET
	@Path("/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto get(@PathParam("login") String login)
	{
		return userMapper.userToUserDto(repository.findByLogin(login));
	}
	
}
