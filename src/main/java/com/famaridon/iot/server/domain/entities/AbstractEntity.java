package com.famaridon.iot.server.domain.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by famaridon on 24/08/2016.
 */
@MappedSuperclass
public abstract class AbstractEntity
{
	
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * get {@link AbstractEntity#id} property
	 *
	 * @return get the id property
	 **/
	public Long getId()
	{
		return id;
	}
	
	/**
	 * set {@link AbstractEntity#id} property
	 *
	 * @param id set the id property
	 **/
	public void setId(Long id)
	{
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		
		if (!(o instanceof AbstractEntity))
		{
			return false;
		}
		
		AbstractEntity that = (AbstractEntity)o;
		
		return new EqualsBuilder().append(id, that.id).isEquals();
	}
	
	@Override
	public int hashCode()
	{
		return new HashCodeBuilder(17, 37).append(id).toHashCode();
	}
}
