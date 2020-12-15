package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applyinsurance")
public class ApplyInsurance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int policy_no;
	
	@Column(name="premiumamt")
	private int premiumamt;
		
	@Column(name="crop_type")
	private String crop_type;
	
	@Column(name="area")
	private int area;
	
	@Column(name="policy_for")
	private String policy_for;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;
	
	@Column(name="insurance_company")
	private String insurance_company;
	
	@Column(name="sum_insured")
	private int sum_insured;
	
	private String farmer_email_id;
	
	private String admin_approval="false";

	public ApplyInsurance(String crop_type, int area, String policy_for, String state, String district,
			String insurance_company, int premiumamt, int sum_insured,String farmer_email_id) {
		super();
		this.crop_type = crop_type;
		this.area = area;
		this.policy_for = policy_for;
		this.state = state;
		this.district = district;
		this.insurance_company = insurance_company;
		this.premiumamt = premiumamt;
		this.sum_insured = sum_insured;
		this.farmer_email_id=farmer_email_id;
	}

	public ApplyInsurance() {
		super();
	}

	
	public int getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(int policy_no) {
		this.policy_no = policy_no;
	}

	public String getCrop_type() {
		return crop_type;
	}

	public void setCrop_type(String crop_type) {
		this.crop_type = crop_type;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getPolicy_for() {
		return policy_for;
	}

	public void setPolicy_for(String policy_for) {
		this.policy_for = policy_for;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getInsurance_company() {
		return insurance_company;
	}

	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}

	public int getPremiumamt() {
		return premiumamt;
	}

	public void setPremiumamt(int premiumamt) {
		this.premiumamt = premiumamt;
	}

	public int getSum_insured() {
		return sum_insured;
	}

	public void setSum_insured(int sum_insured) {
		this.sum_insured = sum_insured;
	}

	

	public String getFarmer_email_id() {
		return farmer_email_id;
	}

	public void setFarmer_email_id(String farmer_email_id) {
		this.farmer_email_id = farmer_email_id;
		
	}
	
	

	public String getAdmin_approval() {
		return admin_approval;
	}

	public String setAdmin_approval(String admin_approval) {
		return this.admin_approval = admin_approval;
	}

	@Override
	public String toString() {
		return "ApplyInsurance [policy_no=" + policy_no + ", premiumamt=" + premiumamt + ", crop_type=" + crop_type
				+ ", area=" + area + ", policy_for=" + policy_for + ", state=" + state + ", district=" + district
				+ ", insurance_company=" + insurance_company + ", sum_insured=" + sum_insured + ", farmer_email_id="
				+ farmer_email_id + ", admin_approval=" + admin_approval + "]";
	}

	

	

	

}
