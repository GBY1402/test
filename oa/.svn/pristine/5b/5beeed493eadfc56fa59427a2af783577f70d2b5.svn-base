package com.lh.it.resource.person.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.person.entity.HumanBasicInfo;

public interface HumanBasicInfoService {

	Page<HumanBasicInfo> findPage(Specification<HumanBasicInfo> spec, Pageable pageable);

	HumanBasicInfo findById(String humanId);

	void inster(HumanBasicInfo humanBasicInfo);

	void delete(String personJobId);

	Object findOne(String personJobId);

}
