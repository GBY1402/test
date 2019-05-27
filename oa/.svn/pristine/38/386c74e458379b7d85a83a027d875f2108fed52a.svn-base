package com.lh.it.resource.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.FunctionInfo;

public interface IndustryDAO extends PagingAndSortingRepository<FunctionInfo, Long>,
JpaSpecificationExecutor<FunctionInfo>{

	List<FunctionInfo> findByParent(FunctionInfo functionInfo);

	@Query(value = "select * from function_info where level = ?1", nativeQuery = true)
	List<FunctionInfo> findByLevel(Integer level);
	
}
