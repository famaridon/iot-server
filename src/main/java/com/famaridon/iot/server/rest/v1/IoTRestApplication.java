package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.interceptors.binding.Logged;
import com.famaridon.iot.server.rest.provider.JacksonConfiguration;
import io.swagger.models.Contact;
import io.swagger.models.ExternalDocs;
import io.swagger.models.Info;
import io.swagger.models.Swagger;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 22/08/2016.
 */
@ApplicationPath("/rest/v1")
@Logged
public class IoTRestApplication extends Application
{
	private Set<Object> singleton;
	
	public IoTRestApplication(@Context ServletContext servletContext)
	{
		Info info = new Info().title("IoT server API").description("This is the IoT server API doc").contact(new Contact().email("famaridon@gmail.com"));
		
		Swagger swagger = new Swagger().info(info);
		swagger.externalDocs(new ExternalDocs("Find out more about Swagger", "http://swagger.io"));
		
		servletContext.setAttribute("swagger", swagger);
	}
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> endpoints = new HashSet<>();
		
		// applications services
		endpoints.add(UsersService.class);
		endpoints.add(DevicesService.class);
		endpoints.add(JacksonConfiguration.class);
		
		// swagger
		endpoints.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		endpoints.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		endpoints.add(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
		
		return endpoints;
	}
	
}
