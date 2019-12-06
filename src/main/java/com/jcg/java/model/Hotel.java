package com.jcg.java.model;




public class Hotel {
      public int hotel_id;
      public String event_name;
      public String event_times;
      public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_times() {
		return event_times;
	}
	public void setEvent_times(String event_times) {
		this.event_times = event_times;
	}
	public String getHotel_contact() {
		return hotel_contact;
	}
	public void setHotel_contact(String hotel_contact) {
		this.hotel_contact = hotel_contact;
	}
	public String hotel_name;
      public String hotel_address;
      public String hotel_contact;
      public String Event_id;
      public String room_id;
      public String room_type;
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public Hotel() {
		
	}
	public String getEvent_id() {
		return Event_id;
	}
	public void setEvent_id(String event_id) {
		Event_id = event_id;
	}
	public Hotel(int hotel_id, String hotel_name, String hotel_address) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		room_id = room_id;
		this.room_type=room_type;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		room_id = room_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	
	
	
      
}
