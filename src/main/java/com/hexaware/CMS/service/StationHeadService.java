package com.hexaware.CMS.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.exception.NotExistException;


public interface StationHeadService {
	public StationHead createStationHead(StationHead stationhead);
	List <Officer>removeOfficer(int officer_id);
	Officer addOfficer(Officer officer);
	Optional<Incident> ChangeStatusFromCloseToVerified(Integer incident_id);
	List<Incident> ViewAllIncidents();
	Incident AssignOfficerToIncident(Integer incident_id ,Integer officer_id) throws NotExistException;
	List<Officer>ViewAllOfficer();
	
}
