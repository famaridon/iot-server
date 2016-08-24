package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.repositories.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Path("/hello")
public class UserRestController
{
	
	@Inject
	UserRepository repository;
	
	@GET
	@Produces("text/plain")
	public Response doGet()
	{
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}
