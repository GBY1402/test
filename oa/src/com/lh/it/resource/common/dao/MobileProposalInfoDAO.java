package com.lh.it.resource.common.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.common.entity.MobileProposalInfo;

public interface MobileProposalInfoDAO extends PagingAndSortingRepository<MobileProposalInfo, String>,
		JpaSpecificationExecutor<MobileProposalInfo> {

}
