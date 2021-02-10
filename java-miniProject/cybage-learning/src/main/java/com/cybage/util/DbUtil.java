package com.cybage.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String dbUrl;
	private static String dbUser;
	private static String dbPassword;
	
	static {		
		try {
			FileReader reader = new FileReader("D:\\dbdev.properties");
			Properties props = new Properties();
			
			props.load(reader);
			dbUrl = props.getProperty("dbUrl");
			dbUser = props.getProperty("dbUser");
			dbPassword = props.getProperty("dbPassword");
			System.out.println(dbUrl + dbUser + dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to create connection and return its object
	public static Connection getCon() throws SQLException  {
		BasicDataSource ds = new BasicDataSource();
		
		ds.setUrl(dbUrl);
		ds.setUsername(dbUser);
		ds.setPassword(dbPassword);
		ds.setDriverClassName(driverClassName);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);		
		
		return ds.getConnection(); 
	}
}
