package com.jcg.java.config;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jcg.java.model.BillingDetails;
import com.jcg.java.model.Book;
import com.jcg.java.model.Hotel;
import com.jcg.java.model.PaymentDetails;
import com.jcg.java.model.Room;
import com.jcg.java.model.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DbDao implements DbInterface{
    
	IConnectionData cd;
	public DbDao(IConnectionData connData) {
		this.cd=connData;
	}
	
	@Override
	public String getLoginDetailsFromDb(User user) throws SQLException {
		 Connection connection = null; 
		 String response="No user Exists";
			String correctpwd="";
			try {
		   	String sql ="select *  from USERS WHERE users_email = '" + user.users_email + "' AND users_password = " + user.users_password ;
	           	Statement stmtObj =ConnectionUtility.getConnection(cd).prepareStatement(sql);
				ResultSet rsObj = stmtObj.executeQuery(sql);
				
		        if(rsObj.next()){
		        correctpwd=rsObj.getString("users_password");
					
				}
		        
		        if(correctpwd.equalsIgnoreCase(user.users_password)) {
		        	response="Logged in";
		        	
		        }else {
		        
		        }
				
			} catch (SQLException sqlExObj) {
				sqlExObj.printStackTrace();
			} finally {
			return response;
			}
	}

	@Override
	public String saveBillingDetails(BillingDetails bill) {
		Connection connection = null; 
		String response="Db error"; try {
			 
			  String sql ="INSERT INTO Billing_details VALUES (null,?, ?, ?, ?, ?,?, ?, ?, ?)";
			 java.sql.PreparedStatement ps =ConnectionUtility.getConnection(cd).prepareStatement(sql);
			 
			  ps.setString(1,bill.getUser_name()); 
			  ps.setString(2,bill.getAdd_line1()); 
			  ps.setString(3, bill.getAdd_line2());
			  ps.setString(4, bill.getCountry());
			  ps.setString(5, bill.getCity());
			  ps.setString(6, bill.getPincode());
			  ps.setString(7, bill.getState());
			  ps.setString(8, bill.getPhone_no());
			  ps.setString(9,bill.getEmail());
			  if(ps.executeUpdate()!=0) {
				  response="Added"; 
			  }
		}
		catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
			   return response; }
	}

	@Override
	public String saveUsersDetails(User user) {
		Connection connection = null; 
		String response="Db error"; try {
			 
			  String sql ="INSERT INTO users ("+"user_id,"+"users_nameFirst,"+"users_nameLast"+",users_email"+",users_password) VALUES (null,?,?, ?,?)";
		 java.sql.PreparedStatement ps =ConnectionUtility.getConnection(cd).prepareStatement(sql);
					 
			  ps.setString(1,user.users_nameFirst); 
			  ps.setString(2,user.users_nameLast);
			  ps.setString(3,user.users_email); 
			 
			  ps.setString(4,user.users_password); 
			  if(ps.executeUpdate()!=0) {
				  response="Added"; 
			  }
		}
		catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
			   return response; }
	}

	@Override
	public List<Hotel> getSearchDetails(String searchString) {
		Hotel hotel = null;
		
		
		List<Hotel> eList = new ArrayList<Hotel>();
 	String sql ="SELECT GROUP_CONCAT(t2.room_type) as roomtype,t1.hotel_id,t1.hotel_name,t1.hotel_address FROM (SELECT * FROM hotel) t1 RIGHT OUTER JOIN (SELECT * FROM room) t2 ON t1.hotel_id = t2.hotel_id where t1.hotel_name="+"'"+searchString+"'"+"OR t1.hotel_address="+"'"+searchString+"' GROUP BY t1.hotel_id";
    //String sql1="SELECT  t2.room_type FROM (SELECT * FROM hotel) t1 RIGHT OUTER JOIN (SELECT * FROM room) t2 ON t1.hotel_id = t2.hotel_id where t1.hotel_name="+"'"+searchString+"' OR t1.hotel_address="+"'"+searchString+"'"; 	
 	try{
       		
       		Statement stmtObj =ConnectionUtility.getConnection(cd).prepareStatement(sql);
       		
		ResultSet rsObj = stmtObj.executeQuery(sql);
		
		//Getting the hotel details from search 
		
while(rsObj.next()) {
	hotel = new Hotel(rsObj.getInt("hotel_id"), rsObj.getString("hotel_name"), rsObj.getString("hotel_address"));
	      if(rsObj.getString("hotel_name")!=null)
	      { 
	    	     	  hotel.setRoom_type(rsObj.getString("roomtype"));
	      }
	eList.add(hotel);	
       	}
       	
       	
       	}
       	
       	
       	
       	catch(SQLException sqlExObj) {
       		sqlExObj.printStackTrace();
       	}
       	finally {
       		return eList;
	}
	

}

	@Override
	public String savePaymentDetails(PaymentDetails dumbpay) {
		String response="Db error"; try {
			 String sql ="INSERT INTO Payment_details(user_id,user_name,card_no,ccv) VALUES (null,null,?, ?)";
			 java.sql.PreparedStatement ps =ConnectionUtility.getConnection(cd).prepareStatement(sql);
			  
			  ps.setDouble(1, dumbpay.getCard_no());
			  ps.setInt(2, dumbpay.getCcv());
			  if(ps.executeUpdate()!=0) {
				  response="Added"; 
			  }
		}
		catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
			   return response; }
	}

	@Override
	public List<Room> getRoomDetails(String hotel_name, String room_type, String hotel_address) {
		Room room = null;
		List<Room> eList = new ArrayList<Room>();
		String sql="SELECT t2.hotel_id,t2.room_id,t2.room_type,t2.roomAvailableFlag,t2.roomPrice,t2.no_of_beds,t2.room_floor FROM (SELECT * FROM hotel) t1 RIGHT OUTER JOIN (SELECT * FROM room) t2 ON t1.hotel_id = t2.hotel_id WHERE t2.room_type="+"'"+room_type+"'"+" AND t2.roomAvailableFLag='1' AND t1.hotel_name="+"'"+hotel_name+"'"+"AND t1.hotel_address="+"'"+hotel_address+"'";
		
	       	try{
	       		
	       		Statement stmtObj =ConnectionUtility.getConnection(cd).prepareStatement(sql);
			ResultSet rsObj = stmtObj.executeQuery(sql);
			//Getting the hotel details from search 
	while(rsObj.next()) {
		room = new Room(rsObj.getString("room_id"),rsObj.getInt("hotel_id"),rsObj.getString("room_type"),rsObj.getInt("room_floor"),rsObj.getString("roomAvailableFlag"),rsObj.getInt("no_of_beds"),rsObj.getString("roomPrice"));
	   
		eList.add(room);	
	       	}
	       	
	       	
	       	}
	       	
	       	
	       	
	       	catch(SQLException sqlExObj) {
	       		sqlExObj.printStackTrace();
	       	}
	       	finally {
	       		return eList;
	       	}
	}

	@Override
	public String getBookingId(String hotel_id, String room_id) {
		// TO generate Booking Id
					String response="Db error"; try {
						 String sql ="INSERT INTO book(booking_id,hotel_id,room_id) VALUES (null,?, ?)";
						 String sql1="Select booking_id  FROM book where room_id="+"'"+room_id+"'";
						 java.sql.PreparedStatement ps =ConnectionUtility.getConnection(cd).prepareStatement(sql);
						 Statement stmtObj =ConnectionUtility.getConnection(cd).prepareStatement(sql1);
						  ps.setString(1,hotel_id); 
						  ps.setString(2,room_id);
						  
						  if(ps.executeUpdate()!=0) {
							  //Row inserted for booking
							  ResultSet rsObj = stmtObj.executeQuery(sql1);
							  //retriveing booking_id
							  while(rsObj.next()) {
								  response=Integer.toString(rsObj.getInt("booking_id"));
							  }
							  
						  }
					}
					catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
						   return response; }
	}

	@Override
	public String setRoomFlag(String room_id, int booking_id) {
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		String response="Not able to reserve"; try {
			 String sql1 ="INSERT INTO payment(payment_id,booking_id,payment_date) VALUES (null,?, ?)";
			 String sql ="UPDATE room SET roomAvailableFlag='0'  where room_id="+"'"+room_id+"'";
			 String sql2="Select payment_id FROM payment where booking_id="+booking_id;
			  java.sql.PreparedStatement ps =ConnectionUtility.getConnection(cd).prepareStatement(sql);
			  java.sql.PreparedStatement ps1 =ConnectionUtility.getConnection(cd).prepareStatement(sql1);
			  ps1.setInt(1,booking_id);
			  ps1.setDate(2,ourJavaDateObject);
			 		  if(ps.executeUpdate()!=0) {
			 			//If payment details are successful we can insert values  for a paymentId also.
			 			 Statement stmtObj=ConnectionUtility.getConnection(cd).prepareStatement(sql2);
			 			  		  if(ps1.executeUpdate()!=0) {
			 				 ResultSet rsObj = stmtObj.executeQuery(sql2);
			 				 //If update has happened then send payment id as reponse to the user.
			 				 while(rsObj.next()) {
			 					response=Integer.toString(rsObj.getInt("payment_id"));
			 				 }
			 			  }else {
			 				  response="Payment Not Done";
			 			  }
				   }else {
					   response="Server Error";
				   }
		}
		catch (SQLException sqlExObj) { sqlExObj.printStackTrace(); } finally {
			   return response; }
	}

	@Override
	public String getCancelDetailsFromDb(Book book) {
		String response="Wrong Booking ID! \nPlease put a valid booking ID.";
		String flag="0";
		try 
		{
			String sql2 ="select roomAvailableFlag from book b INNER JOIN room USING(room_id) WHERE b.booking_id =" + book.getBooking_id();
	        Statement stmtObj =ConnectionUtility.getConnection(cd).prepareStatement(sql2);
			ResultSet rsObj = stmtObj.executeQuery(sql2);
			if(rsObj.next())
			{
		        flag=rsObj.getString("roomAvailableFlag");
				if(flag.equalsIgnoreCase("0"))
				{
					String sql1= " UPDATE room r inner join book b using(room_id) set r.roomAvailableFlag='1'  where b.booking_id =" + book.getBooking_id();
					String sql ="DELETE FROM payment WHERE booking_id =" + book.getBooking_id();
					String sqlbook="DELETE FROM book WHERE booking_id =" + book.getBooking_id();
					stmtObj.executeUpdate(sql1);					
					if((stmtObj.executeUpdate(sql)!=0) && (stmtObj.executeUpdate(sqlbook)!=0))
					{
						 response="Cancelled";
					}
				}
				else
				{
					return response;
				}
			}
			else
			{
				return response;
			}
			} 
		catch (SQLException sqlExObj) 
		{
			//sqlExObj.printStackTrace();
			return response;
		}
		finally {
			//disconnectDb();
			return response;
			}
	}
}

