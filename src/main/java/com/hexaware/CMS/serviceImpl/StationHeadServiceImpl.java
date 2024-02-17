package com.hexaware.CMS.serviceImpl;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.exception.ResourceNotFoundException;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.repository.OfficerRepository;
import com.hexaware.CMS.repository.StationHeadRepository;
import com.hexaware.CMS.service.StationHeadService;


@Service
public class StationHeadServiceImpl implements StationHeadService{

	private StationHeadRepository stationHeadRepository;
	private OfficerRepository officerRepository;
	private IncidentRepository incidentRepository;
	
	
	public StationHeadServiceImpl(StationHeadRepository stationHeadRepository, OfficerRepository officerRepository,IncidentRepository incidentRepository) {
		super();
		this.stationHeadRepository = stationHeadRepository;
		this.officerRepository=officerRepository;
		this.incidentRepository=incidentRepository;
	}


	@Override
	public StationHead createStationHead(StationHead stationhead) {
		
		return stationHeadRepository.save(stationhead);
	}


	@Override
	public List<Officer> removeOfficer(int officer_id) {
		officerRepository.deleteById(officer_id);
		List<Officer> officerList=officerRepository.findAll();
		return officerList;
	}


	@Override
	public Officer addOfficer(Officer officer) {
		
		return officerRepository.save(officer);
	}


	@Override
	public Optional<Incident> ChangeStatusFromCloseToVerified(Integer incident_id) {
		Optional<Incident> incidentOpt=incidentRepository.findById(incident_id);
		if(incidentOpt.isPresent()) {
		incidentOpt.get().setStatus("Verified");
		incidentRepository.save(incidentOpt.get());
	}		
		return incidentOpt;
	}

	@Override
	public List<Incident> ViewAllIncidents() {
		return incidentRepository.findAll();
	}


	@Override
	public Incident AssignOfficerToIncident(Integer  incident_id,Integer officer_id) throws NotExistException {
		Optional<Incident> incidentCheck =incidentRepository.findById(incident_id);
		Optional<Officer> officerCheck =officerRepository.findById(officer_id);
		if(incidentCheck.isPresent()&& officerCheck.isPresent())
		{	incidentCheck.get().setStatus("Active");
			Set<Officer> OfficerSet=incidentCheck.get().getOfficerList();
			OfficerSet.add(officerCheck.get());
			incidentCheck.get().setOfficerList(OfficerSet);
			incidentRepository.save(incidentCheck.get());
		}
		else
		{
			throw new NotExistException("resource not found");
		}
		return incidentCheck.get();
	}


	@Override
	public List<Officer> ViewAllOfficer() {
		List<Officer> OfficerList = officerRepository.findAll();
        return OfficerList;
	
	}

}
