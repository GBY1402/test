package com.lh.it.resource.person.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.multipart.MultipartFile;

import com.lh.it.resource.person.entity.PersonBoleInfo;
import com.lh.it.resource.security.entity.main.User;

/**
 * 伯乐信息逻辑控制层
 * @author Administrator
 *
 */
public interface BoleInfoService {
	/**
	 * 获取伯乐信息列表
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<PersonBoleInfo> findPage(Specification<PersonBoleInfo> spec, Pageable pageable);
	/**
	 * 保存伯乐信息
	 * @param image
	 * @param loginUser
	 * @param personBoleInfo
	 */
	void inseter(MultipartFile image, User loginUser, PersonBoleInfo personBoleInfo);
	/**
	 * 查找单个伯乐信息
	 * @param boleId
	 * @return
	 */
	PersonBoleInfo findOne(String boleId);

}
