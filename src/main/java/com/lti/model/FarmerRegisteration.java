package com.lti.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="farmer")
public class FarmerRegisteration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int farmer_id;
	private String full_name;
	private int contact_no;
	private String email_id;
	private String address_details;
	private String city;
	private String state;
	private int pincode;
	private String land_area;
	private String land_address;
	private String land_pincode;
	private int account_no;
	private String ifsc_code;
	
	private String password;
	private String admin_approval="false";
	
	
	public int getFarmer_id() {
		return farmer_id;
	}
	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLand_area() {
		return land_area;
	}
	public void setLand_area(String land_area) {
		this.land_area = land_area;
	}
	public String getLand_address() {
		return land_address;
	}
	public void setLand_address(String land_address) {
		this.land_address = land_address;
	}
	public String getLand_pincode() {
		return land_pincode;
	}
	public void setLand_pincode(String land_pincode) {
		this.land_pincode = land_pincode;
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

	public FarmerRegisteration(String full_name, int contact_no, String email_id, String address_details, String city,
			String state, int pincode, String land_area, String land_address, String land_pincode, int account_no,
			String ifsc_code,String password) {
		super();
		this.full_name = full_name;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.address_details = address_details;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.land_area = land_area;
		this.land_address = land_address;
		this.land_pincode = land_pincode;
		this.account_no = account_no;
		this.ifsc_code = ifsc_code;
		
		this.password = password;
	}
	
	public FarmerRegisteration(String fileName, String contentType, byte[] bytes) {
		
	}
	

	public FarmerRegisteration(String email_id, String password) {
		super();
		this.email_id = email_id;
		this.password = password;
	}
	@Override
	public String toString() {
		return "FarmerRegisteration [farmer_id=" + farmer_id + ", full_name=" + full_name + ", contact_no=" + contact_no
				+ ", email_id=" + email_id + ", address_details=" + address_details + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", land_area=" + land_area + ", land_address=" + land_address
				+ ", land_pincode=" + land_pincode + ", account_no=" + account_no + ", ifsc_code=" + ifsc_code
				+ ", password=" + password + ", admin_approval=" + admin_approval + "]";
	}
	public FarmerRegisteration() {
		
	}
	
	
}
