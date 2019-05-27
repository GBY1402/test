package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.person.entity.PersonJobInfo;

public interface PersonJobInfoDAO
		extends PagingAndSortingRepository<PersonJobInfo, String>, JpaSpecificationExecutor<PersonJobInfo> {

	@Query(value = "SELECT * FROM person_job_info WHERE human_id=?1", nativeQuery = true)
	PersonJobInfo findByHumanBasicInfo(String humanId);
	
}
