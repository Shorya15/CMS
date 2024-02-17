package com.hexaware.CMS.serviceImpl;

import org.springframework.stereotype.Service;

import com.hexaware.CMS.dto.UserDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.repository.IncidentRepository;
import com.hexaware.CMS.repository.OfficerRepository;
import com.hexaware.CMS.repository.UserRepository;
import com.hexaware.CMS.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private IncidentRepository incidentRepostory; 
	private OfficerRepository officerRepository;
    
	
	
	public UserServiceImpl(UserRepository userRepository,IncidentRepository incidentRepostory,OfficerRepository officerRepository) {
		super();
		this.userRepository = userRepository;
		this.incidentRepostory=incidentRepostory;
		this.officerRepository=officerRepository;
	}

	@Override
	public User generateIncident(User user) {
		return this.userRepository.save(user);
	}
	
	@Override
	public User generateReportById(int incident_id) {
		int user_id=userRepository.getUserId(incident_id);
		User user=userRepository.getUser(user_id);
		return user;
	}


	@Override
	public Incident trackIncidentById(int incident_id) {
		
		return incidentRepostory.findByid(incident_id);
	}


	

	
	
}


	

	
	
	
	

