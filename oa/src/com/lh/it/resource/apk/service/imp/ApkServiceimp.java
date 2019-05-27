package com.lh.it.resource.apk.service.imp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.apk.dao.ApkDAO;
import com.lh.it.resource.apk.entity.ApkInfo;
import com.lh.it.resource.apk.service.ApkService;
import com.lh.it.resource.security.entity.main.User;
@Service
public class ApkServiceimp implements ApkService{
	    
    @Autowired
	private ApkDAO apkDao;

	@Override
	public Page<ApkInfo> findAll(Specification<ApkInfo> spec, Pageable pageable) {
		return  apkDao.findAll(spec, pageable);
	}


	@Override
	public void inster(ApkInfo apkInfo, User loginUser) {
		apkInfo.setCreateName(loginUser.getUsername());
		apkInfo.setCreateTime(new Date());
		apkDao.save(apkInfo);
	}


	@Override
	public ApkInfo findOne(String id) {
		return apkDao.findOne(id);
	}


	@Override
	public void update(ApkInfo apkInfo) {
		apkDao.save(apkInfo);
	}


	@Override
	public void delete(String id) {
		apkDao.delete(id);
	}


}
