package com.lh.it.resource.common.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.UserAddInfoDAO;
import com.lh.it.resource.common.entity.UserAddInfo;
import com.lh.it.resource.common.service.UserAddInfoService;
import com.lh.it.resource.common.vo.UserAddInfoVO;
import com.lh.it.resource.core.util.DateUtils;
import com.lh.it.resource.person.entity.HumanBasicInfo;
import com.lh.it.resource.person.entity.WalletInfo;
import com.lh.it.resource.security.shiro.ShiroDbRealm;
import com.lh.it.resource.security.shiro.ShiroDbRealm.HashPassword;

@Service
public class UserAddInfoServiceImpl implements UserAddInfoService {

	@Autowired
	private UserAddInfoDAO userAddInfoDao;

	@Override
	public void save(UserAddInfoVO vo) {
		// 判断用户账号是否存在
		UserAddInfo userInfo = userAddInfoDao.findByUserName(vo.getUserName());
		if (vo.getUserType().intValue() == 0) {
			if (userInfo != null && userInfo.getUserPerson().intValue() == 1) {
				throw new RuntimeException("账号已存在");
			}
		} else {
			if (userInfo != null && userInfo.getUserCompany().intValue() == 1) {
				throw new RuntimeException("账号已存在");
			}
		}
		UserAddInfo userAddInfo = new UserAddInfo();
		// 判断存在账号修改属性
		if(vo.getUserType().intValue() == 0){
			if (userInfo == null) {
				userAddInfo.setUserPerson(1);
				userAddInfo.setCreateUser(vo.getUserName());
				userAddInfo.setCreateTime(DateUtils.now());
				userAddInfo.setUpdateUser(vo.getUserName());
				// 个人基础信息生成
				HumanBasicInfo humanBasicInfo = new HumanBasicInfo();
				humanBasicInfo.setHumanPhone(vo.getUserName());
				humanBasicInfo.setUserAddInfo(userAddInfo);
				humanBasicInfo.setCreateTime(DateUtils.now());
				humanBasicInfo.setCreateUser(vo.getUserName());
				humanBasicInfo.setUpdateTime(DateUtils.now());
				humanBasicInfo.setUpdateUser(vo.getUserName());
				// 个人钱包生成
				WalletInfo walletInfo = new WalletInfo();
				walletInfo.setState("0");
				walletInfo.setBinding("0");
				walletInfo.setCreateUser(vo.getUserName());
				walletInfo.setCreateTime(DateUtils.now());
				walletInfo.setUpdateUser(vo.getUserName());
				walletInfo.setUpdateTime(DateUtils.now());
				walletInfo.setHumanBasicInfo(humanBasicInfo);
				humanBasicInfo.setWalletInfo(walletInfo);
				userAddInfo.setHumanBasicInfo(humanBasicInfo);
			}else {
					userAddInfo.setUserId(userInfo.getUserId());
					userAddInfo.setUserPerson(1);
					userAddInfo.setUserState(userInfo.getUserState());
					userAddInfo.setUserCompany(userInfo.getUserCompany());
					userAddInfo.setCreateTime(userInfo.getCreateTime());
					userAddInfo.setCreateUser(userInfo.getCreateUser());
			}
		}else{
			if(userInfo == null) {
				userAddInfo.setUserCompany(1);
				userAddInfo.setCreateTime(DateUtils.now());
				userAddInfo.setCreateUser(vo.getUserName());
				//个人基础信息生成
				HumanBasicInfo humanBasicInfo = new HumanBasicInfo();
				humanBasicInfo.setHumanPhone(vo.getUserName());
				humanBasicInfo.setUserAddInfo(userAddInfo);
				humanBasicInfo.setCreateTime(DateUtils.now());
				humanBasicInfo.setCreateUser(vo.getUserName());
				humanBasicInfo.setUpdateTime(DateUtils.now());
				humanBasicInfo.setUpdateUser(vo.getUserName());
				//个人钱包生成
				WalletInfo walletInfo = new WalletInfo();
				walletInfo.setState("0");
				walletInfo.setBinding("0");
				walletInfo.setCreateUser(vo.getUserName());
				walletInfo.setCreateTime(DateUtils.now());
				walletInfo.setUpdateUser(vo.getUserName());
				walletInfo.setUpdateTime(DateUtils.now());
				walletInfo.setHumanBasicInfo(humanBasicInfo);
				humanBasicInfo.setWalletInfo(walletInfo);
				userAddInfo.setHumanBasicInfo(humanBasicInfo);
			}else {
				userAddInfo.setUserId(userInfo.getUserId());
				userAddInfo.setUserCompany(1);
				userAddInfo.setUserState(userInfo.getUserState());
				userAddInfo.setUserPerson(userInfo.getUserPerson());
				userAddInfo.setCreateTime(userInfo.getCreateTime());
				userAddInfo.setCreateUser(userInfo.getCreateUser());
			}
		}
		userAddInfo.setUserName(vo.getUserName());
		userAddInfo.setPlainPassword(vo.getPassword());
		if (StringUtils.isNotBlank(userAddInfo.getPlainPassword())) {
			HashPassword hashPassword = ShiroDbRealm.encryptPassword(userAddInfo.getPlainPassword());
			userAddInfo.setUserSalt(hashPassword.salt);
			userAddInfo.setUserPassword(hashPassword.password);
		}
		
		userAddInfo.setUpdateTime(DateUtils.now());
		userAddInfo.setUpdateUser(vo.getUserName());
		UserAddInfo u = userAddInfoDao.save(userAddInfo);
		if(u == null) {
			throw new RuntimeException("添加失败");
		}
	}

}
