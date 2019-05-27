package com.lh.it.resource.person.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.WalletDAO;
import com.lh.it.resource.person.entity.WalletInfo;
import com.lh.it.resource.person.service.WalletService;
import com.lh.it.resource.security.entity.main.User;

@Service
public class WalletServiceImp implements WalletService{
	
	@Autowired
	private WalletDAO walletDAO;

	@Override
	public Page<WalletInfo> findPage(Specification<WalletInfo> spec, Pageable pageable) {
		return walletDAO.findAll(spec, pageable);
	}

	@Override
	public WalletInfo inster(WalletInfo walletInfo, User loginUser) {
		WalletInfo entity = walletDAO.findByHumanBasicInfo(walletInfo.getHumanBasicInfo().getHumanId());
		if(null != entity)
			return null;
		walletInfo.setWalletDelete(0);
		walletInfo.setCreateTime(new Date());
		walletInfo.setCreateUser(loginUser.getUsername());
		walletInfo.setUpdateTime(new Date());
		walletInfo.setUpdateUser(loginUser.getUsername());
		walletDAO.save(walletInfo);
		return walletInfo;
	}

	@Override
	public WalletInfo findOne(String walletId) {
		return walletDAO.findOne(walletId);
	}

	@Override
	public void update(WalletInfo walletInfo, User loginUser) {
		walletInfo.setUpdateTime(new Date());
		walletInfo.setUpdateUser(loginUser.getUsername());
		walletDAO.save(walletInfo);
	}

	@Override
	public void delete(String walletId, User loginUser) {
		WalletInfo walletInfo=walletDAO.findOne(walletId);
		walletInfo.setWalletDelete(1);
		walletInfo.setUpdateTime(new Date());
		walletInfo.setUpdateUser(loginUser.getUsername());
		walletDAO.save(walletInfo);
	}

}
