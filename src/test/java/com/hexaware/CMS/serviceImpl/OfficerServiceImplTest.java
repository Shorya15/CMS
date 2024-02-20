package com.hexaware.CMS.serviceImpl;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.service.OfficerService;
@SpringBootTest
public class OfficerServiceImplTest {
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private OfficerServiceImpl officerservice;
	

	@Test
	public void viewIncidentTest() {
		Optional<Incident> incident=officerservice.viewIncident(1);
		LOGGER.log(Level.INFO, "saved user " + incident.orElse(null));
	}
	
	@Test
	public void downloadIncidentdetailsTest() {
		Optional<Incident> incident=officerservice.downloadIncidentdetails(2);
		LOGGER.log(Level.INFO, "saved user " + incident.orElse(null));
		
	
	}
	
	@Test
	public void ChangeStatusToClosedTest() {
		Optional<Incident> incident=officerservice.ChangeStatusToClosed(1);
		LOGGER.log(Level.INFO, "saved user " + incident.orElse(null));
		
		
	}
	
	

}
