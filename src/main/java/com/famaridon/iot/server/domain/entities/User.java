package com.famaridon.iot.server.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class User
{
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String login;

	/**
	 * get {@link User#id} property
	 *
	 * @return get the id property
	 **/
	public Long getId()
	{
		return id;
	}

	/**
	 * set {@link User#id} property
	 *
	 * @param id set the id property
	 **/
	public void setId(Long id)
	{
		this.id = id;
	}
}
