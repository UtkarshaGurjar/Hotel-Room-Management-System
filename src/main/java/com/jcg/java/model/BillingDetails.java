package com.jcg.java.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class BillingDetails {
	private String user_name;
	private String add_line1;
	private String add_line2;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String email;
	private String phone_no;
	
	public BillingDetails(String user_name, String add_line1, String add_line2, String city, String pincode, String state,
			String country, String email, String phone_no) {
		super();
		this.user_name = user_name;
		this.add_line1 = add_line1;
		this.add_line2 = add_line2;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.email = email;
		this.phone_no = phone_no;
	}




	public BillingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone_no() {
		return phone_no;
	}




	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}




	public String getAdd_line1() {
		return add_line1;
	}

	public void setAdd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}

	public String getAdd_line2() {
		return add_line2;
	}

	public void setAdd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
		
}

