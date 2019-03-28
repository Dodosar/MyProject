package com.Bank.properties;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class testProperties {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println(System.getProperty("user.dir"));
		
		Properties config = new Properties();
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\Bank\\properties\\Config.properties");
		config.load(fis);
		
		
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\Bank\\properties\\OR.properties");
		OR.load(fis);		
		
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
	}

}
