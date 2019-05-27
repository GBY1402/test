package com.lh.it.resource.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.security.entity.main.User;

public interface CompanyInfoService {

	Page<EnterBasicInfo> findPage(Specification<EnterBasicInfo> spec, Pageable pageable);

	EnterBasicInfo findById(String enterId);

	void inster(EnterBasicInfo enterBasicInfo);

	void delete(String enterId, User loginUser);
	
	void update(EnterBasicInfo enterBasicInfo, User loginUser);

}
