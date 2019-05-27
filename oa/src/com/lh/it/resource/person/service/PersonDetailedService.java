package com.lh.it.resource.person.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import com.lh.it.resource.person.entity.PersonDetailedInfo;
import com.lh.it.resource.security.entity.main.User;

/**
 * 个人钱包明细逻辑控制层
 * @author Administrator
 *
 */
public interface PersonDetailedService {
	/**
	 * 获取钱包明细
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<PersonDetailedInfo> findPage(Specification<PersonDetailedInfo> spec, Pageable pageable);
	/**
	 * 添加钱包明细
	 * @param personDetailedInfo
	 * @param loginUser
	 */
	void inster(PersonDetailedInfo personDetailedInfo, User loginUser);
	/**
	 * 修改钱包明细
	 * @param personDetailedInfo
	 * @param loginUser
	 */
	void update(PersonDetailedInfo personDetailedInfo, User loginUser);
	/**
	 * 根据id查询信息
	 * @param detailedId
	 * @return
	 */
	PersonDetailedInfo findOne(String detailedId);
	/**
	 * 删除个人钱包明细
	 * @param detailedId
	 * @param loginUser
	 */
	void delete(String detailedId, User loginUser);
	/**
	 * 完成个人支付
	 * @param detailedId
	 * @param loginUser
	 */
	Map<String,Object> payment(String detailedId, User loginUser);


}
