package com.famaridon.iot.server.rest.v1.dto;

import java.math.BigDecimal;

/**
 * Created by famaridon on 23/05/2016.
 */
public class ValueDto extends AbstractDto
{
	
	private BigDecimal value;
	
	/**
	 * get {@link ValueDto#value} property
	 *
	 * @return get the value property
	 **/
	public BigDecimal getValue()
	{
		return value;
	}
	
	public ValueDto setValue(BigDecimal value)
	{
		this.value = value;
		return this;
	}
}
