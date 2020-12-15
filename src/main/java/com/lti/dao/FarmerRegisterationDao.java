package com.lti.dao;

import java.util.List;

import com.lti.model.FarmerRegisteration;

public interface FarmerRegisterationDao {
	FarmerRegisteration farmerregister(FarmerRegisteration fr);
	
	List<FarmerRegisteration> getAllFarmer();
	boolean Logincredential(String email_id,String password);
	
	FarmerRegisteration updateFarmer(int farmer_id);
	
	Integer getFarmerRegisteredCount();
	
	Integer getFarmerApprovedCount();

	String checkAdminApproval(String email_id);
	
	List<FarmerRegisteration> getFarmerList();
	
	FarmerRegisteration updatePassword(String email_id, String password);
	
}
