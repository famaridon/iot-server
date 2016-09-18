package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.entities.User;
import com.famaridon.iot.server.domain.repositories.UserRepository;
import com.famaridon.iot.server.rest.v1.dto.UserDto;
import com.famaridon.iot.server.rest.v1.mapper.DtoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Path("/users")
@Api("/users")
public class UsersService
{
	@Context
	UriInfo uriInfo;
	
	@Inject
	UserRepository repository;
	
	@Inject
	DtoMapper dtoMapper;
	
	@POST
	@Path("/")
	@ApiOperation("Create a new user")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response create(User user, @QueryParam("password") String password)
	{
		user.setPassword(password);
		repository.save(user);
		return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getLogin()).build()).build();
	}
	
	@GET
	@Path("/{login}")
	@ApiOperation("get a user by it's login")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDto get(@PathParam("login") String login)
	{
		return dtoMapper.userToUserDto(repository.findByLogin(login));
	}
	
}
