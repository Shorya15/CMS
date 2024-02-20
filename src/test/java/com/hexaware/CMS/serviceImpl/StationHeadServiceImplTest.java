package com.hexaware.CMS.serviceImpl;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.Officer;
import com.hexaware.CMS.entity.StationHead;
import com.hexaware.CMS.exception.NotExistException;

@SpringBootTest
public class StationHeadServiceImplTest {
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	private StationHeadServiceImpl stationHeadService;
	
	@Test
	public void  createStationHeadTest() {
		StationHead stationHead = new StationHead(2,"kunal" ,"kunal123@gmail.com");
		stationHead=stationHeadService.createStationHead(stationHead);
		LOGGER.log(Level.INFO, "saved stationHead " + stationHead);
	}
	
	@Test
	public void removeOfficer() {
		stationHeadService.removeOfficer(1);
}
	
	@Test
	public void  addOfficerTest() {
		List<Incident> incidentList=new ArrayList<>();
		Officer officer = new Officer(2,"kunal" ,"ak123" ,"IPS",incidentList);
		officer=stationHeadService.addOfficer(officer);
		LOGGER.log(Level.INFO, "saved Officer " + officer);
	}
	
	@Test
	public void	ChangeStatusFromCloseToVerifiedTest() {
		Optional<Incident> incident =stationHeadService.ChangeStatusFromCloseToVerified(2);
		LOGGER.log(Level.INFO, "change status " + incident.get());
	
		
	}
	@Test
	public void ViewAllIncidentsTest() {
		List<Incident> IncidentList= stationHeadService.ViewAllIncidents();
		
		for(Incident incident:IncidentList)
			LOGGER.log(Level.INFO, "View Incident " + incident);
		
		
	}
	@Test
	public void AssignOfficerToIncidentTest() throws NotExistException {
		Incident incident=stationHeadService.AssignOfficerToIncident(2, 2);
		LOGGER.log(Level.INFO, "Assign Officer " + incident);
	}
	
}