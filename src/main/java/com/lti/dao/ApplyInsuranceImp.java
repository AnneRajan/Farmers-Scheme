package com.lti.dao;

import java.util.List;

import com.lti.model.ApplyInsurance;

public interface ApplyInsuranceImp {
	ApplyInsurance applyInsuranceCreation(ApplyInsurance applyinsurance);

	List<ApplyInsurance> getInsuranceList();

	String updateInsuranceList(int policy_no);
	
	List<ApplyInsurance> viewMyInsurance(String email_id);

}
