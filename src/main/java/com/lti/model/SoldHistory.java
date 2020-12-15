package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="soldhistory")
public class SoldHistory {
	@Id
	private int soldid;
	private String solddate;
	private String cropname;
	private String quantity;
	private int msp;
	private int soldprice;
	private int totalprice;
	public int getSoldid() {
		return soldid;
	}
	public void setSoldid(int soldid) {
		this.soldid = soldid;
	}
	public String getSolddate() {
		return solddate;
	}
	public void setSolddate(String solddate) {
		this.solddate = solddate;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getMsp() {
		return msp;
	}
	public void setMsp(int msp) {
		this.msp = msp;
	}
	public int getSoldprice() {
		return soldprice;
	}
	public void setSoldprice(int soldprice) {
		this.soldprice = soldprice;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public SoldHistory(String solddate, String cropname, String quantity, int msp, int soldprice, int totalprice) {
		super();
		this.solddate = solddate;
		this.cropname = cropname;
		this.quantity = quantity;
		this.msp = msp;
		this.soldprice = soldprice;
		this.totalprice = totalprice;
	}
	
	public SoldHistory(){
		
	}
}
