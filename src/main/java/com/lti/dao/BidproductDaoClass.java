package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.BidProduct;


@Repository
public class BidproductDaoClass implements BidproductImp {
	
	@PersistenceContext
	EntityManager em;

	
	
	public List<BidProduct> getallbidproduct(){
		Query q=em.createQuery("select b from BidProduct b");
		List<BidProduct> bidproductlist=q.getResultList();
		return bidproductlist;
	}



	@Override
	public BidProduct bidproduct(BidProduct bid) {
		BidProduct bidprod=em.merge(bid);
		return bidprod;
	}
}
