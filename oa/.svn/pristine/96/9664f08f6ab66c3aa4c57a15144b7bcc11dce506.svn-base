package com.lh.it.resource.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.PersonJobInfoDAO;
import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.service.PersonJobInfoService;

@Service
public class PersonJobInfoServiceImpl implements PersonJobInfoService {

	@Autowired
	private PersonJobInfoDAO personJobInfoDao;
	
	@Override
	public void save(PersonJobInfo personJobInfo) {
		personJobInfoDao.save(personJobInfo);
	}

	@Override
	public PersonJobInfo findByHumanBasicInfo(String humanId) {
		return personJobInfoDao.findByHumanBasicInfo(humanId);
	}

	@Override
	public PersonJobInfo findOne(String id) {
		return personJobInfoDao.findOne(id);
	}

	@Override
	public void delete(PersonJobInfo personJobInfo) {
		personJobInfo.setPersonDeleteStatus(1);
		// personJobInfoDao.delete(personJobInfo);
		personJobInfoDao.save(personJobInfo);
	}

}
