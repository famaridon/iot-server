package com.famaridon.iot.server.rest.v1.dto;

/**
 * Created by famaridon on 25/08/2016.
 */
public class UserDto extends AbstractDto
{
	private String login;
	
	/**
	 * get {@link UserDto#login} property
	 *
	 * @return get the login property
	 **/
	public String getLogin()
	{
		return login;
	}
	
	/**
	 * set {@link UserDto#login} property
	 *
	 * @param login set the login property
	 **/
	public void setLogin(String login)
	{
		this.login = login;
	}
}
