package com.hexaware.CMS.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.OfficerService;


@RestController
@RequestMapping("api/v1/Officer/")
public class OfficerController {

		private OfficerService officerService;


		public OfficerController(OfficerService officerService) {
			super();
			this.officerService = officerService;
		}

		
		@GetMapping("ViewIncidentById")
		public Optional<IncidentDTO> ViewIncident(@RequestParam int incident_id)throws NotExistException {
			
			Optional<Incident> incidentOpt= officerService.viewIncident(incident_id);
			if(incidentOpt.isEmpty())
			{
				throw new NotExistException("Incident Not exist");
			}
			IncidentDTO incidentDto=new IncidentDTO(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		@GetMapping("DownloadIncidentById")
		public Optional<IncidentDTO> DownloadIncident(@RequestParam int incident_id) throws NotExistException {
			Optional<Incident> incidentOpt= officerService.downloadIncidentdetails(incident_id);
			if(incidentOpt.isEmpty())
			{
				throw new NotExistException("Incident Not exist");
			}
			IncidentDTO incidentDto=new IncidentDTO(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		@PutMapping("ClosedIncidentById")
		public Optional<IncidentDTO> ChangeStatus(@RequestParam int incident_id) throws NotExistException {
			Optional<Incident> incidentOpt=officerService.ChangeStatusToClosed(incident_id);
			if(incidentOpt.isEmpty())
			{
				throw new NotExistException("Incident Not exist");
			}
			IncidentDTO incidentDto=new IncidentDTO(incidentOpt.get());
			return Optional.ofNullable(incidentDto);
		}
		
		
}
