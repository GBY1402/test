package com.lh.it.resource.company.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.company.dao.HrWalletInfoDAO;
import com.lh.it.resource.company.entity.EnterHRWalletInfo;
import com.lh.it.resource.company.service.HrWalletService;
import com.lh.it.resource.security.entity.main.User;

@Service
public class HrWalletServiceImpl implements HrWalletService {

	@Autowired
	private HrWalletInfoDAO hrWalletInfoDao;

	@Override
	public Page<EnterHRWalletInfo> findPage(Specification<EnterHRWalletInfo> spec, Pageable pageable) {
		return hrWalletInfoDao.findAll(spec, pageable);
	}

	@CacheEvict(value = "oaCache", key = "'hr_wallet_' + #enterHRWalletInfo.walletID")
	@Override
	public EnterHRWalletInfo save(EnterHRWalletInfo enterHRWalletInfo, User loginUser) {
		Optional<EnterHRWalletInfo> optional = Optional.ofNullable(hrWalletInfoDao.findByEnterPerId(enterHRWalletInfo.getEnterPersonInfo().getEnterPerId()));
		if(optional.isPresent()){
			return null;
		}
		enterHRWalletInfo.setWalletDelete(0);
		enterHRWalletInfo.setCreateTime(new Date());
		enterHRWalletInfo.setCreateUser(loginUser.getUsername());
		enterHRWalletInfo.setUpdateUser(loginUser.getUsername());
		enterHRWalletInfo.setUpdateTime(new Date());
		return hrWalletInfoDao.save(enterHRWalletInfo);
	}

	@Cacheable(value = "oaCache", key = "'hr_wallet_' + #walletId")
	@Override
	public EnterHRWalletInfo findOne(String walletId) {
		return hrWalletInfoDao.findOne(walletId);
	}

	@CacheEvict(value = "oaCache", key = "'hr_wallet_' + #enterHRWalletInfo.walletID")
	@Override
	public void update(EnterHRWalletInfo enterHRWalletInfo, User loginUser) {
		enterHRWalletInfo.setUpdateUser(loginUser.getUsername());
		enterHRWalletInfo.setUpdateTime(new Date());
		hrWalletInfoDao.save(enterHRWalletInfo);
	}

	@CacheEvict(value = "oaCache", key = "'hr_wallet_' + #walletId")
	@Override
	public void delete(String walletId, User loginUser) {
		Optional<EnterHRWalletInfo> hrOptional = Optional.ofNullable(findOne(walletId));
		if (hrOptional.isPresent()) {
			EnterHRWalletInfo enterHRWalletInfo = hrOptional.get();
			enterHRWalletInfo.setWalletDelete(1);
			enterHRWalletInfo.setUpdateTime(new Date());
			enterHRWalletInfo.setUpdateUser(loginUser.getUsername());
			hrWalletInfoDao.save(enterHRWalletInfo);
		}
	}

}
