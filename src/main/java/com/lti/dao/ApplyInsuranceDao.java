package com.lti.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.ApplyInsurance;
import com.lti.model.FarmerRegisteration;
@Repository
public class ApplyInsuranceDao implements ApplyInsuranceImp{

	@PersistenceContext	
	 EntityManager em;
	@Override
	public ApplyInsurance applyInsuranceCreation(ApplyInsurance applyinsurance) {
		ApplyInsurance a = em.merge(applyinsurance);
		return a;
	}
	
	@Override
	public List<ApplyInsurance> getInsuranceList() {
		
		Query q=em.createQuery("select m from ApplyInsurance as m where m.admin_approval='false' ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<ApplyInsurance> ins_list=q.getResultList();
		System.out.println(ins_list);
		return ins_list;
	}
	
	
	@Override
	public String updateInsuranceList(int policy_no) {
		String checkadmin=null;
		try{
			Query sql =em.createQuery("select f from ApplyInsurance f where f.policy_no='"+policy_no+"'");
			ApplyInsurance ins = (ApplyInsurance)sql.getSingleResult();
			ApplyInsurance ui = em.find(ApplyInsurance.class,ins.getPolicy_no());
			if(ui!=null) {
				checkadmin=ui.setAdmin_approval("true");
			}
			
			return checkadmin;	
		}
		catch(NoResultException nre){
			return checkadmin;	
		}
	
	}

	@Override
	public List<ApplyInsurance> viewMyInsurance(String email_id) {
		Query q=em.createQuery("select m from ApplyInsurance as m where m.farmer_email_id='"+email_id+"'");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<ApplyInsurance> ins_list=q.getResultList();
		System.out.println(ins_list);
		return ins_list;
		
	}
	
	
}
