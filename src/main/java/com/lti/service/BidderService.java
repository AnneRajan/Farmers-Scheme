package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BidderDaoClass;
import com.lti.model.Bidder;
import com.lti.model.FarmerRegisteration;

@Service
@Transactional
public class BidderService {
	@Autowired
	BidderDaoClass bidderdao;
	
	public Bidder register(Bidder br) {
		return bidderdao.register(br);
	}
	
	public List<Bidder> showbidder() {
		return bidderdao.getAllBidder();
	}


	public boolean LogincredentialBidder(String email_id, String password) {
		return bidderdao.Logincredential(email_id, password);
	}	
	
	public Bidder updateBidder(int bidder_id) {
		return bidderdao.updateBidder(bidder_id);
	}

	public Integer getBidderRegisteredCount() {
		return bidderdao.getBidderRegisteredCount();
	}
	
	public Integer getBidderApprovedCount() {
		return bidderdao.getBidderApprovedCount();
	}
	
	public List<Bidder> getBidderList() {
		return bidderdao.getBidderList();
	}
	
	public Bidder updatePassword(String email_id,String password) {
		return bidderdao.updatePassword(email_id, password);
	}
	
	public String checkadminapproval(String email_id){
		return bidderdao.checkAdminApproval(email_id);
	}
}
