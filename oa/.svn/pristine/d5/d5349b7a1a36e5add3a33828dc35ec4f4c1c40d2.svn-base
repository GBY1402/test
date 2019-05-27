package com.lh.it.resource.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.company.dao.CompanyAgreemenInfoDAO;
import com.lh.it.resource.company.entity.CompanyAgreemenInfo;
import com.lh.it.resource.company.service.CompanyAgreemenInfoService;

@Service
public class CompanyAgreemenInfoServiceImpl implements CompanyAgreemenInfoService {
	
	@Autowired
	private CompanyAgreemenInfoDAO companyAgreemenInfoDao;

	@CacheEvict(value = "oaCache", key = "'agreement_view_' + #companyAgreemenInfo.agreementId")
	@Override
	public void save(CompanyAgreemenInfo companyAgreemenInfo) {
		companyAgreemenInfoDao.save(companyAgreemenInfo);
	}

	@Override
	public Page<CompanyAgreemenInfo> findPage(Specification<CompanyAgreemenInfo> spec, Pageable pageable) {
		return companyAgreemenInfoDao.findAll(spec, pageable);
	}

	@Cacheable(value="oaCache",key="'agreement_view_' + #id")
	@Override
	public CompanyAgreemenInfo findOne(String id) {
		return companyAgreemenInfoDao.findOne(id);
	}

}
