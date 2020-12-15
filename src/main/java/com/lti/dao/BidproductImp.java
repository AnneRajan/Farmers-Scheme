package com.lti.dao;

import java.util.List;

import com.lti.model.BidProduct;

public interface BidproductImp {
	BidProduct bidproduct(BidProduct bid);
	List<BidProduct> getallbidproduct();
}
