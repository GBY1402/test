package com.lh.it.resource.common.service.impl;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.lh.it.resource.common.dao.AccountNumberDAO;
import com.lh.it.resource.common.entity.UserAddInfo;
import com.lh.it.resource.common.service.AccountNumberService;
import com.lh.it.resource.security.shiro.ShiroDbRealm;
import com.lh.it.resource.security.shiro.ShiroDbRealm.HashPassword;
@Service
public class AccountNumberServiceImpl implements AccountNumberService{
	
	@Autowired
	private ShiroDbRealm shiroRealm;
	
	@Autowired
	private AccountNumberDAO accountNumberDao;

	@Override
	public Page<UserAddInfo> findPage(Specification<UserAddInfo> spec, Pageable pageable) {
		return accountNumberDao.findAll(spec,pageable);
	}

	@Override
	public UserAddInfo inster(UserAddInfo userAddInfo) {
		if (StringUtils.isNotBlank(userAddInfo.getPlainPassword()) && shiroRealm != null) {
			HashPassword hashPassword = ShiroDbRealm.encryptPassword(userAddInfo.getPlainPassword());
			userAddInfo.setUserSalt(hashPassword.salt);
			userAddInfo.setUserPassword(hashPassword.password);
		}
		userAddInfo.setCreateTime(new Date());
		userAddInfo.setCreateUser(userAddInfo.getUserName());
		userAddInfo.setUpdateTime(new Date());
		userAddInfo.setUpdateUser(userAddInfo.getUserName());
		return accountNumberDao.save(userAddInfo);
	}

	@Override
	public UserAddInfo findById(String userId) {
		return accountNumberDao.findOne(userId);
	}

	@Override
	public UserAddInfo update(UserAddInfo userAddInfo) {
		if (StringUtils.isNotBlank(userAddInfo.getPlainPassword()) && shiroRealm != null) {
			HashPassword hashPassword = ShiroDbRealm.encryptPassword(userAddInfo.getPlainPassword());
			userAddInfo.setUserSalt(hashPassword.salt);
			userAddInfo.setUserPassword(hashPassword.password);
		}
		userAddInfo.setUpdateTime(new Date());
		userAddInfo.setUpdateUser(userAddInfo.getUserName());
		return accountNumberDao.save(userAddInfo);
	}

	@Override
	public void delete(String userId) {
		accountNumberDao.delete(userId);
	}
}
