package com.lti.dao;

import java.util.List;

import com.lti.model.Bidder;
import com.lti.model.FarmerRegisteration;

public interface BidderDaoImp {
	
	Bidder register(Bidder br);
	List<Bidder> getAllBidder();
	boolean Logincredential(String email_id,String password);
	Bidder updateBidder(int bidder_id);
    Integer getBidderRegisteredCount();
	
	Integer getBidderApprovedCount();
	List<Bidder> getBidderList();
	Bidder updatePassword(String email_id,String password);
	String checkAdminApproval(String email_id);
}
