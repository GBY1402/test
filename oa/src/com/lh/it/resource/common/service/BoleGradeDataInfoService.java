package com.lh.it.resource.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.BoleGradeDataInfo;

public interface BoleGradeDataInfoService {

	Page<BoleGradeDataInfo> findPage(Specification<BoleGradeDataInfo> spec, Pageable pageable);
	
	void save(BoleGradeDataInfo boleGradeDataInfo);
	
	void delete(String id);
	
	BoleGradeDataInfo findOne(String id);
	
}
