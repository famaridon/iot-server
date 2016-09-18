package com.famaridon.iot.server.rest.provider;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by famaridon on 24/08/2016.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfiguration implements ContextResolver<ObjectMapper>
{
	
	@Inject
	ObjectMapper objectMapper;
	
	@Override
	public ObjectMapper getContext(Class<?> type)
	{
		return objectMapper;
	}
}
