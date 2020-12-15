package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="claiminsurance")
public class ClaimInsurance {
	@Id

	private int policy_no;
	
	@Column(name="insurance_company")
	private String insurance_company;
	
	@Column(name="sum_insured")
	private int sum_insured;
	
	@Column(name="causeofloss")
	private String causeofloss;
	
	private String date_of_loss;
	
	private String farmer_email_id;
	
	private String admin_approval="false";

	

	public ClaimInsurance(int policy_no, String insurance_company, int sum_insured, String causeofloss,
			String date_of_loss, String farmer_email_id, String admin_approval) {
		super();
		this.policy_no = policy_no;
		this.insurance_company = insurance_company;
		this.sum_insured = sum_insured;
		this.causeofloss = causeofloss;
		this.date_of_loss = date_of_loss;
		this.farmer_email_id = farmer_email_id;
		this.admin_approval=admin_approval;
	}

	public ClaimInsurance() {
		super();
	}

	public int getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(int policy_no) {
		this.policy_no = policy_no;
	}

	public String getInsurance_company() {
		return insurance_company;
	}

	public void setInsurance_company(String insurance_company) {
		this.insurance_company = insurance_company;
	}

	public int getSum_insured() {
		return sum_insured;
	}

	public void setSum_insured(int sum_insured) {
		this.sum_insured = sum_insured;
	}

	public String getCauseofloss() {
		return causeofloss;
	}

	public void setCauseofloss(String causeofloss) {
		this.causeofloss = causeofloss;
	}
	
	

	public String getDate_of_loss() {
		return date_of_loss;
	}

	public void setDate_of_loss(String date_of_loss) {
		this.date_of_loss = date_of_loss;
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
		return "ClaimInsurance [policy_no=" + policy_no + ", insurance_company=" + insurance_company + ", sum_insured="
				+ sum_insured + ", causeofloss=" + causeofloss + ", date_of_loss=" + date_of_loss + ", farmer_email_id="
				+ farmer_email_id + ", admin_approval=" + admin_approval + "]";
	}

	

	

}
