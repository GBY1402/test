package com.lh.it.resource.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;

public interface SkillsDAO extends PagingAndSortingRepository<SkillsInfo, String>,
JpaSpecificationExecutor<SkillsInfo>{

	List<SkillsInfo> findByFunctionInfo(FunctionInfo functionInfo);
	
}
