package com.lh.it.resource.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.common.entity.UserAddInfo;

public interface AccountNumberService {

	Page<UserAddInfo> findPage(Specification<UserAddInfo> spec, Pageable pageable);

	UserAddInfo inster(UserAddInfo userAddInfo);

	UserAddInfo findById(String userId);

	UserAddInfo update(UserAddInfo userAddInfo);

	void delete(String userId);

}
