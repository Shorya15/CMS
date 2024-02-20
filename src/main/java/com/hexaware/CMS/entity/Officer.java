package com.hexaware.CMS.entity;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hexaware.CMS.dto.OfficerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "officer")

public class Officer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="officer_id")
	private int id;

	private String name;

	@Column(name="badge_number",unique=true)
	private String badgeNumber;
	
	@Column(name="officer_rank")
	private String rank;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="officerList")
	private List<Incident> incidentList=new ArrayList<>();
	

	public Officer() {
		super();
	}


	public Officer(int id, String name, String badgeNumber, String rank, List<Incident> incidentList) {
		super();
		this.id = id;
		this.name = name;
		this.badgeNumber = badgeNumber;
		this.rank = rank;
		this.incidentList = incidentList;
	}

	public Officer( OfficerDTO officer) {
		super();
		this.name = officer.getName();
		this.badgeNumber = officer.getBadgeNumber();
		this.rank = officer.getRank();
		this.incidentList = officer.getIncidentList();
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


	public String getBadgeNumber() {
		return badgeNumber;
	}


	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public List<Incident> getIncidentList() {
		return incidentList;
	}


	public void setIncidentList(List<Incident> incidentList) {
		this.incidentList = incidentList;
	}

	    public boolean equals(Officer obj) {
	        if (this.id == obj.id) return true;
	        return false;
	        		
	    }

		@Override
		public String toString() {
			return "Officer [id=" + id + ", name=" + name + ", badgeNumber=" + badgeNumber + ", rank=" + rank
					+ ", incidentList="  /*+ incidentList*/ + "]";
		}
	    
	    
}