package com.lh.it.resource.company.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.company.dao.CompanyInfoDAO;
import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.company.service.CompanyInfoService;
import com.lh.it.resource.security.entity.main.User;
@Service
public class CompanyInfoServiceImpl implements CompanyInfoService{

	@Autowired
	private CompanyInfoDAO companyInfoDAO;
	
	@Override
	public Page<EnterBasicInfo> findPage(Specification<EnterBasicInfo> spec, Pageable pageable) {
		return companyInfoDAO.findAll(spec, pageable);
	}

	@Override
	@Cacheable(value="oaCache",key="'company_view_' + #enterId")
	public EnterBasicInfo findById(String enterId) {
		return companyInfoDAO.findOne(enterId);
	}

	@Override
	@CacheEvict(value = "oaCache", key = "'company_view_' + #enterBasicInfo.enterId")
	public void inster(EnterBasicInfo enterBasicInfo) {
		companyInfoDAO.save(enterBasicInfo);
	}

	@CacheEvict(value = "oaCache", key = "'company_view_' + #enterBasicInfo.enterId")
	@Override
	public void delete(String enterId, User loginUser) {
		EnterBasicInfo enterBasicInfo=companyInfoDAO.findOne(enterId);
		enterBasicInfo.setUpdateTime(new Date());
		enterBasicInfo.setEnterDelete(1);
		enterBasicInfo.setUpdateUser(loginUser.getUsername());
		companyInfoDAO.save(enterBasicInfo);
	}

	@Override
	public void update(EnterBasicInfo enterBasicInfo, User loginUser) {
		enterBasicInfo.setUpdateTime(new Date());
		enterBasicInfo.setUpdateUser(loginUser.getUsername());
		companyInfoDAO.save(enterBasicInfo);
	}

}
