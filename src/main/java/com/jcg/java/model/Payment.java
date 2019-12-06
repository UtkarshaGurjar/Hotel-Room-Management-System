package com.jcg.java.model;

public class Payment {
	
	public int booking_id;
	public int payment_id;
	public String payment_date;
	public Payment() {
		
	}
	public Payment(int booking_id, int payment_id, String payment_date) {
		super();
		this.booking_id = booking_id;
		this.payment_id = payment_id;
		this.payment_date = payment_date;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	
	
	
}
