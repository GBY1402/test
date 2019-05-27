package com.lh.it.resource.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.company.entity.CompanyAgreemenInfo;

public interface CompanyAgreemenInfoService {
	
	void save(CompanyAgreemenInfo companyAgreemenInfo);
	
	Page<CompanyAgreemenInfo> findPage(Specification<CompanyAgreemenInfo> spec, Pageable pageable);

	CompanyAgreemenInfo findOne(String id);
	
}
