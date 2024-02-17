package com.hexaware.CMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.CMS.dto.IncidentDTO;
import com.hexaware.CMS.dto.UserDTO;
import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;
import com.hexaware.CMS.exception.AlreadyExistException;
import com.hexaware.CMS.service.UserService;

@RestController
@RequestMapping("api/v1/User/")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("CreateUser")
	public ResponseEntity<User>CreateUser(@RequestBody User user) throws AlreadyExistException{
		try {
		return new ResponseEntity<>(userService.generateIncident(user),HttpStatus.OK);
	}
		catch(Exception e)
		{
			throw new AlreadyExistException("User Already Exists");
		}
	}

	@GetMapping("GenerateReport")
	public UserDTO GetReport(@RequestParam int inc_id) {
		UserDTO userDto=new UserDTO(userService.generateReportById(inc_id));
	return userDto;
	}

	@GetMapping("TrackProgress")
	public IncidentDTO GetStatus(@RequestParam int inc_id) {
		IncidentDTO incidentDto= new IncidentDTO(userService.trackIncidentById(inc_id));
	return incidentDto;
	}

}
