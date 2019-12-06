import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jcg.java.config.ConnectionData;
import com.jcg.java.config.DbDao;
import com.jcg.java.config.DbDetails;
import com.jcg.java.config.DbInterface;
import com.jcg.java.config.IConnectionData;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.User;
import com.jcg.java.restServices.MainController;
import com.mysql.jdbc.Connection;

public class MainControllerTest extends JerseyTest{

	@Override
    protected Application configure() {
       return new ResourceConfig(MainControllerTest.class);
    }
	//Here MainController depends on MyDb class
	@InjectMocks private  MockConnection mc;
	
    @Mock private IConnectionData idc;
    @Mock private DbDao dbdao;
	@Mock private Connection con;
	 @Mock	private Statement st;
	 @Mock	private ResultSet rs;
	MainController mcontroller=new MainController();
	@Before
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
		
		  ConnectionData.setJdbcUrl(mc.getJdbcurl());
		  ConnectionData.setPassword(mc.getPassword());
		  ConnectionData.setUserName(mc.getUserName());
		 
	  }
	
	@Test
	public void testLoginService() throws SQLException {
		Response res=mcontroller.getLoginResponse("ssmith@gmail.com","1234");
}
	@Test
	public void testSearchService() {
		Response res=mcontroller.getSearchResponse("Hilton");
		assertEquals(res.getStatus(),200);
	}
	@Test
	public void testRegisterService() throws JsonParseException, JsonMappingException, IOException {
		Response res=mcontroller.postRegisterDetails("{\"users_nameFirst\":\"kooll\",\"users_nameLast\":\"gh\",\"users_password\":\"1234\",\"users_email\":\"d@g.com\"}");
		
		assertEquals(res.getStatus(),200); //Checking for insertion.
		
		
	}
	//Billing details Test
	@Test
	public void testSaveBillingDetails() throws JsonParseException, JsonMappingException, IOException {
		Response res=mcontroller.postBillingDetails("{\"user_name\":\"harikapaluri\",\"add_line1\":\"dad\",\"add_line2\":\"ds\",\"city\":\"\",\"pincode\":\"50002\",\"state\":\"\",\"phone_no\":\"9980864285\",\"email\":\"fdsa@gm.com\",\"country\":\"\"}");
		assertEquals(res.getStatus(),200);
	}
	//Payment details Test
	@Test
	public void testSavePaymentDetails() throws JsonParseException, JsonMappingException, IOException {
		Response res=mcontroller.postPaymentDetails("{\"user_name\":\"harika\",\"card_no\":\"123213231322222\",\"ccv\":\"123\",\"month\":\"8\",\"year\":\"2021\"}");
		assertEquals(res.getStatus(),200);
	}
	//roomDetails
	@Test
	public void testgetRoomDetails() {
		Response res=mcontroller.getRoomDetailsResponse("Wynn","Kings Bed","28662 Concord Mall");
		//Get room data only of room is available.
		
		assertEquals(res.getStatus(),200);
	}
	//BookingDetails
	@Test
	public void testBookingDetails() {
		Response res=mcontroller.getBookingDetailsResponse("1","W110");
		//Getting details of a booked room
		assertEquals(res.getStatus(),200);
	}
}
