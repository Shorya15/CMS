package com.hexaware.CMS.service;

import java.util.List;


import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;

public interface UserService {
	User generateIncident(User user);
	User generateReportById(int query);
	Incident trackIncidentById(int incident_id);
	
	
}
