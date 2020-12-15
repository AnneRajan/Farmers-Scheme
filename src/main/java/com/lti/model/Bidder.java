package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bidder")
public class Bidder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bidder_id;

	@Column(name = "full_name")
	private String full_name;

	@Column(name = "contact_no")
	private int contact_no;

	@Column(name = "email_id")
	private String email_id;

	@Column(name = "address_details")
	private String address_details;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "pincode")
	private int pincode;

	@Column(name = "account_no")
	private int account_no;

	@Column(name = "ifsc_code")
	private String ifsc_code;
	
	

	@Column(name = "password")
	private String password;
	
	private  String admin_approval="false";
	
	
	@Override
	public String toString() {
		return "Bidder [bidder_id=" + bidder_id + ", full_name=" + full_name + ", contact_no=" + contact_no
				+ ", email_id=" + email_id + ", address_details=" + address_details + ", state=" + state + ", city="
				+ city + ", pincode=" + pincode + ", account_no=" + account_no + ", ifsc_code=" + ifsc_code
				+ ", password=" + password + ", admin_approval=" + admin_approval + "]";
	}

	public int getBidder_id() {
		return bidder_id;
	}

	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}

	public Bidder(String full_name, int contact_no, String email_id, String address_details, String state, String city,
			int pincode, int account_no, String ifsc_code, String aadhar_card, String pan_card, String trader_license,
			String password) {
		super();
		this.full_name = full_name;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.address_details = address_details;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.account_no = account_no;
		this.ifsc_code = ifsc_code;
		this.password = password;
	}

	public Bidder(String email_id,String password) {
		super();
		this.email_id=email_id;
		this.password=password;
	}
	

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress_details() {
		return address_details;
	}

	public void setAddress_details(String address_details) {
		this.address_details = address_details;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getAccount_no() {
		return account_no;
	}

	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin_approval() {
		return admin_approval;
	}

	public void setAdmin_approval(String admin_approval) {
		this.admin_approval = admin_approval;
	}
	
	public Bidder() {
		
		
	}
	

}
