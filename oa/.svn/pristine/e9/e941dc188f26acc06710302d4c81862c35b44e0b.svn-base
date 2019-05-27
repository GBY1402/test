package com.lh.it.resource.common.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.common.entity.BasicsDataInfo;

public interface BasicsDataInfoDAO extends PagingAndSortingRepository<BasicsDataInfo, Long>,
JpaSpecificationExecutor<BasicsDataInfo>{

	List<BasicsDataInfo> findByParent(BasicsDataInfo basicsDataInfo);

}
