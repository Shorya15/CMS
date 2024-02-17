package com.hexaware.CMS.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;

@Service
public interface OfficerService {
	public Officer addOfficer(Officer officer);
	
	public Optional<Incident> viewIncident(int incident);
	
	public Optional<Incident> downloadIncidentdetails(int incident);
	public Optional<Incident> ChangeStatusToClosed(int incident);
}
