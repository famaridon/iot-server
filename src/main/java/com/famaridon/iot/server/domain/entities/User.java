package com.famaridon.iot.server.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class User extends AbstractEntity
{
	@Column(unique = true)
	private String login;
	
	@Column
	@JsonIgnore
	private String password;
	
	@OneToMany
	private Set<Device> devices = new HashSet<>();
	
	/**
	 * get {@link User#login} property
	 *
	 * @return get the login property
	 **/
	public String getLogin()
	{
		return login;
	}
	
	/**
	 * set {@link User#login} property
	 *
	 * @param login set the login property
	 **/
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	/**
	 * get {@link User#devices} property
	 *
	 * @return get the devices property
	 **/
	public Set<Device> getDevices()
	{
		return devices;
	}
	
	/**
	 * set {@link User#devices} property
	 *
	 * @param devices set the devices property
	 **/
	public void setDevices(Set<Device> devices)
	{
		this.devices = devices;
	}
	
	/**
	 * get {@link User#password} property
	 *
	 * @return get the password property
	 **/
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * set {@link User#password} property
	 *
	 * @param password set the password property
	 **/
	public void setPassword(String password)
	{
		this.password = password;
	}
	

}
