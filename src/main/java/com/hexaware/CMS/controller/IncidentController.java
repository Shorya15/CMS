package com.hexaware.CMS.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.service.IncidentService;

@RestController
@RequestMapping("api/v1/incident/")

public class IncidentController {

		private IncidentService incidentService;

		public IncidentController(IncidentService incidentService) {
			super();
			this.incidentService = incidentService;
		}



		@PostMapping("generateIncident")
		public IncidentDTO createIncident(@RequestBody IncidentDTO incidentDto)  {
			Incident incident=new Incident(incidentDto);
			incidentDto=new IncidentDTO(incidentService.generateIncident(incident));
			return incidentDto;
		}
	}


