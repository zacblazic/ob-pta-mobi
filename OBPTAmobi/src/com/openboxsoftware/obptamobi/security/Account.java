package com.openboxsoftware.obptamobi.security;

public class Account 
{
	String name;
	String type;
	String password;
	
	public Account(String name, String type) 
	{
		this.name = name;
		this.type = type;
		this.password = new String();
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		if(name == null) 
		{
			throw new IllegalArgumentException("Name is required");
		}
		
		this.name = name;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type)
	{
		if(type == null) 
		{
			throw new IllegalArgumentException("Type is required");
		}
		
		this.type = type;
	}
}
