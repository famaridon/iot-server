package com.famaridon.iot.server;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.ejb.EJBFraction;
import org.wildfly.swarm.jpa.JPAFraction;

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
			d.driverClassName("com.mysql.jdbc.Driver");
			d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
			d.driverModuleName("com.mysql");
		}).dataSource("IoTServer", (ds) ->
		{
			ds.jndiName("java:jboss/datasources/IoTServer");
			ds.driverName("mysql");
			ds.connectionUrl("jdbc:mysql://localhost:3306/iotserver");
			ds.userName("root");
			ds.password("manager");
		}));
		
		/**
		 * enable EJB
		 */
		swarm.fraction(EJBFraction.createDefaultFraction());
		/**
		 * enable JPA
		 */
		swarm.fraction(JPAFraction.createDefaultFraction());
		
		swarm.start();
	}
}
