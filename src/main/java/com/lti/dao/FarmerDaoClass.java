package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.lti.model.FarmerRegisteration;

@Repository
public class FarmerDaoClass implements FarmerRegisterationDao {
	@PersistenceContext	
	EntityManager em;

	@Override
	public FarmerRegisteration farmerregister(FarmerRegisteration fr) {
		FarmerRegisteration farmer =em.merge(fr);
		return farmer;
	}

	@Override
	public List<FarmerRegisteration> getAllFarmer() {
		
		Query q=em.createQuery("select m from FarmerRegisteration as m where m.admin_approval='false' ");
	
		List<FarmerRegisteration> farmerlist=q.getResultList();
		System.out.println(farmerlist);
		return farmerlist;
	}

	@Override
	public boolean Logincredential(String email_id, String password) {
		String sql="select f from FarmerRegisteration f where f.email_id='"+email_id+"'";
		boolean check=false;
		
		try{
			Query query=em.createQuery(sql);
			List<FarmerRegisteration> fr=query.getResultList();
			if (fr!=null && !fr.isEmpty()) {
				String frPass=fr.get(0).getPassword();
				if(password.equals(frPass)){
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
	public FarmerRegisteration updateFarmer(int farmer_id) {
		FarmerRegisteration uf=em.find(FarmerRegisteration.class,farmer_id);
		if(uf!=null) {
			System.out.println("not null");
			uf.setAdmin_approval("true");
		}
		return uf;

	}
	
	@Override
	public Integer getFarmerRegisteredCount() {
		
		Query q=em.createQuery("select count(m) from FarmerRegisteration as m  ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		Integer  farmercount=Integer.parseInt((q.getSingleResult().toString()));
		System.out.println(farmercount);
		return farmercount;
	}

	@Override
	public Integer getFarmerApprovedCount() {
		Query q=em.createQuery("select count(m) from FarmerRegisteration as m where m.admin_approval='true' ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		Integer  f_approve_count=Integer.parseInt((q.getSingleResult().toString()));
		System.out.println(f_approve_count);
		return f_approve_count;
	}

	
	@Override
	public String checkAdminApproval(String email_id) {
		String checkadmin=null;
		try{
			Query sql =em.createQuery("select f from FarmerRegisteration f where f.email_id='"+email_id+"'");
			FarmerRegisteration farmer = (FarmerRegisteration)sql.getSingleResult();
			FarmerRegisteration uf = em.find(FarmerRegisteration.class,farmer.getFarmer_id());
			if(uf!=null) {
				checkadmin=uf.getAdmin_approval();
			}
			
			return checkadmin;	
		}
		catch(NoResultException nre){
			return checkadmin;	
		}
	}

	
	@Override
	public List<FarmerRegisteration> getFarmerList() {
		
		Query q=em.createQuery("select m from FarmerRegisteration as m");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<FarmerRegisteration> farmerlist=q.getResultList();
		System.out.println(farmerlist);
		return farmerlist;
	}
	
	@Override
	public FarmerRegisteration updatePassword( String email_id,String password) {
		Query sql =em.createQuery("select f from FarmerRegisteration f where f.email_id='"+email_id+"'");
		try {
			FarmerRegisteration farmer  =(FarmerRegisteration)sql.getSingleResult();
			FarmerRegisteration uf = em.find(FarmerRegisteration.class,farmer.getFarmer_id());
			if(uf!=null) {
				uf.setPassword(password);
			}
			
			return uf;
		}
		catch(NoResultException nre) {
			return null;
		}
}
}
