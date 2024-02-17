package com.hexaware.CMS.dto;



import com.hexaware.CMS.entity.StationHead;


public class StationHeadDTO {
	
	private int id;
	private String name;
	private String email;
	

	public StationHeadDTO() {
		super();
	}

	public StationHeadDTO( String name, String email) {
		super();
		this.name = name;
	
	}
	public StationHeadDTO(StationHead stationHead) {
		super();
		this.id = stationHead.getId();
		this.name = stationHead.getName();
		this.email = stationHead.getEmail();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}


	
	