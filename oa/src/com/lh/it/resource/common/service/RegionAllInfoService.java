package com.lh.it.resource.common.service;

import java.util.List;

import com.lh.it.resource.common.entity.RegionAllInfo;

public interface RegionAllInfoService {

	List<RegionAllInfo> findAll();
	
	List<RegionAllInfo> findByParent(Long s);

	void save(RegionAllInfo regionAllInfo);
	
	void delete(Long id);
	
	RegionAllInfo findOne(Long id);
}

