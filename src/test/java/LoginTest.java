import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jcg.java.config.DbDao;
import com.jcg.java.config.DbDetails;
import com.jcg.java.config.DbInterface;
import com.jcg.java.config.IConnectionData;
import com.jcg.java.config.IDbServices;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.PaymentDetails;
import com.jcg.java.model.User;
import com.jcg.java.restServices.MainController;
import com.mysql.jdbc.Connection;

public class LoginTest{
	
    protected Application configure() {
       return new ResourceConfig(LoginTest.class);
    }
    
    @Mock IConnectionData idc;
   
	DbDao dao=new DbDao(idc);
    @Before
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }
	@Test
	public void test_constructor_injection_mock() throws SQLException {
		User user=new User();
		user.setUsers_email("harikapaluri@gmail.com");
		user.setUsers_password("1234");
		String y=dao.getLoginDetailsFromDb(user);
		assertEquals(y,"Logged in");
		}
	@Test
	public void test_constructor_injections_mock() throws SQLException {
		
		PaymentDetails pd=new PaymentDetails();
		pd.setCard_no(232132);
		pd.setCcv(23);
		//String y=mydb.savePaymentDetails(pd);
		//assertEquals(y,"Added");
		}
}