package com.famaridon.iot.server.rest.provider;

import com.famaridon.iot.server.rest.exception.HttpStatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 18/09/2016.
 */
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionMapper.class);
	
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
		
		if (exception.getClass().isAnnotationPresent(HttpStatusCode.class))
		{
			HttpStatusCode httpStatusCode = exception.getClass().getAnnotation(HttpStatusCode.class);
			status = httpStatusCode.value();
			// this is handled exception simple warn log
			LOGGER.warn("Client exception : ", exception);
			return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
		}
		else
		{
			status = Response.Status.INTERNAL_SERVER_ERROR;
			LOGGER.error("Not handled exception : ", exception);
		}
		
		return Response.status(status).entity(exception.getMessage()).build();
	}
}
