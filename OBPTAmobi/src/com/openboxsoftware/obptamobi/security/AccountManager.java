package com.openboxsoftware.obptamobi.security;

import com.openboxsoftware.obptamobi.security.utils.BCrypt;

import android.content.Context;
import android.content.SharedPreferences;

public class AccountManager 
{
	private static final String PREFS_ACCOUNT_DATA = "AccountData";
	private static final String KEY_NAME = "Name";
	private static final String KEY_PASSWORD = "Password";
	
	private Context context;
	private static AccountManager instance;
	
	public static AccountManager get(Context context) {
		if(instance == null) {
			instance = new AccountManager(context);
		}
		
		return instance;
	}
	
	private AccountManager(Context context) 
	{
		this.context = context;
	}
	
	public boolean addAccount(String name, String password) {
		
		// Make sure we aren't getting null values
		if(name == null || password == null) {
			return false;
		}
		
		// Get private shared preferences
		SharedPreferences settings = context.getSharedPreferences(PREFS_ACCOUNT_DATA, Context.MODE_PRIVATE);
		
		if(settings.contains(KEY_NAME)) {
			return false;
		}
		
		// Generate a bcrypt hash of the password
		String passwordHash = BCrypt.hashPassword(password, BCrypt.generateSalt());
		
		// Add the username and hashed password to the shared preferences
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(KEY_NAME, name);
		editor.putString(KEY_PASSWORD, passwordHash);
		editor.commit();
		
		return true;
	}
	
	public Account getAccountByUsername(String username) {
		return null;
	}
	
	public void setPassword(Account account, String password) {
		
		if(password == null) {
			password = "";
		}
		
		String passwordHash = BCrypt.hashPassword(password, BCrypt.generateSalt());
		account.password = passwordHash;
	}
}
