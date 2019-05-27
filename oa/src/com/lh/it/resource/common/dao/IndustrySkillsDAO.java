package com.lh.it.resource.common.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.FunctionInfo;

public interface IndustrySkillsDAO extends PagingAndSortingRepository<FunctionInfo, Long>,
JpaSpecificationExecutor<FunctionInfo>{

	List<FunctionInfo> findByParent(FunctionInfo industrySkillsInfo);

	Page<FunctionInfo> findByParentIdAndNameContaining(Long parentModuleId, String keywords, Pageable createPageable);

	Page<FunctionInfo> findByParentId(Long parentModuleId, Pageable createPageable);

	Page<FunctionInfo> findByParent(FunctionInfo industrySkillsInfo, Pageable pageable);

	@Query(value = "SELECT * FROM function_info WHERE level <= ?1", nativeQuery = true)
	List<FunctionInfo> findAll(Integer level);
	
	@Query(value = "SELECT * FROM function_info WHERE parent_id = ?1", nativeQuery = true)
	List<FunctionInfo> findByParent(Long id);
	
}
