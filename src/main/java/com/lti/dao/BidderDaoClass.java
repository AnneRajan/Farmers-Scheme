package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Bidder;
import com.lti.model.FarmerRegisteration;
@Repository
public class BidderDaoClass implements BidderDaoImp{

	@PersistenceContext	
	EntityManager em;

	@Override
	public Bidder register(Bidder br) {
		Bidder  bidder =em.merge(br);
		return bidder;
	}

	@Override
	public List<Bidder> getAllBidder() {
		Query q=em.createQuery("select m from Bidder as m where m.admin_approval='false' ");
		List<Bidder> bidderlist=q.getResultList();
		return bidderlist;
	}

	@Override
	public boolean Logincredential(String email_id, String password) {
		String sql="select b from Bidder b where b.email_id='"+email_id+"'";
		boolean check=false;
		
		try{
			Query query=em.createQuery(sql);
			List<Bidder> br=query.getResultList();
			if (br!=null && !br.isEmpty()) {
				String brPass=br.get(0).getPassword();
				if(password.equals(brPass)){
					check=true;
				}
			}
			return check;
		}
		catch(NoResultException nre){
			return check;
		}
	}
	
	@Override
	public Bidder updateBidder(int bidder_id) {
		Bidder ub=em.find(Bidder.class,bidder_id);
		if(ub!=null) {
			System.out.println("not null");
			ub.setAdmin_approval("true");
		}
		return ub;
	}
	
	@Override
	public Integer getBidderRegisteredCount() {
		
		Query q=em.createQuery("select count(m) from Bidder as m  ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		Integer  biddercount=Integer.parseInt((q.getSingleResult().toString()));
		System.out.println(biddercount);
		return biddercount;
	}

	@Override
	public Integer getBidderApprovedCount() {
		Query q=em.createQuery("select count(m) from Bidder as m where m.admin_approval='true' ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		Integer  b_approve_count=Integer.parseInt((q.getSingleResult().toString()));
		System.out.println(b_approve_count);
		return b_approve_count;
	}
	
	
	@Override
	public List<Bidder> getBidderList() {
		Query q=em.createQuery("select m from Bidder as m");
		List<Bidder> bidderlist=q.getResultList();
		return bidderlist;
	}
	
	@Override
	public Bidder updatePassword(String email_id, String password) {
Query sql =em.createQuery("select b from Bidder b where b.email_id='"+email_id+"'");
		
		try{
			Bidder bidder = (Bidder)sql.getSingleResult();
			Bidder uf = em.find(Bidder.class,bidder.getBidder_id());
			if(uf!=null) {
					uf.setPassword(password);
					
				}
				return uf;
			
		}
		catch (NoResultException nre){
			return null;
		}
	}

	@Override
	public String checkAdminApproval(String email_id) {
		String checkadmin=null;
		try{
			Query sql =em.createQuery("select b from Bidder b where b.email_id='"+email_id+"'");
			Bidder bid = (Bidder)sql.getSingleResult();
			Bidder uf = em.find(Bidder.class,bid.getBidder_id());
			if(uf!=null) {
				checkadmin=uf.getAdmin_approval();
			}
			
			return checkadmin;		
		}
		catch(NoResultException nre){
			return checkadmin;
		}
	}
	

	
}


