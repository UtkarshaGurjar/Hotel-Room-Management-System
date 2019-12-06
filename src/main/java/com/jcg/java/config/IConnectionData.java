package com.jcg.java.config;

import java.sql.ResultSet;
import java.sql.Statement;

public interface IConnectionData {
	
    public String getDriver();
	public  String getDbname(); 
		
	
	public  String getJdbcurl();
	
	
	
	public String getUserName();
		
	
	public  String getPassword();
		
	
	public String getHostname();
	
	
	public  String getPort();
}
