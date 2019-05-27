package com.lh.it.resource.common.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.BoleGradeDataInfo;

public interface BoleGradeDataInfoDAO extends PagingAndSortingRepository<BoleGradeDataInfo, String>,
JpaSpecificationExecutor<BoleGradeDataInfo> {

}
