package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.ContactUs;

@Repository
public class ContactUsDaoClass implements ContactUsDaoImp {
	
	@PersistenceContext
	EntityManager em;
	
	public ContactUs sendmessage(ContactUs cu){
		ContactUs cous=em.merge(cu);
		return cous;
	}
	
	public List<ContactUs> getallmessage(){
		Query sql=em.createQuery("select c from ContactUs c");
		List<ContactUs> cous=sql.getResultList();
		return cous;
	}

}
