package com.lh.it.resource.company.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.company.dao.HrDetailedInfoDAO;
import com.lh.it.resource.company.entity.HRDetailedInfo;
import com.lh.it.resource.company.service.HrDetailedService;
import com.lh.it.resource.person.entity.PersonDetailedInfo;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.utils.JiGuangPushUtil;
import com.lh.it.resource.utils.wechat.com.weichat.controller.WeiXinPayController;

@Service
public class HrDetailedServiceImpl implements HrDetailedService {

	@Autowired
	private HrDetailedInfoDAO hrDetailedInfoDao;

//	@Cacheable(value = "oaCache", key = "'hr_detailed_' + #pageable")
	@Override
	public Page<HRDetailedInfo> findPage(Specification<HRDetailedInfo> spec, Pageable pageable) {
		return hrDetailedInfoDao.findAll(spec, pageable);
	}

	@Override
	public HRDetailedInfo save(HRDetailedInfo hrDetailedInfo, User loginUser) {
		hrDetailedInfo.setCreateUser(loginUser.getUsername());
		hrDetailedInfo.setCreateTime(new Date());
		hrDetailedInfo.setUpdateUser(loginUser.getUsername());
		hrDetailedInfo.setUpdateTime(new Date());
		return hrDetailedInfoDao.save(hrDetailedInfo);
	}

	@Override
	public HRDetailedInfo update(HRDetailedInfo hrDetailedInfo, User loginUser) {
		hrDetailedInfo.setUpdateUser(loginUser.getUsername());
		hrDetailedInfo.setUpdateTime(new Date());
		return hrDetailedInfoDao.save(hrDetailedInfo);
	}

	@Override
	public HRDetailedInfo delete(String detailedId, User loginUser) {
		Optional<HRDetailedInfo> optional = Optional.ofNullable(findOne(detailedId));
		if(optional.isPresent()){
			HRDetailedInfo hrDetailedInfo = optional.get();
			hrDetailedInfo.setWalletDelete(1);
			return update(hrDetailedInfo, loginUser);
		}
		return null;
	}

	@Override
	public HRDetailedInfo findOne(String id) {
		return hrDetailedInfoDao.findOne(id);
	}

	@Override
	public Map<String, Object> payment(String detailedId, User loginUser) {
		HRDetailedInfo hrDetailedInfo = hrDetailedInfoDao.findOne(detailedId);
		if (hrDetailedInfo.getState() == 1 && hrDetailedInfo.getType() == 0 && hrDetailedInfo.getProgress() == 1) {
			hrDetailedInfo.setUpdateTime(new Date());
			hrDetailedInfo.setUpdateUser(loginUser.getUsername());
			hrDetailedInfo.setProgress(1);
			hrDetailedInfoDao.save(hrDetailedInfo);
			Map<String, Object> map = WeiXinPayController.payment(hrDetailedInfo);
			/*JiGuangPushUtil.pushNotice("alias", hrDetailedInfo.getEnterHRWalletInfo().getEnterPersonInfo().getHumanBasicInfo().getHumanId(), "结算成功请及时查询");
			JiGuangPushUtil.pushMsg("alias", hrDetailedInfo.getEnterHRWalletInfo().getEnterPersonInfo().getHumanBasicInfo().getHumanId(), "钱包结算成功");*/
			JiGuangPushUtil.sendMesg(hrDetailedInfo.getEnterHRWalletInfo().getEnterPersonInfo().getHumanBasicInfo().getHumanId(), "结算成功请及时查询", "1");
			return map;
		}
		return null;
	}
	
}
