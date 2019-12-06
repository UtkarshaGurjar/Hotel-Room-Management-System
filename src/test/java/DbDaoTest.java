import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jcg.java.config.ConnectionData;
import com.jcg.java.config.DbDao;
import com.jcg.java.config.DbDetails;
import com.jcg.java.config.DbInterface;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.BillingDetails;
import com.jcg.java.model.Hotel;
import com.jcg.java.model.PaymentDetails;
import com.jcg.java.model.Room;
import com.jcg.java.model.User;
import com.mysql.jdbc.Connection;

public class DbDaoTest extends JerseyTest {

	@Override
    protected Application configure() {
        return new ResourceConfig(DbDaoTest.class);
    }
	//MyDb has methods which internally use user,hotel
	@InjectMocks private User user;
	 @Mock private Connection con;
	 @Mock	private Statement st;
	 @Mock	private ResultSet rs;
     
	 
	 MockConnection mc=new MockConnection();
	 
	@Before
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
		
	  }
	
	DbInterface dbi=new DbDao(mc);
	 User dummyuser;
	
	
	@Test
 public void testLogin() throws SQLException {
		
		user.setUsers_password("1234");
		user.setUsers_email("g@gmail.com");
		String resp=dbi.getLoginDetailsFromDb(user);
		assertEquals("Logged in",resp);
	}
	@Test
	 public void testwrongLogin( ) throws SQLException {
			
			user.setUsers_password("2314");
			user.setUsers_email("ssmith@gmail.com");
			String resp=dbi.getLoginDetailsFromDb(user);
			assertEquals("No user Exists",resp);
		}
	@Test
	 public void searchFunction() {
			List<Hotel> l=dbi.getSearchDetails("Hilton");
			String response="Nothing retrieved";
			for(Hotel h:l) {
				if(h.getHotel_name()!=null) {
					 response="Retrieved";
					break;
				}
		}
			assertEquals("Retrieved",response);
		}
	@Test
	 public void wrongsearchFunction() {
			List<Hotel> l=dbi.getSearchDetails("xyz");
			String response="Nothing retrieved";
			for(Hotel h:l) {
				if(h.getHotel_name()!=null) {
					 response="Retrieved";
					break;
				}
		}
			assertEquals("Nothing retrieved",response);
		}
	@Test
	 public void testRegister() {
			user.setUsers_email("g@gmail.com");
			int userid=randomNumberGen();
			user.setUsers_nameFirst("randomTestuser");
			user.setUsers_password("1234");
			String resp=dbi.saveUsersDetails(user);
			assertEquals(resp,"Added");
			
		}
	@Test
	 public void testRegisterNotWorking() {
			//Trying to insert an empty user record.
			String resp=dbi.saveUsersDetails(dummyuser);
			assertEquals(resp,"Db error");
			
			
		}
	public int randomNumberGen() {
		 int userid=(int) ((Math.random() * ((10000 - 23) + 1)) + 23);
		 return userid;
	 }
	
	@Test
	public void savePaymentDetails() {
		PaymentDetails pd=new PaymentDetails("harikapaluri",123456789023456.0,167);
		String resp=dbi.savePaymentDetails(pd);
	}

	
	  @Test public void saveBillingDetails() throws SQLException { 
	BillingDetails bd=new BillingDetails("user_name"," add_line1", "String add_line2", "city","28262"," String state",
			"String country", "String email", "String phone_no");
	String resp=dbi.saveBillingDetails(bd); assertEquals(resp,"Added"); }
	 
	@Test
	public void getRoomDetails() {
		List<Room> roomList = new ArrayList<Room>();
		//Since the roomFLag for this particular hotel entry  is available. query should fetch these details.
		String roomDetailsRetrieved="False";
		roomList=dbi.getRoomDetails("test hotel","Double Bed","test location");
		for(Room r:roomList) {
			if(r.getRoom_id()!=null) {
				roomDetailsRetrieved="True";
				break;
			}
	}
		assertEquals(roomDetailsRetrieved,"True");	
}
	@Test
	public void getBookingId() {
		//In this method based on the hotel_id and room_id we need to insert it into the database and generate a booking_id as a return value.
	    //Creating a booking entry for a room in  Marriot. 
		String resp=dbi.getBookingId("2005","1");
		//To make sure booking id is getting generated.
		assertNotEquals(resp,"Db error");	
}
}
