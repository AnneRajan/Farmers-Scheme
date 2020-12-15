package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ApplyInsuranceDao;
import com.lti.model.ApplyInsurance;

@Service
@Transactional
public class ApplyInsuranceService {
	
	@Autowired
	ApplyInsuranceDao dao;
	
	public ApplyInsurance ApplyInsuranceCreation(ApplyInsurance applyinsurance) {
		return dao.applyInsuranceCreation(applyinsurance);
	}
	
	public List<ApplyInsurance> getInsuranceList() {
		return  dao.getInsuranceList();
	}

	public String updateInsuranceList(int policy_no) {
		return dao.updateInsuranceList(policy_no);
	}
	
	public List<ApplyInsurance> viewMyInsurance(String email_id){
		return dao.viewMyInsurance(email_id);
	}
}
