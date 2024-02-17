package com.hexaware.CMS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.dto.OfficerDTO;
import com.hexaware.CMS.dto.StationHeadDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.exception.NotExistException;
import com.hexaware.CMS.service.StationHeadService;

@RestController
@RequestMapping("api/v1/Stationhead/")
public class StationHeadController {

	private StationHeadService stationHeadService;

	public StationHeadController(StationHeadService stationHeadService) {
		super();
		this.stationHeadService = stationHeadService;
	}

	@PostMapping("CreateStationhead")
	public ResponseEntity<StationHeadDTO> CreateStationHead(@RequestBody StationHeadDTO stationHeadDto) throws AlreadyExistException{
		StationHead stationHead=new StationHead(stationHeadDto);
		try {
			stationHeadDto=new	StationHeadDTO(stationHeadService.createStationHead(stationHead));
		return new ResponseEntity<>(stationHeadDto,HttpStatus.OK);
	}
		catch(Exception e)
		{
			throw new AlreadyExistException("Station head Already Exists");
		}
	}

	@DeleteMapping("DeleteOfficer")
	public List<Officer> RemoveOfficer(@RequestParam int officer_id) {

		return stationHeadService.removeOfficer(officer_id);
	}

	@PostMapping("RegisterOfficer")
	public ResponseEntity<OfficerDTO> AddOfficer(@RequestBody OfficerDTO officerDto)throws AlreadyExistException {
		try {
			Officer officer=new Officer(officerDto); 
			officerDto=new OfficerDTO(stationHeadService.addOfficer(officer));
			return new ResponseEntity<>(officerDto,HttpStatus.OK);
		}
			catch(Exception e)
			{
				throw new AlreadyExistException("Officer Already Exists");
			}
		
	}

	@PutMapping("ChangeStatus")
	public ResponseEntity<IncidentDTO> ChangeStatus(@RequestParam Integer incident_id) throws NotExistException {
		Optional<Incident>incidentOpt=stationHeadService.ChangeStatusFromCloseToVerified(incident_id);
				if(!(incidentOpt.isPresent()))
				throw new NotExistException("Incident Not Found");
				IncidentDTO incidentDto=new IncidentDTO(incidentOpt.get());
			return new ResponseEntity<>(incidentDto,HttpStatus.OK);
	}

	@GetMapping("ViewAllIncident")
	public List<Incident> ViewAllIncidents() {
		return stationHeadService.ViewAllIncidents();
	}

	@GetMapping("ViewAllOfficer")
	public List<Officer> ViewAllOfficer() {
		return stationHeadService.ViewAllOfficer();

	}
	
	@PostMapping("AssignOfficerToIncident/{incident_id}/officer/{officer_id}")
	public ResponseEntity<IncidentDTO> AssignOfficerToIncident(@PathVariable Integer incident_id,@PathVariable Integer officer_id) throws NotExistException {
		IncidentDTO incidentDto=new IncidentDTO(stationHeadService.AssignOfficerToIncident(incident_id,officer_id));
		return new ResponseEntity<>(incidentDto,HttpStatus.OK);
	}
}
