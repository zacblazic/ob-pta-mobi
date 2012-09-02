package com.openboxsoftware.obptamobi.security;

import android.content.Context;

public class SignInHandler 
{
	private static SignInHandler instance;
	private final Context context;
	
	public static SignInHandler get(Context context)
	{
		if(instance == null)
		{
			instance = new SignInHandler(context);
		}
		
		return instance;
	}
	
	private SignInHandler(Context context)
	{
		this.context = context;
	}
	
	public static boolean authorize(String username, String password)
	{
		if(username == null || password == null)
		{
			return false;
		}
		
		if(username.equals("openbox\\zblazic") && password.equals("password"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
