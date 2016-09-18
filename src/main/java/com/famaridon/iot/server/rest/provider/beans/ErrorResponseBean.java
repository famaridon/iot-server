package com.famaridon.iot.server.rest.provider.beans;

/**
 * Created by famaridon on 18/09/2016.
 */
public class ErrorResponseBean
{
	private String message;
	
	/**
	 * get {@link ErrorResponseBean#message} property
	 *
	 * @return get the message property
	 **/
	public String getMessage()
	{
		return message;
	}
	
	public ErrorResponseBean setMessage(String message)
	{
		this.message = message;
		return this;
	}
}
