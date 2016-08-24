package com.famaridon.iot.server.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class Device
{
	@Id
	private String id;
	@Column
	private String name;
	
	public Device()
	{
		this.id = UUID.randomUUID().toString();
	}
	
	/**
	 * get {@link Device#id} property
	 *
	 * @return get the id property
	 **/
	public String getId()
	{
		return id;
	}
	
	/**
	 * set {@link Device#id} property
	 *
	 * @param id set the id property
	 **/
	public void setId(String id)
	{
		this.id = id;
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
	
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Device))
		{
			return false;
		}
		Device other = (Device)obj;
		return getId().equals(other.getId());
	}
	
}
