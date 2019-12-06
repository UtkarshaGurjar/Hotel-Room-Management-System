/*
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertThrows;
 * 
 * import java.sql.Connection; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.sql.Statement;
 * 
 * import javax.ws.rs.core.Application;
 * 
 * import org.glassfish.jersey.server.ResourceConfig; import
 * org.glassfish.jersey.test.JerseyTest; import org.junit.Before; import
 * org.junit.Test;
 * 
 * import com.jcg.java.config.DbDetails; import com.jcg.java.config.MyDb;
 * 
 * 
 * public class MydbSQLTest extends JerseyTest{
 * 
 * @Override protected Application configure() { return new
 * ResourceConfig(MyDb.class); }
 * 
 * private Connection con; private Statement st; private ResultSet rsObj; MyDb
 * myDb=new MyDb();
 * 
 * @Before public void setUp() throws Exception { //Creating mock object of my
 * db class
 * 
 * con=myDb.connectDb(); st=con.createStatement();
 * 
 * }
 * 
 * @Test public void login() { String correctpwd="12345"; //Initial wrong
 * password String response="No user exists"; String sql
 * ="select *  from USERS WHERE users_email = ssmith@gmail.com AND users_password =1234"
 * ; try { st =con.prepareStatement(sql); rsObj = st.executeQuery(sql);
 * 
 * if(rsObj.next()){ correctpwd=rsObj.getString("users_password"); }
 * 
 * if(correctpwd.equalsIgnoreCase("1234")) { response="Logged in";
 * 
 * }else {
 * 
 * } assertEquals("Logged in",response); }catch(SQLException sqlExObj) {
 * 
 * } }
 * 
 * @Test public void WrongLogin() { String correctpwd="12345"; //Initial wrong
 * password String response="No user exists"; String sql
 * ="select *  from USERS WHERE users_email = fds.com AND users_password =1234";
 * try { st =con.prepareStatement(sql); rsObj = st.executeQuery(sql);
 * correctpwd=rsObj.getString("users_password"); }catch(SQLException sqlExObj) {
 * //Since no user exists it should go into this catch
 * assertEquals("No user exists",response); }
 * 
 * }
 * 
 * @Test public void Search() { String searchString="Hilton"; //Here entered
 * hotel name String response=""; String sql
 * ="SELECT * FROM (SELECT * FROM hotel) t1 LEFT OUTER JOIN (SELECT * FROM event) t2 ON t1.event_id = t2.event_id WHERE t1.hotel_name='"
 * +searchString +
 * "'OR t2.event_name='"+searchString+"'OR t1.hotel_address='"+searchString+"'"
 * ; try { st = con.prepareStatement(sql); rsObj = st.executeQuery(sql);
 * while(rsObj.next()) { response=rsObj.getString("hotel_name");}
 * }catch(SQLException sqlExObj) { //Since no user exists it should go into this
 * catch assertEquals(searchString,response); }
 * 
 * }
 * 
 * @Test public void Register() { String response="db error"; String sql
 * ="INSERT INTO users ("+"users_id,"+"users_nameFirst,"+"users_nameLast"+
 * ",users_email"+",users_type"+",users_password) VALUES (?,?,?, ?,null,?)"; try
 * { java.sql.PreparedStatement ps = con.prepareStatement(sql); int
 * userid=randomNumberGen(); ps.setInt(1,userid); ps.setString(2,"hp");
 * ps.setString(3,"sai"); ps.setString(4,"g.com");
 * //ps.setString(5,user.users_type); ps.setString(5,"123");
 * if(ps.executeUpdate()!=0) { response="Added"; } } catch(SQLException
 * sqlExObj) {
 * 
 * } assertEquals("Added",response);
 * 
 * } public int randomNumberGen(){ return (int) ( Math.random()*10); } }
 * 
 * 
 */