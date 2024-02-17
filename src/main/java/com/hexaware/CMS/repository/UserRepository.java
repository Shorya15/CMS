package com.hexaware.CMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hexaware.CMS.entity.Incident;
import com.hexaware.CMS.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>  {
	//createIncident(String query)
	@Query(value="select fk_user_id from incident where incident_id=:incident_id",nativeQuery =true)
	int getUserId(int incident_id );
//
	@Query(value="select * from user where user_id=:user_id",nativeQuery =true)
	User getUser(int user_id);
//	
//	Incident generateReportAll(int user_id);
//	
//	@Query(value="select status from incident where incident_id=:incident_id",nativeQuery = true)
//	Incident trackIncidentById(int incident_id);
//	
//	@Query(value="select incident_id,incident_type,status from incident where incident_id IN "
//		+"(select * from user_incident_mapping where user_id=:user_id)",nativeQuery = true)
//	List<Incident> trackAllIncident(int user_id);
	
	
}
