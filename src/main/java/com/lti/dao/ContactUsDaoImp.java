package com.lti.dao;

import java.util.List;

import com.lti.model.ContactUs;

public interface ContactUsDaoImp {
	
	ContactUs sendmessage(ContactUs cu);
	List<ContactUs> getallmessage();
}
