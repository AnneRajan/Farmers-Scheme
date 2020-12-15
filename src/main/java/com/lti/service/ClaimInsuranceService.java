package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ApplyInsuranceDao;
import com.lti.dao.ClaimInsuranceDao;
import com.lti.model.ApplyInsurance;
import com.lti.model.ClaimInsurance;

@Service
@Transactional
public class ClaimInsuranceService {
	@Autowired
	ClaimInsuranceDao dao;
	
	public ClaimInsurance ClaimInsuranceCreation(ClaimInsurance claiminsurance) {
		return dao.claimInsuranceCreation(claiminsurance);
	}
	
	
	public List<ClaimInsurance> getClaimInsurance() {
		return dao.getClaimInsuranceList();
	}
	
	public String updateClaimInsuranceList(int policy_no) {
		return dao.updateClaimInsuranceList(policy_no);
	}
	
	public String checkPolicy(int policy_no) {
		return dao.checkPolicy(policy_no);
	}

}
