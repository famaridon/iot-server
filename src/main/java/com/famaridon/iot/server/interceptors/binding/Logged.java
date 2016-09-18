package com.famaridon.iot.server.interceptors.binding;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * Enable trace logging
 * Created by famaridon on 18/09/2016.
 */
@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Logged
{
}
