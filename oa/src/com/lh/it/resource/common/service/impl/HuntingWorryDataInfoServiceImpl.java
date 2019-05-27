package com.lh.it.resource.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.HuntingWorryDataInfoDAO;
import com.lh.it.resource.common.entity.HuntingWorryDataInfo;
import com.lh.it.resource.common.service.HuntingWorryDataInfoService;

@Service
public class HuntingWorryDataInfoServiceImpl implements HuntingWorryDataInfoService {

	@Autowired
	private HuntingWorryDataInfoDAO huntingWorryDataInfoDao;

	@Override
	public void save(HuntingWorryDataInfo huntingWorryDataInfo) {
		huntingWorryDataInfoDao.save(huntingWorryDataInfo);
	}

	@Override
	public Page<HuntingWorryDataInfo> findPage(Specification<HuntingWorryDataInfo> spec, Pageable pageable) {
		return huntingWorryDataInfoDao.findAll(spec, pageable);
	}

	@Override
	public HuntingWorryDataInfo findOne(String id) {
		return huntingWorryDataInfoDao.findOne(id);
	}

}
