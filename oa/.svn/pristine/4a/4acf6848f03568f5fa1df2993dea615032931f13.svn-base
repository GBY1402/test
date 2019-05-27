package com.lh.it.resource.company.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.company.entity.EnterHRWalletInfo;

/**
 * HR基本信息DAO
 * @author Administrator
 *
 */
public interface HrWalletInfoDAO extends PagingAndSortingRepository<EnterHRWalletInfo, String>,
JpaSpecificationExecutor<EnterHRWalletInfo>{

	@Query(value = "SELECT * FROM enter_hrwallet_info WHERE enter_per_id = ?1", nativeQuery = true)
	EnterHRWalletInfo findByEnterPerId(String enterPerId);
	
}
