package com.jcg.java.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcg.java.model.Hotel;



	public class DbDetails {
		public ResultSet rsObj = null;
		public Statement stmtObj = null;
		public Connection connObj = null;
		
		public static final String dbName = "test";
	    public  static final String userName = "harika";
	    public static final String password =  "password";
	    public static final String hostname = "ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com";
	    public static final String port = "3306";
	    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/ssdi_bookandgo";
		public ResultSet getRsObj() {
			return rsObj;
		}
		
		public Statement getStmtObj() {
			return stmtObj;
		}
		
		public Connection getConnObj() {
			return connObj;
		}
		
		
		
		public static String getDbName() {
			return dbName;
		}
		
		public String getUserName() {
			return userName;
		}
		
		public static String getPassword() {
			return password;
		}
		
		public static String getHostname() {
			return hostname;
		}
		
		public static String getPort() {
			return port;
		}
		
		public static String getJdbcUrl() {
			return jdbcUrl;
		}
		
		

	
		
	
	
	

}
