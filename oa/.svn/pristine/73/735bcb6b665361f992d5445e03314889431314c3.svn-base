package com.lh.it.resource.company.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.company.entity.HRDetailedInfo;
import com.lh.it.resource.security.entity.main.User;


public interface HrDetailedService {

	Page<HRDetailedInfo> findPage(Specification<HRDetailedInfo> spec, Pageable pageable);
	
	HRDetailedInfo save(HRDetailedInfo hrDetailedInfo, User loginUser);
	
	HRDetailedInfo update(HRDetailedInfo hrDetailedInfo, User loginUser);
	
	HRDetailedInfo delete(String detailedId, User loginUser);
	
	HRDetailedInfo findOne(String id);
	
	/**
	 * 完成HR支付
	 * @param detailedId
	 * @param loginUser
	 */
	Map<String,Object> payment(String detailedId, User loginUser);
	
}
