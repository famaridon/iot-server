package com.famaridon.iot.server.rest.provider;

import com.famaridon.iot.server.rest.exception.HttpStatusCode;
import com.famaridon.iot.server.rest.provider.beans.ErrorResponseBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 18/09/2016.
 */
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionMapper.class);
	
	@Inject
	ObjectMapper objectMapper;

	
	/**
	 * Map an exception to a {@link Response}. Returning
	 * {@code null} results in a {@link Response.Status#NO_CONTENT}
	 * response. Throwing a runtime exception results in a
	 * {@link Response.Status#INTERNAL_SERVER_ERROR} response.
	 *
	 * @param exception the exception to map to a response.
	 * @return a response mapped from the supplied exception.
	 */
	@Override
	public Response toResponse(Exception exception)
	{
		Response.Status status;
		ErrorResponseBean body;
		
		if (exception.getClass().isAnnotationPresent(HttpStatusCode.class))
		{
			HttpStatusCode httpStatusCode = exception.getClass().getAnnotation(HttpStatusCode.class);
			status = httpStatusCode.value();
			// this is handled exception simple warn log
			LOGGER.warn("Client exception : ", exception);
			body = new ErrorResponseBean().setMessage(exception.getMessage());
		}
		else
		{
			status = Response.Status.INTERNAL_SERVER_ERROR;
			LOGGER.error("Not handled exception : ", exception);
			body = new ErrorResponseBean().setMessage("Not catch exception!");
		}
		try
		{
			return Response.status(status).entity(objectMapper.writeValueAsString(body)).build();
		}
		catch (JsonProcessingException e)
		{
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("{message : 'Can't serialize error message'}").build();
		}
	}
}
