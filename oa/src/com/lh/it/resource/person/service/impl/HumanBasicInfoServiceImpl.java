package com.lh.it.resource.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.HumanBasicInfoDAO;
import com.lh.it.resource.person.entity.HumanBasicInfo;
import com.lh.it.resource.person.service.HumanBasicInfoService;
@Service
public class HumanBasicInfoServiceImpl implements HumanBasicInfoService{
	
	@Autowired
	private HumanBasicInfoDAO humanBasicInfoDAO;

	@Override
	public Page<HumanBasicInfo> findPage(Specification<HumanBasicInfo> spec, Pageable pageable) {
		return humanBasicInfoDAO.findAll(spec, pageable);
	}

	@Override
	public HumanBasicInfo findById(String humanId) {
		return humanBasicInfoDAO.findOne(humanId);
	}

	@Override
	public void inster(HumanBasicInfo humanBasicInfo) {
		humanBasicInfoDAO.save(humanBasicInfo);
	}

	@Override
	public void delete(String personJobId) {
		humanBasicInfoDAO.delete(personJobId);
	}

	@Override
	public Object findOne(String personJobId) {
		return humanBasicInfoDAO.findOne(personJobId);
	}

}
