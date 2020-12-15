package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class FileInfo {
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
  private String id;

  private String name;

  private String type;
  
  private String email_id;
  
  private String getrole;
  
  public String getGetrole() {
	return getrole;
}

public void setGetrole(String getrole) {
	this.getrole = getrole;
}

public String getEmail_id() {
	return email_id;
}

public void setEmail_id(String email_id) {
	this.email_id = email_id;
}

public void setId(String id) {
	this.id = id;
}

@Lob
  private byte[] data;

  public FileInfo() {
  }

 



public FileInfo(String name, String type, String email_id, String getrole, byte[] data) {
	super();
	this.name = name;
	this.type = type;
	this.email_id = email_id;
	this.getrole = getrole;
	this.data = data;
}

public FileInfo(String name, String type, byte[] data) {
	super();
	this.name = name;
	this.type = type;
	this.data = data;
}

public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}