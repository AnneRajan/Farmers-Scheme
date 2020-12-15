package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.ApplyInsurance;
import com.lti.model.ClaimInsurance;

@Repository
public class ClaimInsuranceDao implements ClaimInsuranceImp {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public ClaimInsurance claimInsuranceCreation(ClaimInsurance claiminsurance) {
		ClaimInsurance c = em.merge(claiminsurance);
		return c;
	}
	
	@Override
	public List<ClaimInsurance> getClaimInsuranceList() {
		
		Query q=em.createQuery("select m from ClaimInsurance as m where m.admin_approval='false' ");
		
		//TypedQuery<FarmerRegisteration> q=em.createQuery("from FarmerRegisteration m where m.admin_approval like '%al%'",FarmerRegisteration.class);
		List<ClaimInsurance> claim_ins_list=q.getResultList();
		System.out.println(claim_ins_list);
		return claim_ins_list;
	}
	
	
	@Override
	public String updateClaimInsuranceList(int policy_no) {
		String checkadmin=null;
		try{
			Query sql =em.createQuery("select f from ClaimInsurance f where f.policy_no='"+policy_no+"'");
			ClaimInsurance ins = (ClaimInsurance)sql.getSingleResult();
			ClaimInsurance ui = em.find(ClaimInsurance.class,ins.getPolicy_no());
			if(ui!=null) {
				checkadmin=ui.setAdmin_approval("true");
			}
			
			return checkadmin;	
		}
		catch(NoResultException nre){
			return checkadmin;	
		}
	
	}
	
	
	public String checkPolicy(int policy_no) {
		String checkpolicy="false";
		try{
			Query sql =em.createQuery("select f from ApplyInsurance f where f.policy_no='"+policy_no+"' and f.admin_approval='true' ");
			ApplyInsurance ins = (ApplyInsurance)sql.getSingleResult();
			ApplyInsurance ci = em.find(ApplyInsurance.class,ins.getPolicy_no());
			if(ci!=null) {
				//checkadmin=ui.setAdmin_approval("true");
				checkpolicy="true";
			}
			
			return checkpolicy;	
		}
		catch(NoResultException nre){
			return checkpolicy;	
		}
		
	}
}
