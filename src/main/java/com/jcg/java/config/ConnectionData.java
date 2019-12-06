package com.jcg.java.config;
import com.jcg.java.config.IConnectionData;


public class ConnectionData implements IConnectionData {
	public static  String dbName = "ssd_bookandgo";
    public  static  String userName = "root";
    public static String password =  "utkarsha";
    //public static  String hostname = "ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com";
    public static  String port = "3306";
    public static  String jdbcUrl = "jdbc:mysql://localhost:3306/ssdi_bookandgo";
	@Override
	public String getDriver() {
		// TODO Auto-generated method stub
		return dbName;
	}

	@Override
	public String getDbname() {
		// TODO Auto-generated method stub
		return dbName;
	}

	@Override
	public String getJdbcurl() {
		// TODO Auto-generated method stub
		return jdbcUrl;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getHostname() {
		// TODO Auto-generated method stub
		return hostname;
	}

	@Override
	public String getPort() {
		// TODO Auto-generated method stub
		return port;
	}
   public static void setUserName(String username) {
	   userName=username;
   }
   public static void setJdbcUrl(String jdbcUrl1) {
	   jdbcUrl=jdbcUrl1;
   }
   public static void setPassword(String password1) {
	   password=password1;
   }
}
