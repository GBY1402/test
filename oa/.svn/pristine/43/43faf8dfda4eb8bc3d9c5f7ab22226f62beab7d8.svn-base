package com.lh.it.resource.apk.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.apk.entity.ApkInfo;
import com.lh.it.resource.security.entity.main.User;

public interface ApkService {

	Page<ApkInfo> findAll(Specification<ApkInfo> spec, Pageable pageable);
	
	void inster(ApkInfo apkInfo, User loginUser);

	ApkInfo findOne(String id);
	
	void update(ApkInfo apkInfo);
	
	void delete(String id);
	
}
