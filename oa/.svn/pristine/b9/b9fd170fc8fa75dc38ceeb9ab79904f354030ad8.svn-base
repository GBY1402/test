package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.person.entity.WalletInfo;

/**
 * 个人钱包数据控制层
 * @author Administrator
 *
 */
public interface WalletDAO  extends PagingAndSortingRepository<WalletInfo, String>,
JpaSpecificationExecutor<WalletInfo>{

	@Query(value = "SELECT * FROM wallet_info WHERE human_id = ?1", nativeQuery = true)
	WalletInfo findByHumanBasicInfo(String userId);
	
}
