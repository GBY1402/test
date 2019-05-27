package com.lh.it.resource.person.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.person.entity.WalletInfo;
import com.lh.it.resource.security.entity.main.User;
/**
 * 个人钱包逻辑控制层
 * @author Administrator
 *
 */
public interface WalletService {
	/**
	 * 获取个人钱包列表
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<WalletInfo> findPage(Specification<WalletInfo> spec, Pageable pageable);
	/**
	 * 后台添加钱包
	 * @param walletInfo
	 * @param loginUser
	 */
	WalletInfo inster(WalletInfo walletInfo, User loginUser);
	/**
	 * 根据id查询个人钱包信息
	 * @param walletId
	 * @return
	 */
	WalletInfo findOne(String walletId);
	/**
	 * 修改给人钱包
	 * @param walletInfo
	 * @param loginUser
	 */
	void update(WalletInfo walletInfo, User loginUser);
	/**
	 * 删除个人钱包
	 * @param walletId
	 * @param loginUser 
	 */
	void delete(String walletId, User loginUser);

}
