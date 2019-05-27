package com.lh.it.resource.common.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.security.util.dwz.Page;

public interface IndustrySkillsService {

	List<FunctionInfo> findAll();

	FunctionInfo findByParen(Long rootNodeId);

	List<FunctionInfo> findByParent(FunctionInfo industrySkillsInfo);

//	org.springframework.data.domain.Page<FunctionInfo> findPage(Long id, Specification<FunctionInfo> spec, Pageable pageable);

	FunctionInfo findById();

	List<FunctionInfo> find(Long parentModuleId, String keywords, Page page);

	List<FunctionInfo> find(Long parentModuleId, Page page);

	org.springframework.data.domain.Page<FunctionInfo> findPage(FunctionInfo industrySkillsInfo,  Pageable pageable);

	void inster(FunctionInfo functionInfo);

	List<FunctionInfo> findByid(Long i);
	
	FunctionInfo findOne(Long id);
	
	List<FunctionInfo> findAll(Integer level);

	List<FunctionInfo> findByParent(Long parentId);
	
}
