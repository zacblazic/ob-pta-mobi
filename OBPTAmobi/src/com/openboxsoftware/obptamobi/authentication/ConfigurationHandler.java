package com.openboxsoftware.obptamobi.authentication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;

public class ConfigurationHandler {
	
	public static Configuration read(File file) throws IOException {
		
		BufferedReader reader = null;
		Configuration configuration = new Configuration();
		
		try {
			
			reader = new BufferedReader(new FileReader(file));			
			String line = reader.readLine();
			
			while(line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, "=");
				
				String name = tokenizer.nextToken();
				String value = tokenizer.nextToken();
				
				configuration.putOption(name, value);
				
				line = reader.readLine();
			}
			
		} catch(IOException ioe) {
			
			if(reader != null) {
				reader.close();
			}
		}
		
		return configuration;
	}
	
	public static void write(Configuration configuration, File file) throws IOException {
		
		BufferedWriter writer = null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(file));
			
			for(Map.Entry<String, String> entry : configuration.entrySet()) {
				writer.write(entry.getKey() + "=" + entry.getValue());
				writer.newLine();
			}
			
		} catch(IOException ioe) {
			
			if(writer != null) {
				writer.close();
			}
		}
	}
}
