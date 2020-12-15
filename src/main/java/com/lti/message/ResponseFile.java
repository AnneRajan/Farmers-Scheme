package com.lti.message;

public class ResponseFile {
	  private String name;
	  private String url;
	  private String type;
	  private long size;
	  private String email_id;
	  
	 
	  public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getUrl() {
	    return url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	public ResponseFile(String name, String url, String type, String email_id, long size) {
		super();
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
		this.email_id = email_id;
	}

	

	
	 

	}
