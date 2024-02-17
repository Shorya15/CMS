package com.hexaware.CMS.serviceImpl;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.service.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService {

	private IncidentRepository incidentRepository;

	public IncidentServiceImpl(IncidentRepository incidentRepository) {
		super();
		this.incidentRepository = incidentRepository;
	}

	@Override
	public Incident generateIncident(Incident incident) {
		return incidentRepository.save(incident);
	}
	

}
