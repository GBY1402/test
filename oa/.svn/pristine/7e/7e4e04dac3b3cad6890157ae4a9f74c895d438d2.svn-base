package com.lh.it.resource.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.JobperCenterInfoDAO;
import com.lh.it.resource.person.entity.JobperCentreInfo;
import com.lh.it.resource.person.service.JobperCenterInfoService;

@Service
public class JobperCenterInfoServiceImpl implements JobperCenterInfoService {

	@Autowired
	private JobperCenterInfoDAO jobperCenterInfoDao;

	@Override
	public Page<JobperCentreInfo> findPage(Specification<JobperCentreInfo> spec, Pageable pageable) {
		return jobperCenterInfoDao.findAll(spec, pageable);
	}

	@Override
	public void save(JobperCentreInfo jobperCentreInfo) {
		jobperCenterInfoDao.save(jobperCentreInfo);
	}

	@Override
	public JobperCentreInfo findOne(String id) {
		return jobperCenterInfoDao.findOne(id);
	}
	
}
