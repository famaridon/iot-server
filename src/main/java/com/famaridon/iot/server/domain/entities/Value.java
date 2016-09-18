package com.famaridon.iot.server.domain.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class Value extends AbstractEntity
{
	private BigDecimal value;
	
	/**
	 * get {@link Value#value} property
	 *
	 * @return get the value property
	 **/
	public BigDecimal getValue()
	{
		return value;
	}
	
	public Value setValue(BigDecimal value)
	{
		this.value = value;
		return this;
	}
}
