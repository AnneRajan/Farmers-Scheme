package com.lti.dao;

import java.util.List;

import com.lti.model.ClaimInsurance;

public interface ClaimInsuranceImp {
	ClaimInsurance claimInsuranceCreation(ClaimInsurance claiminsurance);

	List<ClaimInsurance> getClaimInsuranceList();

	String updateClaimInsuranceList(int policy_no);
	
	String checkPolicy(int policy_no);
	
}
