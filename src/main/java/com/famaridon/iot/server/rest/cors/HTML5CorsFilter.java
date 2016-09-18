package com.famaridon.iot.server.rest.cors;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by famaridon on 18/09/2016.
 */
@WebFilter(filterName = "HTML5CorsFilter", urlPatterns = { "/rest/*" })
public class HTML5CorsFilter implements javax.servlet.Filter
{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		HttpServletResponse res = (HttpServletResponse)response;
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		res.addHeader("Access-Control-Allow-Headers", "Content-Type");
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}
	
	@Override
	public void destroy()
	{
	}
}
