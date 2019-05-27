package com.lh.it.resource.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.company.dao.EnterPersonInfoDAO;
import com.lh.it.resource.company.dao.PersonAndbasicInfoDAO;
import com.lh.it.resource.company.dao.RecruitInfoDAO;
import com.lh.it.resource.company.entity.EnterPersonInfo;
import com.lh.it.resource.company.entity.JobWanfedInfo;
import com.lh.it.resource.company.service.RecruitInfoService;

@Service
public class RecruitInfoServiceImpl implements RecruitInfoService{

	@Autowired
	private RecruitInfoDAO recruitInfoDAO;
	
	@Autowired
	private EnterPersonInfoDAO enterPersonInfoDao;
	
	@Autowired
	private PersonAndbasicInfoDAO personAndbasicInfoDao;

	@Override
	public Page<JobWanfedInfo> findPage( Specification<JobWanfedInfo> spec, Pageable pageable) {
		return recruitInfoDAO.findAll(spec, pageable);
	}

	@Override
	public Page<EnterPersonInfo> findPageHr(Specification<EnterPersonInfo> spec, Pageable pageable) {
		return enterPersonInfoDao.findAll(spec, pageable);
	}

	@CacheEvict(value = "oaCache", key = "'recruit_view_' + #jobWanfedInfo.jobWanfedId")
	@Override
	public void saveJobWanfedInfo(JobWanfedInfo jobWanfedInfo) {
		recruitInfoDAO.save(jobWanfedInfo);
	}

	@Override
	public EnterPersonInfo findEnterPersonInfo(String id) {
		return enterPersonInfoDao.findOne(id);
	}

	@Cacheable(value="oaCache",key="'recruit_view_' + #id")
	@Override
	public JobWanfedInfo findJobWanfedInfo(String id) {
		return recruitInfoDAO.findOne(id);
	}

	@Override
	public String findEnterBasicInfo(String id) {
		return recruitInfoDAO.findEnterBasicInfo(id);
	}
	
}
