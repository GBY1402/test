package com.lh.it.resource.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.company.entity.EnterHRWalletInfo;
import com.lh.it.resource.security.entity.main.User;

public interface HrWalletService {

	/**
	 * 获取HR钱包列表
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<EnterHRWalletInfo> findPage(Specification<EnterHRWalletInfo> spec, Pageable pageable);
	
	/**
	 * 存储HR钱包信息
	 * @param walletInfo
	 * @param loginUser
	 */
	EnterHRWalletInfo save(EnterHRWalletInfo enterHRWalletInfo, User loginUser);
	
	/**
	 * 根据id查询HR钱包信息
	 * @param walletId
	 * @return
	 */
	EnterHRWalletInfo findOne(String walletId);
	
	/**
	 * 修改HR钱包
	 * @param walletInfo
	 * @param loginUser
	 */
	void update(EnterHRWalletInfo walletInfo, User loginUser);
	
	/**
	 * 删除HR钱包
	 * @param walletId
	 * @param loginUser 
	 */
	void delete(String walletId, User loginUser);

	
}
