package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.Crop;
import com.lti.model.FarmerRegisteration;
import com.lti.model.SoldHistory;

@Repository
public class CropDaoClass implements CropDaoImp {
	@PersistenceContext
	EntityManager em;
	
	


	public Crop placesellrequest(Crop c) {
		Crop crop =em.merge(c);
		return crop;
	}


	@Override
	public List<Crop> getcrop() {
		
		Query q=em.createQuery("select m from Crop as m");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<Crop> croplist=q.getResultList();
		return croplist;

	}


	@Override
	public List<SoldHistory> gethistory() {
Query q=em.createQuery("select m from SoldHistory as m");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<SoldHistory> soldlist=q.getResultList();
		return soldlist;
	}




	

}
