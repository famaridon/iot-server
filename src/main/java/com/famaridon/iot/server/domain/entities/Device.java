package com.famaridon.iot.server.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class Device extends AbstractEntity
{
	
	@Column(unique = true)
	private String uuid;
	
	@Column
	private String name;
	
	public Device()
	{
		this.uuid = UUID.randomUUID().toString();
	}
	
	/**
	 * get {@link Device#uuid} property
	 *
	 * @return get the uuid property
	 **/
	public String getUuid()
	{
		return uuid;
	}
	
	/**
	 * set {@link Device#uuid} property
	 *
	 * @param uuid set the uuid property
	 **/
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	
	/**
	 * get {@link Device#name} property
	 *
	 * @return get the name property
	 **/
	public String getName()
	{
		return name;
	}
	
	/**
	 * set {@link Device#name} property
	 *
	 * @param name set the name property
	 **/
	public void setName(String name)
	{
		this.name = name;
	}
	
}
