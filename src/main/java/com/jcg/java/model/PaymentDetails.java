package com.jcg.java.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class PaymentDetails {
	private String payment_id;
	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	private String user_name;
	private double card_no;
	private int ccv;
	private String month;
	private String year;
	
	public PaymentDetails() {
		
	}

	public PaymentDetails(String user_name, double card_no, int ccv) {
		super();
		this.user_name = user_name;
		this.card_no = card_no;
		this.ccv = ccv;
		
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public double getCard_no() {
		return card_no;
	}

	public void setCard_no(double card_no) {
		this.card_no = card_no;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}

