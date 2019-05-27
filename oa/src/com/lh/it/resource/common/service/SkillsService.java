package com.lh.it.resource.common.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;

public interface SkillsService {

	List<SkillsInfo> findByIndustrySkillsInfo(FunctionInfo functionInfo);

	Page<SkillsInfo> finAll(Pageable pageable);
	
	SkillsInfo findOne(String id);

	void update(SkillsInfo skillsInfo);
	
	void delete(String id);
	
	Page<SkillsInfo> findPage(Specification<SkillsInfo> spec, Pageable pageable);
	
}
