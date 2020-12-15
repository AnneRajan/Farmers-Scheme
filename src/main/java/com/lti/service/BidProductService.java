package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BidproductDaoClass;
import com.lti.model.BidProduct;

@Service
@Transactional
public class BidProductService {
	@Autowired
	private BidproductDaoClass bpdao;
	
	public BidProduct bidproduct(BidProduct bid){
		return this.bpdao.bidproduct(bid);
	}
	
	public List<BidProduct> getallbidproduct(){
		return this.bpdao.getallbidproduct();
	}
}
