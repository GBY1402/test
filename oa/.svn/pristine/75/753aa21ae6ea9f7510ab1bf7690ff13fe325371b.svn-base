package com.lh.it.resource.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.HuntingWorryDataInfo;

public interface HuntingWorryDataInfoService {

	void save(HuntingWorryDataInfo huntingWorryDataInfo);
	
	Page<HuntingWorryDataInfo> findPage(Specification<HuntingWorryDataInfo> spec, Pageable pageable);
	
	HuntingWorryDataInfo findOne(String id);
	
}
