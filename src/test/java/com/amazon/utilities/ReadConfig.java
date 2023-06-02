package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
		
	}
	
	public String getURL() {
		String url = pro.getProperty("BaseURL");
		return url;
	}
	
	public String getUsername() {
		String uname = pro.getProperty("uname");
		return uname;
	}

	public String getPassword() {
		String pass = pro.getProperty("pass");
		return pass;
	}
	
	public String getChromePath() {
		String Chromepath = pro.getProperty("chromepath");
		return Chromepath;
	}
	
	public String getFireFoxPath() {
		String Firefoxpath = pro.getProperty("firefoxpath");
		return Firefoxpath;
	}
}
