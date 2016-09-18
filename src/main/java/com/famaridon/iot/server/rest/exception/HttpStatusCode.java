package com.famaridon.iot.server.rest.exception;

import javax.ws.rs.core.Response;
import java.lang.annotation.*;

/**
 * Created by famaridon on 18/09/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.TYPE)
public @interface HttpStatusCode
{
	Response.Status value();
}
