/*
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertThat; import static
 * org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import javax.ws.rs.client.Entity; import javax.ws.rs.core.Application; import
 * javax.ws.rs.core.Response; import javax.ws.rs.core.Response.Status;
 * 
 * import org.glassfish.jersey.server.ResourceConfig; import
 * org.glassfish.jersey.test.JerseyTest; import org.junit.Test; import
 * com.jcg.java.restServices.MainController;
 * 
 * 
 * 
 * public class MainControllerTest extends JerseyTest{ //We are testing for
 * MainController Class //We have two get services to check. //1 we need to
 * check what happens if no parameters. //Whether get request is executing
 * properly
 * 
 * @Override protected Application configure() { return new
 * ResourceConfig(MainController.class); }
 * 
 * 
 * @Test public void testGetLoginDetails() { // Given String name =
 * "ssmith@gmail.com"; String pass="1234";//Dummy value for testing username and
 * password Response response =
 * target("BookAndGo/Login/"+name+"/"+pass).request() .get();
 * 
 * // Then assertEquals(response.getStatus(),200); }
 * 
 * @Test public void testWrongGetLoginDetails() { // Given String name =
 * "ssmith@gmail.com"; String pass="xyz";//Dummy value for testing username and
 * password Response response =
 * target("BookAndGo/Login/"+name+"/"+pass).request() .get();
 * 
 * // Then assertEquals(response.getStatus(),404); }
 * 
 * @Test public void searchValidString() { String name = "Hilton"; //Dummy value
 * for testing search Response response =
 * target("BookAndGo/Search/"+name).request() .get();
 * 
 * // Then assertEquals(response.getStatus(),200);
 * 
 * }
 * 
 * @Test public void searchInValidString() { String name = "xyz"; //Dummy value
 * for testing search Response response =
 * target("BookAndGo/Search/"+name).request() .get();
 * 
 * // Then assertEquals(response.getStatus(),200);
 * 
 * }
 * 
 * @Test public void RegisterDetails() { Response response =
 * target("BookAndGo/AddRegisterDetails").request() .post(Entity.text(
 * "{\"users_id\":\"\",\"users_nameFirst\":\"dss\",\"users_nameLast\":\"ds\",\"users_password\":\"1234\",\"users_email\":\"dsqd@g.com}"
 * ));
 * 
 * assertEquals(response.getStatus(),200);
 * 
 * }
 * 
 * }
 */