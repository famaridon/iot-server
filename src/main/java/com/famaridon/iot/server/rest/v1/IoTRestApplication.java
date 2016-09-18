package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.rest.provider.JacksonConfiguration;
import com.wordnik.swagger.jaxrs.config.BeanConfig;

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
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0");
		beanConfig.setBasePath("http://localhost:8080/rest/v1");
		beanConfig.setResourcePackage("com.famaridon.iot.server.rest.v1");
		beanConfig.setScan(true);
	}
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> endpoints = new HashSet<>();
		endpoints.add(UsersService.class);
		endpoints.add(DevicesService.class);
		endpoints.add(JacksonConfiguration.class);
		
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		
		return endpoints;
	}
	
}
