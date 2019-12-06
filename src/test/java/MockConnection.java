import com.jcg.java.config.IConnectionData;

public class MockConnection implements IConnectionData {
	public static  String dbName = "test";
    public  static  String userName = "harika";
    public static String password =  "password";
    public static  String hostname = "ssdi-project-db.cxqdrxxfwjtl.us-east-2.rds.amazonaws.com";
    public static  String port = "3306";
    public static  String jdbcUrl = "jdbc:mysql://localhost:3306/test_ssdi_bookandgo";
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

}
