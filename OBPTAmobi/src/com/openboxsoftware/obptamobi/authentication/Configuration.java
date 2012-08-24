package com.openboxsoftware.obptamobi.authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Configuration {
	
	private Map<String, String> options = new HashMap<String, String>();
	
	public void putOption(String name, String value) {
		options.put(name, value);
	}
	
	public String getOption(String name) {
		return options.get(name);
	}
	
	public boolean containsOption(String name) {
		return options.containsKey(name);
	}
	
	public Set<Entry<String, String>> entrySet() {
		return options.entrySet();
	}
}