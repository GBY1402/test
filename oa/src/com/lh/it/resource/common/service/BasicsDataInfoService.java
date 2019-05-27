package com.lh.it.resource.common.service;

import java.util.List;

import com.lh.it.resource.common.entity.BasicsDataInfo;

public interface BasicsDataInfoService {

	List<BasicsDataInfo> findByParent(Long s);

	List<BasicsDataInfo> findAll();
	
	List<BasicsDataInfo> findByBasicsDataInfo(BasicsDataInfo basicsDataInfo);
	
	void insert(BasicsDataInfo basicsDataInfo);
	
	BasicsDataInfo findOne(Long id);
	
	void delete(Long id);
}
