package com.lh.it.resource.person.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.PersonDetailedDAO;
import com.lh.it.resource.person.entity.PersonDetailedInfo;
import com.lh.it.resource.person.service.PersonDetailedService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.dwz.AjaxObject;
import com.lh.it.resource.utils.JiGuangPushUtil;
import com.lh.it.resource.utils.wechat.com.weichat.controller.WeiXinPayController;

import cn.jpush.api.push.PushResult;

@Service
public class PersonDetailedServiceImpl implements PersonDetailedService {

	@Autowired
	private PersonDetailedDAO personDetailedDAO;

	@Override
	public Page<PersonDetailedInfo> findPage(Specification<PersonDetailedInfo> spec, Pageable pageable) {
		return personDetailedDAO.findAll(spec, pageable);
	}

	@Override
	public void inster(PersonDetailedInfo personDetailedInfo, User loginUser) {
		personDetailedInfo.setCreateTime(new Date());
		personDetailedInfo.setCreateUser(loginUser.getUsername());
		personDetailedInfo.setUpdateTime(new Date());
		personDetailedInfo.setUpdateUser(loginUser.getUsername());
		personDetailedInfo.setWalletDelete(0);
		personDetailedDAO.save(personDetailedInfo);

	}

	@Override
	public void update(PersonDetailedInfo personDetailedInfo, User loginUser) {
		personDetailedInfo.setUpdateTime(new Date());
		personDetailedInfo.setUpdateUser(loginUser.getUsername());
		personDetailedInfo.setWalletDelete(0);
		personDetailedDAO.save(personDetailedInfo);
	}

	@Override
	public PersonDetailedInfo findOne(String detailedId) {
		return personDetailedDAO.findOne(detailedId);
	}

	@Override
	public void delete(String detailedId, User loginUser) {
		PersonDetailedInfo personDetailedInfo = personDetailedDAO.findOne(detailedId);
		personDetailedInfo.setUpdateTime(new Date());
		personDetailedInfo.setUpdateUser(loginUser.getUsername());
		personDetailedInfo.setWalletDelete(1);
		personDetailedDAO.save(personDetailedInfo);
	}

	@Override
	public Map<String, Object> payment(String detailedId, User loginUser) {
		PersonDetailedInfo personDetailedInfo = personDetailedDAO.findOne(detailedId);
		if (personDetailedInfo.getState() == 1 && personDetailedInfo.getType() == 0 && personDetailedInfo.getProgress() == 1) {
			personDetailedInfo.setUpdateTime(new Date());
			personDetailedInfo.setUpdateUser(loginUser.getUsername());
			personDetailedInfo.setProgress(1);
			personDetailedDAO.save(personDetailedInfo);
			Map<String, Object> map = WeiXinPayController.payment(personDetailedInfo);
//			JiGuangPushUtil.pushNotice("alias", personDetailedInfo.getWalletInfo().getHumanBasicInfo().getHumanId(), "结算成功请及时查询");
			JiGuangPushUtil.sendMse(personDetailedInfo.getWalletInfo().getHumanBasicInfo().getHumanId(), "结算成功请及时查询", "1");
//			JiGuangPushUtil.pushMsg("alias", personDetailedInfo.getWalletInfo().getHumanBasicInfo().getHumanId(), "钱包结算成功");
			return map;
		}
		return null;

	}

}
