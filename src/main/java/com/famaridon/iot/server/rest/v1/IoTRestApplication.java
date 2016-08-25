package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.rest.provider.JacksonConfiguration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 22/08/2016.
 */
@ApplicationPath("/rest/v1")
public class IoTRestApplication extends Application
{
	public IoTRestApplication()
	{
	}
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> endpoints = new HashSet<>();
		endpoints.add(UsersService.class);
		endpoints.add(DevicesService.class);
		endpoints.add(JacksonConfiguration.class);
		return endpoints;
	}
	
}
