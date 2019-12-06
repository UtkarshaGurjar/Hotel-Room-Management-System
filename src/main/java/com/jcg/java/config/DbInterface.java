package com.jcg.java.config;

import java.sql.SQLException;
import java.util.List;

import com.jcg.java.model.BillingDetails;
import com.jcg.java.model.Book;
import com.jcg.java.model.Hotel;
import com.jcg.java.model.PaymentDetails;
import com.jcg.java.model.Room;
import com.jcg.java.model.User;

public interface DbInterface {
public String	getLoginDetailsFromDb(User user) throws SQLException;
public String saveBillingDetails(BillingDetails bill);
public String saveUsersDetails(User user);
public List<Hotel> getSearchDetails(String searchString);
public String savePaymentDetails(PaymentDetails dumbpay);
public List<Room> getRoomDetails(String hotel_name,String room_type,String hotel_address);
public String getBookingId(String hotel_id, String room_id);
public String setRoomFlag(String room_id,int booking_id);
public String getCancelDetailsFromDb(Book book);
}
