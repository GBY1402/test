package com.lh.it.resource.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.BoleGradeDataInfoDAO;
import com.lh.it.resource.common.entity.BoleGradeDataInfo;
import com.lh.it.resource.common.service.BoleGradeDataInfoService;

@Service
public class BoleGradeDataServiceImpl implements BoleGradeDataInfoService {

	@Autowired
	private BoleGradeDataInfoDAO boleGradeDataInfoDao;

	@Override
	public Page<BoleGradeDataInfo> findPage(Specification<BoleGradeDataInfo> spec, Pageable pageable) {
		return boleGradeDataInfoDao.findAll(spec, pageable);
	}

	@Override
	public void save(BoleGradeDataInfo boleGradeDataInfo) {
		boleGradeDataInfoDao.save(boleGradeDataInfo);
	}

	@Override
	public void delete(String id) {
		BoleGradeDataInfo boleGradeDataInfo = boleGradeDataInfoDao.findOne(id);
		boleGradeDataInfo.setDeleteData(1);
		boleGradeDataInfoDao.save(boleGradeDataInfo);
	}

	@Override
	public BoleGradeDataInfo findOne(String id) {
		return boleGradeDataInfoDao.findOne(id);
	}
	
}
