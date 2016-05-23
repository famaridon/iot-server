package com.famaridon.iot.server.web.servlets;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by famaridon on 23/05/2016.
 */
 @WebServlet(value = "/sample", name = "hello-sample")
public class SampleServlet extends GenericServlet
{

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException
	{
		servletResponse.getWriter().println("Hello Sample!");
	}
}
