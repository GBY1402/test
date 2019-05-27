package com.lh.it.resource.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.company.entity.EnterPersonInfo;
import com.lh.it.resource.company.entity.JobWanfedInfo;
import com.lh.it.resource.company.entity.PersonAndbasicInfo;

/**
 * 招聘信息管理
 * @author Administrator
 *
 */
public interface RecruitInfoService {
	/**
	 * 招聘信息、急聘、猎聘信息
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<JobWanfedInfo> findPage( Specification<JobWanfedInfo> spec, Pageable pageable);
	
	Page<EnterPersonInfo> findPageHr(Specification<EnterPersonInfo> spec, Pageable pageable);
	
	void saveJobWanfedInfo(JobWanfedInfo jobWanfedInfo);
	
	EnterPersonInfo findEnterPersonInfo(String id);

	JobWanfedInfo findJobWanfedInfo(String id);
	
	String findEnterBasicInfo(String id);
	
}
