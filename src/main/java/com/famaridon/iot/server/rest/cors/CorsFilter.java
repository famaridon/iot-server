package com.famaridon.iot.server.rest.cors;

import javax.ws.rs.container.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by famaridon on 18/09/2016.
 */
@Provider
@PreMatching
public class CorsFilter implements ContainerRequestFilter, ContainerResponseFilter
{
	
	public CorsFilter()
	{
		System.out.println();
	}
	
	/**
	 * Filter method called after a response has been provided for a request
	 * (either by a {@link ContainerRequestFilter request filter} or by a
	 * matched resource method.
	 * <p>
	 * Filters in the filter chain are ordered according to their {@code javax.annotation.Priority}
	 * class-level annotation value.
	 * </p>
	 *
	 * @param requestContext  request context.
	 * @param responseContext response context.
	 * @throws IOException if an I/O exception occurs.
	 */
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException
	{
		requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		requestContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
	}
	
	/**
	 * Filter method called before a request has been dispatched to a resource.
	 * <p>
	 * Filters in the filter chain are ordered according to their {@code javax.annotation.Priority}
	 * class-level annotation value.
	 * If a request filter produces a response by calling {@link ContainerRequestContext#abortWith}
	 * method, the execution of the (either pre-match or post-match) request filter
	 * chain is stopped and the response is passed to the corresponding response
	 * filter chain (either pre-match or post-match). For example, a pre-match
	 * caching filter may produce a response in this way, which would effectively
	 * skip any post-match request filters as well as post-match response filters.
	 * Note however that a responses produced in this manner would still be processed
	 * by the pre-match response filter chain.
	 * </p>
	 *
	 * @param requestContext request context.
	 * @throws IOException if an I/O exception occurs.
	 * @see PreMatching
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		// When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
		if (requestContext.getRequest().getMethod().equals("OPTIONS"))
		{
			// Just send a OK signal back to the browser
			requestContext.abortWith(Response.status(Response.Status.OK).build());
		}
	}
}
