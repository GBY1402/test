package com.lh.it.resource.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.RegionAllInfoDAO;
import com.lh.it.resource.common.entity.RegionAllInfo;
import com.lh.it.resource.common.service.RegionAllInfoService;

@Service
public class RegionAllInfoServiceImpl implements RegionAllInfoService {
	
	@Autowired
	private RegionAllInfoDAO regionAllInfoDao;

	@Override
	public List<RegionAllInfo> findAll() {
		return (List<RegionAllInfo>) regionAllInfoDao.list(4);
	}

	@Override
	public List<RegionAllInfo> findByParent(Long s) {
		RegionAllInfo regionAllInfo = new RegionAllInfo();
		regionAllInfo.setRegionId(s);
		return (List<RegionAllInfo>) regionAllInfoDao.findByParentId(regionAllInfo);
	}

	@Override
	public void save(RegionAllInfo regionAllInfo){
		regionAllInfoDao.save(regionAllInfo);
	}
	
	@Override
	public void delete(Long id){
		regionAllInfoDao.delete(id);
	}

	@Override
	public RegionAllInfo findOne(Long id){
		return regionAllInfoDao.findOne(id);
	}
	
}
