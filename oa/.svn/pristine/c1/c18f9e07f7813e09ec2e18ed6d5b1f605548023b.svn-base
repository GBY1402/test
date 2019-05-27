package com.lh.it.resource.person.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.person.entity.JobperCentreInfo;

public interface JobperCenterInfoService {

	Page<JobperCentreInfo> findPage(Specification<JobperCentreInfo> spec, Pageable pageable);
	
	JobperCentreInfo findOne(String id);
	
	void save(JobperCentreInfo jobperCentreInfo);
	
}
