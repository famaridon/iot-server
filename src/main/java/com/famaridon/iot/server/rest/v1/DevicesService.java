package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.entities.Device;
import com.famaridon.iot.server.domain.repositories.DevicesRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Path("/devices")
public class DevicesService
{
	
	@Inject
	DevicesRepository repository;
	
	@POST
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Device add(@PathParam("name") String name)
	{
		Device device = new Device();
		device.setName(name);
		repository.save(device);
		return device;
	}
	
	@GET
	@Produces("text/plain")
	public Response doGet()
	{
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}
