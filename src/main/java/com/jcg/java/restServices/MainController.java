package com.jcg.java.restServices;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.jcg.java.config.ConnectionData;
import com.jcg.java.config.DbDao;
import com.jcg.java.config.DbDetails;
import com.jcg.java.config.DbInterface;
import com.jcg.java.config.IConnectionData;
import com.jcg.java.config.MyDb;
import com.jcg.java.model.BillingDetails;
import com.jcg.java.model.Book;
import com.jcg.java.model.Hotel;
import com.jcg.java.model.PaymentDetails;
import com.jcg.java.model.Room;
import com.jcg.java.model.User;

@Singleton
@Path("/BookAndGo")
public class MainController {
	   ConnectionData cd=new ConnectionData();
   	 DbInterface dbi=new DbDao(cd);
	 
    ObjectMapper mapper = new ObjectMapper();
    
	//Request for login
    @GET
	@Path("/Login/{param}/{params}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLoginResponse(@PathParam("param") String userId,@PathParam("params") String password) throws SQLException {
    	   
            User user=new User();
            user.setUsers_email(userId);
            user.setUsers_password(password);
		String response=dbi.getLoginDetailsFromDb(user);
        if(response.equalsIgnoreCase("Logged in"))
		{return Response.status(200).entity(response).build();}else {
			
			return Response.status(404).entity(response).build();
		}
 
	}
  	 
		  @GET
			@Path("/Search/{param}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getSearchResponse(@PathParam("param") String searchString) {
		           
				List<Hotel> response=dbi.getSearchDetails(searchString);
				String json = new Gson().toJson(response);
		        if(response!=null)
				{return Response.status(200).entity(json).build();}else {
					
					return Response.status(404).entity(json).build();
				}	
}
		  
		  @POST
			@Path("/AddRegisterDetails")
			@Consumes(MediaType.APPLICATION_JSON)
		  @Produces(MediaType.TEXT_PLAIN)
			  	public Response postRegisterDetails(String userDetails) throws JsonParseException, JsonMappingException, IOException{
			  
			  
	  JSONObject requestedJSON = new JSONObject(userDetails);
			  User  user = mapper.readValue(requestedJSON.toString(), User.class);
					
				
				String dbresult=dbi.saveUsersDetails(user);
				  if(dbresult.equalsIgnoreCase("Added")) { return
				  Response.status(200).entity("Details Added").build();}else { return
				  Response.status(404).entity("Db Error").build(); }

			}
		  
		  @POST
		   	@Path("/PaymentDetails")
		  @Consumes(MediaType.APPLICATION_JSON)
		   	@Produces(MediaType.TEXT_PLAIN)
		   	public Response postPaymentDetails(String paymentDetails) throws JsonParseException, JsonMappingException, IOException {
			  JSONObject requestedJSON = new JSONObject(paymentDetails);
			  PaymentDetails dumbpay = mapper.readValue(requestedJSON.toString(), PaymentDetails.class);         
			  
			  
			  
		               //user.setUsers_password(password);
		   		String dbresult=dbi.savePaymentDetails(dumbpay);
		           if(dbresult.equalsIgnoreCase("Added"))
		   		{return Response.status(200).entity("Payment Details Added").build();}else {
		   			
		   			return Response.status(404).entity("Db Error").build();
		   		}
		    
		   	}
		  
		  
		  @POST
		   	@Path("/BillingDetails")
		  @Consumes(MediaType.APPLICATION_JSON)
		   	@Produces(MediaType.TEXT_PLAIN)
		   	public Response postBillingDetails(String billingDetails) throws JsonParseException, JsonMappingException, IOException {
			  JSONObject requestedJSON = new JSONObject(billingDetails);
			  BillingDetails dumbbill = mapper.readValue(requestedJSON.toString(), BillingDetails.class);         
			      		String dbresult=dbi.saveBillingDetails(dumbbill);
		           if(dbresult.equalsIgnoreCase("Added"))
		   		{return Response.status(200).entity("Billing Details Added").build();}else {
		   			
		   			return Response.status(404).entity("Db Error").build();
		   		}
		    
		   	}
		  
		  
		  @GET
			@Path("/roomDetails/{param}/{roomT}/{hotelAdd}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getRoomDetailsResponse(@PathParam("param") String hotel_name,@PathParam("roomT") String room_type,@PathParam("hotelAdd") String hotel_address) {
		           
				List<Room> response=dbi.getRoomDetails(hotel_name,room_type,hotel_address);
				String json = new Gson().toJson(response);
		        if(response!=null)
				{return Response.status(200).entity(json).build();}else {
					
					return Response.status(404).entity(json).build();
				}	
}
		  @GET
			@Path("/BookingDetails/{param}/{roomT}")
		  @Produces(MediaType.TEXT_PLAIN)
			public Response getBookingDetailsResponse(@PathParam("param") String hotel_id,@PathParam("roomT") String room_id) {
		         String response=dbi.getBookingId(hotel_id,room_id);  
				 if(response!="Db Error")
				{return Response.status(200).entity(response).build();}else {
					
					return Response.status(404).entity(response).build();
				}	
		  }

		  @GET
			@Path("/SetRoomFlag/{param}/{params}")
		  @Produces(MediaType.TEXT_PLAIN)
			public Response setRoomFlag(@PathParam("param") String room_id,@PathParam("params") int booking_id) {
		         String response=dbi.setRoomFlag(room_id,booking_id);  
				 if(response=="Not able to Reserve")
				{return Response.status(404).entity(response).build();}else {
					
					return Response.status(200).entity(response).build();
				}	
		  }
		  
		  @GET
		  @Path("/Cancellation/{param}")
		  @Produces(MediaType.TEXT_PLAIN)
		  public Response getCancelResponse(@PathParam("param") int bookId) {
		  Book book=new Book();
		             //Room room = new Room();
		             book.setBooking_id(bookId);
		             //get booking id and then make available flag=0 in book table
		  String response=dbi.getCancelDetailsFromDb(book);
		         if(response.equalsIgnoreCase("Cancelled"))
		  {return Response.status(200).entity(response).build();}else {

		  return Response.status(404).entity(response).build();
		  }

		  }

		  
		  	
}