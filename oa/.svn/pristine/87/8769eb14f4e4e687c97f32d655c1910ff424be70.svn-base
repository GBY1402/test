package com.lh.it.resource.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.BasicsDataInfoDAO;
import com.lh.it.resource.common.entity.BasicsDataInfo;
import com.lh.it.resource.common.service.BasicsDataInfoService;

@Service
public class BasicsDataInfoServiceImpl implements BasicsDataInfoService{
	
	@Autowired
	private BasicsDataInfoDAO basicsDataInfoDAO;

	@Override
	public List<BasicsDataInfo> findByParent(Long string) {
		BasicsDataInfo BasicsDataInfo=new BasicsDataInfo();
		BasicsDataInfo.setId(string);
		return (List<BasicsDataInfo>) basicsDataInfoDAO.findByParent(BasicsDataInfo);
	}

	@Override
	public List<BasicsDataInfo> findAll() {
		return (List<BasicsDataInfo>) basicsDataInfoDAO.findAll();
	}

	@Override
	public List<BasicsDataInfo> findByBasicsDataInfo(BasicsDataInfo basicsDataInfo) {
		return basicsDataInfoDAO.findByParent(basicsDataInfo);
	}

	@Override
	public void insert(BasicsDataInfo basicsDataInfo) {
		basicsDataInfoDAO.save(basicsDataInfo);
	}

	@Override
	public BasicsDataInfo findOne(Long id) {
		return basicsDataInfoDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		basicsDataInfoDAO.delete(id);
	}

}
