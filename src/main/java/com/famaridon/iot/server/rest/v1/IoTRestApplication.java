package com.famaridon.iot.server.rest.v1;

import com.famaridon.iot.server.rest.provider.JacksonConfiguration;
import com.wordnik.swagger.jaxrs.config.BeanConfig;
import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 22/08/2016.
 */
@ApplicationPath("/rest/v1")
public class IoTRestApplication extends Application
{
	private Set<Object> singleton;
	
	public IoTRestApplication()
	{
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0");
		beanConfig.setBasePath("http://localhost:8080/rest/v1");
		beanConfig.setResourcePackage("com.famaridon.iot.server.rest.v1");
		beanConfig.setScan(true);
	}
	
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> endpoints = new HashSet<>();
		
		// applications services
		endpoints.add(UsersService.class);
		endpoints.add(DevicesService.class);
		endpoints.add(JacksonConfiguration.class);
		
		// swagger
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		endpoints.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		
		return endpoints;
	}
	
	/**
	 * Get a set of root resource, provider and {@link Feature feature} instances.
	 * Fields and properties of returned instances are injected with their declared
	 * dependencies (see {@link Context}) by the runtime prior to use.
	 * <p>
	 * Implementations should warn about and ignore classes that do not
	 * conform to the requirements of root resource or provider classes.
	 * Implementations should flag an error if the returned set includes
	 * more than one instance of the same class. Implementations MUST
	 * NOT modify the returned set.
	 * </p>
	 * <p>
	 * The default implementation returns an empty set.
	 * </p>
	 *
	 * @return a set of root resource and provider instances. Returning {@code null}
	 * is equivalent to returning an empty set.
	 */
	@Override
	public Set<Object> getSingletons()
	{
		if (singleton == null)
		{
			singleton = new HashSet<>();
			CorsFilter filter = new CorsFilter();
			filter.getAllowedOrigins().add("*");
		}
		return singleton;
	}
}
