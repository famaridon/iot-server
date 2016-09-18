package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.domain.entities.Device;
import com.famaridon.iot.server.domain.repositories.DevicesRepository;
import com.famaridon.iot.server.interceptors.binding.Logged;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 22/08/2016.
 */
@Stateless
@Logged
@Path("/devices/{" + DevicesService.USER_API_KEY_PATH_PARAM + "}")
public class DevicesService
{
	
	public static final String USER_API_KEY_PATH_PARAM = "user-api-key";
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
