package com.lh.it.resource.company.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.company.entity.JobWanfedInfo;
/**
 * 招聘信息数据控制层
 * @author Administrator
 *
 */
public interface RecruitInfoDAO extends PagingAndSortingRepository<JobWanfedInfo, String>,
JpaSpecificationExecutor<JobWanfedInfo>{

	Page<JobWanfedInfo> findByJobWanfedId(String jobWanfedId, Specification<JobWanfedInfo> spec, Pageable pageable);

	@Query(value = "select enter_id from enter_basic_info where enter_id = (select enter_id from person_and_basic_info where enter_per_id = ?1)", nativeQuery = true)
	String findEnterBasicInfo(String id);
	
}
