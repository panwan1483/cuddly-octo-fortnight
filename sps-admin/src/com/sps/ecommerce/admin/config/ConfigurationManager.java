package com.sps.ecommerce.admin.config;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

	private static final String CONFIG_FILE1 = "config-local.properties";
	
	private static final String CONFIG_FILE2 = "/webser/java_webapps/billing/config/config.properties";

	private static ConfigurationManager self = new ConfigurationManager();

	private Properties props = new Properties();

	private ConfigurationManager() {
		InputStream in=null;
		try 
		{
			in = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE1);
			props.load(in);
		} catch (Exception e) 
		{
			try
			{
				in = new BufferedInputStream(new FileInputStream(CONFIG_FILE2));
				props.load(in);
			} catch (Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e);
			}
		}finally
		{
			try
			{
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getValue(String key) {
		return props.getProperty(key);
	}

	public static ConfigurationManager instance() {
		return self;
	}
}
