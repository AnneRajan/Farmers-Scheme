package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crop")
public class Crop {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cropid;
	private String cropname;
	
	
	
	private String croptype;
	private String fertilizertype;
	private String quantity;
	private int baseprice;
	private String soilphcertificate;
	private String farmer_email_id;
	
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
	public String getFertilizertype() {
		return fertilizertype;
	}
	public void setFertilizertype(String fertilizertype) {
		this.fertilizertype = fertilizertype;
	}
	public String getQuantity() {
		return quantity;
	}
	
	public int getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(int baseprice) {
		this.baseprice = baseprice;
	}
	
	public Crop(String cropname, String croptype, String fertilizertype, String quantity, int baseprice,
			String soilphcertificate, String farmer_email_id) {
		super();
		this.cropname = cropname;
		this.croptype = croptype;
		this.fertilizertype = fertilizertype;
		this.quantity = quantity;
		this.baseprice = baseprice;
		this.soilphcertificate = soilphcertificate;
		this.farmer_email_id = farmer_email_id;
	}
	@Override
	public String toString() {
		return "Crop [cropid=" + cropid + ", cropname=" + cropname + ", croptype=" + croptype + ", fertilizertype="
				+ fertilizertype + ", quantity=" + quantity + ", soilphcertificate=" + soilphcertificate
				+ ", farmer_email_id=" + farmer_email_id + "]";
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSoilphcertificate() {
		return soilphcertificate;
	}
	public void setSoilphcertificate(String soilphcertificate) {
		this.soilphcertificate = soilphcertificate;
	}
	public String getFarmer_email_id() {
		return farmer_email_id;
	}
	public void setFarmer_email_id(String farmer_email_id) {
		this.farmer_email_id = farmer_email_id;
	}
	
	
	public Crop() {
		
	}
}
