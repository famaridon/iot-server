package com.famaridon.iot.server.rest.provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;

/**
 * Created by famaridon on 18/09/2016.
 */
@Singleton
public class JacksonProducer
{
	
	private ObjectMapper objectMapper;
	
	@Produces
	public ObjectMapper getObjectMapper()
	{
		
		if (objectMapper == null)
		{
			objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
		}
		return objectMapper;
	}
}
