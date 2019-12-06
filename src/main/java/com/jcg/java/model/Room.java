package com.jcg.java.model;
//Utkarsha
public class Room {
	public String Room_id;
	public int hotel_id;
	public String room_type;
	public int room_floor;
	public String roomAvailableFlag;
	public String roomPrice;
	public int no_of_beds;
	public Room() {

	}
	public Room(String room_id, int hotel_id, String room_type, int room_floor, String roomAvailableFlag, int no_of_beds,String roomPrice) {
		super();
		
		
		Room_id = room_id;
		this.hotel_id = hotel_id;
		this.room_type = room_type;
		this.room_floor = room_floor;
		this.roomAvailableFlag = roomAvailableFlag;
		this.no_of_beds = no_of_beds;
		this.roomPrice=roomPrice;
	}
	public String getRoom_Price() {
		return roomPrice;
	}
	public void setRoom_Price(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoom_id() {
		return Room_id;
	}
	public void setRoom_id(String room_id) {
		Room_id = room_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getRoom_floor() {
		return room_floor;
	}
	public void setRoom_floor(int room_floor) {
		this.room_floor = room_floor;
	}
	public String getRoomAvailableFlag() {
		return roomAvailableFlag;
	}
	public void setRoomAvailableFlag(String roomAvailableFlag) {
		this.roomAvailableFlag = roomAvailableFlag;
	}
	public int getNo_of_beds() {
		return no_of_beds;
	}
	public void setNo_of_beds(int no_of_beds) {
		this.no_of_beds = no_of_beds;
	}
	
	
}

