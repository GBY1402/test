package com.lh.it.resource.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.MobileProposalInfoDAO;
import com.lh.it.resource.common.entity.MobileProposalInfo;
import com.lh.it.resource.common.service.MobileProposalInfoService;

@Service
public class MobileProposalInfoServiceImpl implements MobileProposalInfoService {

	@Autowired
	private MobileProposalInfoDAO mobileProposalInfoDao;

	@Override
	public Page<MobileProposalInfo> findPage(Specification<MobileProposalInfo> spec, Pageable pageable) {
		return mobileProposalInfoDao.findAll(spec, pageable);
	}

	@Override
	public MobileProposalInfo findOne(String id) {
		return mobileProposalInfoDao.findOne(id);
	}

	@Override
	public void delete(String id) {
		mobileProposalInfoDao.delete(findOne(id));
	}

	@Override
	public void save(MobileProposalInfo mobileProposalInfo) {
		mobileProposalInfoDao.save(mobileProposalInfo);
	}

}
