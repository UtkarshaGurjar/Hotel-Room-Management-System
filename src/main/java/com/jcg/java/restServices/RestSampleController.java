package com.jcg.java.restServices;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jcg.java.config.DbDao;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.User;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class RestSampleController {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }
 @Inject
 DbDao db;
 
 
 	@GET
 	@Path("Login/{param}/{param}")
 	@Produces(MediaType.TEXT_PLAIN)
 	public Response getLoginResponse(@PathParam("param") String userId,@PathParam("param") String password) throws SQLException {
             User user=new User();
             user.setUsers_email(userId);
             user.setUsers_password(password);
 		String response=db.getLoginDetailsFromDb(user);
         if(response.equalsIgnoreCase("Logged in"))
 		{return Response.status(200).entity(response).build();}else {
 			
 			return Response.status(404).entity(response).build();
 		}
  
}
}
