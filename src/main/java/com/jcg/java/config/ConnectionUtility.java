package com.jcg.java.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
public static Connection getConnection(IConnectionData ic) {
	Connection connObj = null;
	
    String userName =ic.getUserName();
    String password =ic.getPassword();
    String jdbcUrl =ic.getJdbcurl();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connObj = DriverManager.getConnection(jdbcUrl,userName,password);			
} catch (Exception exObj) {
		exObj.printStackTrace();
	}
	return connObj;
}
}
