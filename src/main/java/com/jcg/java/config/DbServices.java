package com.jcg.java.config;

public class DbServices implements IDbServices {

	private DbInterface dbi;
	public DbServices(DbInterface dbi) {
		this.dbi=dbi;
	}
	@Override
	public void Login(DbInterface dbi) {
		// TODO Auto-generated method stub
		
	}
	//@Override
//	public String Login(DbInterface dbi) {
		
		//dbi.getLoginDetailsFromDb(user)
		
	//}

}
