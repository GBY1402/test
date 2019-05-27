package com.lh.it.resource.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.RegionAllInfo;

public interface RegionAllInfoDAO
		extends PagingAndSortingRepository<RegionAllInfo, Long>, JpaSpecificationExecutor<RegionAllInfo> {

	@Query(value = "SELECT * FROM region WHERE level < ?1", nativeQuery = true)
	List<RegionAllInfo> list(int i);
	
	List<RegionAllInfo> findByParentId(RegionAllInfo regionAllInfo);
	
}
