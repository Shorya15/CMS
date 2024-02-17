package com.hexaware.CMS.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;

public interface IncidentRepository extends JpaRepository<Incident,Integer> {

	Incident findByid(int id);
		
	

}
