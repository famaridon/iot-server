package com.famaridon.iot.server.interceptors;

import com.famaridon.iot.server.interceptors.binding.Logged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by famaridon on 18/09/2016.
 */
@Logged
@Interceptor
public class LoggedInterceptor
{
	@AroundInvoke
	public Object manageTransaction(InvocationContext ctx) throws Exception
	{
		Logger logger = LoggerFactory.getLogger(ctx.getClass());
		try
		{
			logger.trace("Before : {}.{}({})", ctx.getClass().getName(), ctx.getMethod().getName(), ctx.getParameters());
			Object result = ctx.proceed();
			logger.trace("After : {}.{}({}) : {}", ctx.getClass().getName(), ctx.getMethod().getName(), ctx.getParameters(), result);
			return result;
		}
		catch (Exception e)
		{
			logger.trace("Exception : {}.{}({}) : ", ctx.getClass().getName(), ctx.getMethod().getName(), ctx.getParameters(), e.getMessage());
			throw e;
		}
		
	}
}
