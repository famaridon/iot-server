package com.famaridon.iot.server;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.cdi.CDIFraction;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.ejb.EJBFraction;
import org.wildfly.swarm.jaxrs.JAXRSFraction;
import org.wildfly.swarm.jpa.JPAFraction;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * Created by famaridon on 22/08/2016.
 */
public class StarterMain
{
	public static void main(String... args) throws Exception
	{
		// Instantiate the container
		Swarm swarm = new Swarm();
		
		/**
		 * build the datasource
		 */
		swarm.fraction(new DatasourcesFraction().jdbcDriver("mysql", (d) ->
		{
			d.driverModuleName("com.mysql").driverName("mysql").driverClassName("com.mysql.jdbc.Driver");
		}).dataSource("IoTServer", (ds) ->
		{
			ds.jndiName("java:jboss/datasources/IoTServer").connectionUrl("jdbc:mysql://localhost:3306/iotserver?autoReconnect=true&amp;useSSL=false").driverName("mysql").userName("root").password("manager");
		}));
		
		/**
		 * enable factions
		 */
		swarm.fraction(JPAFraction.createDefaultFraction());
		swarm.fraction(EJBFraction.createDefaultFraction());
		swarm.fraction(new CDIFraction().applyDefaults());
		swarm.fraction(new JAXRSFraction().applyDefaults());
		swarm.fraction(LoggingFraction.createDefaultLoggingFraction());
		
		swarm.start();
		
		WARArchive deployment = ShrinkWrap.create(WARArchive.class);
		deployment.addPackage("com.famaridon.iot.server");
		deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", StarterMain.class.getClassLoader()), "classes/META-INF/persistence.xml");
		deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/beans.xml", StarterMain.class.getClassLoader()), "classes/META-INF/beans.xml");
		deployment.addAllDependencies();
		
		swarm.deploy(swarm.createDefaultDeployment());
		 
	}
}
