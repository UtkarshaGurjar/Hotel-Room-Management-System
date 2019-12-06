package com.jcg.java.model;

public class Book {

	public int booking_id;
	public String Room_id;
	public String users_nameFirst;
	public int hotel_id;
	
	
	
	public Book() {
	}

	public Book(int booking_id, String room_id, int hotel_id) {
		super();
		this.booking_id = booking_id;
		Room_id = room_id;
		hotel_id=hotel_id; 
		
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(String room_id) {
		Room_id = room_id;
	}

	public String getUsers_nameFirst() {
		return users_nameFirst;
	}

	public void setUsers_nameFirst(String users_nameFirst) {
		this.users_nameFirst = users_nameFirst;
	}

		

}
