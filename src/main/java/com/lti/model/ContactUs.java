package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int visitorid;
	
	private String visitorname;
	private String visitoremail;
	private String visitorsubject;
	private String visitormessage;
	public int getVisitorid() {
		return visitorid;
	}
	public void setVisitorid(int visitorid) {
		this.visitorid = visitorid;
	}
	public String getVisitorname() {
		return visitorname;
	}
	public void setVisitorname(String visitorname) {
		this.visitorname = visitorname;
	}
	public String getVisitoremail() {
		return visitoremail;
	}
	public void setVisitoremail(String visitoremail) {
		this.visitoremail = visitoremail;
	}
	public String getVisitorsubject() {
		return visitorsubject;
	}
	public void setVisitorsubject(String visitorsubject) {
		this.visitorsubject = visitorsubject;
	}
	public String getVisitormessage() {
		return visitormessage;
	}
	public void setVisitormessage(String visitormessage) {
		this.visitormessage = visitormessage;
	}
	public ContactUs(String visitorname, String visitoremail, String visitorsubject, String visitormessage) {
		super();
		this.visitorname = visitorname;
		this.visitoremail = visitoremail;
		this.visitorsubject = visitorsubject;
		this.visitormessage = visitormessage;
	}
	public ContactUs() {
	}
	@Override
	public String toString() {
		return "ContactUs [visitorid=" + visitorid + ", visitorname=" + visitorname + ", visitoremail=" + visitoremail
				+ ", visitorsubject=" + visitorsubject + ", visitormessage=" + visitormessage + "]";
	}
	
	
	
}
