package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.FarmerDaoClass;
import com.lti.model.FarmerRegisteration;

@Service
@Transactional
public class FarmerServiceClass {
	@Autowired
	FarmerDaoClass farmerdao;
	
	public FarmerRegisteration register(FarmerRegisteration fr) {
		return farmerdao.farmerregister(fr);
	}	
	
	
	public List<FarmerRegisteration> showfarmer() {
		return farmerdao.getAllFarmer();
	}


	public boolean Logincredential(String email_id, String password) {
		return farmerdao.Logincredential(email_id, password);
	}	
	
	public FarmerRegisteration updateFarmer(int farmer_id) {
		return farmerdao.updateFarmer(farmer_id);
	}
	
	public Integer getFarmerRegisteredCount() {
		return farmerdao.getFarmerRegisteredCount();
	}
	
	public Integer getFarmerApprovedCount() {
		return farmerdao.getFarmerApprovedCount();
	}
	
	public String checkAdminApproval(String email_id) {
		return farmerdao.checkAdminApproval(email_id);
	}
	
	public List<FarmerRegisteration> getFarmerList() {
		return farmerdao.getFarmerList();
	}


	public FarmerRegisteration updatePassword(String email_id, String password) {
		// TODO Auto-generated method stub
		return farmerdao.updatePassword(email_id,password);
	}
}
