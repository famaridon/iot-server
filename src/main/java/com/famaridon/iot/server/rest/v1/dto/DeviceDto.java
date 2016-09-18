package com.famaridon.iot.server.rest.v1.dto;

/**
 * Created by famaridon on 23/05/2016.
 */
public class DeviceDto extends AbstractDto
{
	
	private String uuid;
	
	private String name;
	
	/**
	 * get {@link DeviceDto#uuid} property
	 *
	 * @return get the uuid property
	 **/
	public String getUuid()
	{
		return uuid;
	}
	
	/**
	 * set {@link DeviceDto#uuid} property
	 *
	 * @param uuid set the uuid property
	 **/
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	
	/**
	 * get {@link DeviceDto#name} property
	 *
	 * @return get the name property
	 **/
	public String getName()
	{
		return name;
	}
	
	/**
	 * set {@link DeviceDto#name} property
	 *
	 * @param name set the name property
	 **/
	public void setName(String name)
	{
		this.name = name;
	}
	
}
