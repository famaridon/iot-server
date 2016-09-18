package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.repositories.DevicesRepository;
import org.apache.commons.lang3.NotImplementedException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Path("/devices/{" + DevicesService.USER_API_KEY_PATH_PARAM + "}/values")
public class ValuesService
{
	
	@Inject
	DevicesRepository repository;
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(@PathParam("name") String name)
	{
		throw new NotImplementedException("Not implemented");
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void get(@PathParam("id") Long id)
	{
		throw new NotImplementedException("Not implemented");
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id)
	{
		throw new NotImplementedException("Not implemented");
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public void view(@PathParam("id") Long id)
	{
		throw new NotImplementedException("Not implemented");
	}
	
}
