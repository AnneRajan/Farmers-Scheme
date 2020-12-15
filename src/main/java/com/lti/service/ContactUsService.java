package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ContactUsDaoClass;
import com.lti.model.ContactUs;

@Service
@Transactional
public class ContactUsService {
	@Autowired
	ContactUsDaoClass cud;
	
	public ContactUs sendmessage(ContactUs cu){
		return cud.sendmessage(cu);
	}
	
	public List<ContactUs> getallmessage(){
		return cud.getallmessage();
	}
}
