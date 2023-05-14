package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ReadConfig {
	public static Properties pro;
	public ReadConfig() {
		File src=new File("C:\\Users\\arupk\\eclipse-workspace\\seleniumproject\\config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro=new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getApplicationUrl() {
		String url=pro.getProperty("url");
		return url;
	}
	public String getApplicationUsername() {
		String user=pro.getProperty("username");
		return user;
	}
	public String getApplicationPassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getApplicationpassword() {
		String pass=pro.getProperty("password");
		return pass;
	}
	


}
