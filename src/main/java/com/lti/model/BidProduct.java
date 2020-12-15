package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bidproduct")
public class BidProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bidproductid;
	private String cropname;
	private String croptype;
	private int baseprice;
	private String quantity;
	private int bidamount;
	private String bidder_email_id;
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getCroptype() {
		return croptype;
	}
	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}
	public int getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getBidamount() {
		return bidamount;
	}
	public void setBidamount(int bidamount) {
		this.bidamount = bidamount;
	}
	public String getBidder_email_id() {
		return bidder_email_id;
	}
	public void setBidder_email_id(String bidder_email_id) {
		this.bidder_email_id = bidder_email_id;
	}
	public BidProduct(String cropname, String croptype, int baseprice, String quantity, int bidamount,
			String bidder_email_id) {
		super();
		this.cropname = cropname;
		this.croptype = croptype;
		this.baseprice = baseprice;
		this.quantity = quantity;
		this.bidamount = bidamount;
		this.bidder_email_id = bidder_email_id;
	}
	@Override
	public String toString() {
		return "BidProduct [bidproductid=" + bidproductid + ", cropname=" + cropname + ", croptype=" + croptype
				+ ", baseprice=" + baseprice + ", quantity=" + quantity + ", bidamount=" + bidamount
				+ ", bidder_email_id=" + bidder_email_id + "]";
	}
	
	public BidProduct(){
		
	}
}
