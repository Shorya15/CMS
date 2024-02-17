package com.hexaware.CMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.CMS.entity.Officer;

public interface OfficerRepository extends JpaRepository<Officer,Integer> {

//	viewIncident(String query)
//	downloadIncident(String query)
//	generateReport(String query)
	@Query(value= "select officer_id from officer_incident_mapping where incident_id=:incident_id", nativeQuery=true)
	int IncidentOfficerMapping(int incident_id);
	
	@Query(value="select * from officer where officer_id=:officer_id",nativeQuery=true)
	Officer getOfficer(int officer_id);
}
