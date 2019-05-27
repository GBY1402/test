package com.lh.it.resource.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.MobileProposalInfo;

public interface MobileProposalInfoService {
	
	Page<MobileProposalInfo> findPage(Specification<MobileProposalInfo> spec, Pageable pageable);

	MobileProposalInfo findOne(String id);
	
	void delete(String id);
	
	void save(MobileProposalInfo mobileProposalInfo);
	
}
