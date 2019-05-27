package com.lh.it.resource.person.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.person.dao.PersonJobProjectInfoDAO;
import com.lh.it.resource.person.dao.PersonJobResumeInfoDAO;
import com.lh.it.resource.person.dao.PersonJobTrainInfoDAO;
import com.lh.it.resource.person.dao.PersonResumeDAO;
import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobProjectInfo;
import com.lh.it.resource.person.entity.PersonJobResumeInfo;
import com.lh.it.resource.person.entity.PersonJobTrainInfo;
import com.lh.it.resource.person.service.PersonResumeService;
import com.lh.it.resource.security.entity.main.User;
@Service
public class PersonResumeServiceImpl implements PersonResumeService{

	@Autowired
	private PersonResumeDAO personResumeDAO;

	@Autowired
	private PersonJobResumeInfoDAO personJobResumeInfoDAO;
	
	@Autowired
	private PersonJobProjectInfoDAO personJobProjectInfoDAO;
	
	@Autowired
	private PersonJobTrainInfoDAO personJobTrainInfoDAO;
	
	@Override
	public Page<PersonJobInfo> findPage(Specification<PersonJobInfo> spec, Pageable pageable) {
		return personResumeDAO.findAll(spec, pageable);
	}

	@Override
	public PersonJobInfo findById(String personJobId) {
		return personResumeDAO.findOne(personJobId);
	}

	@Override
	public void insterWorks(PersonJobResumeInfo personJobResumeInfo) {
		personJobResumeInfoDAO.save(personJobResumeInfo);
	}

	@Override
	public void findByWork(String resumeId, User loginUser) {
		PersonJobResumeInfo personJobResumeInfo=personJobResumeInfoDAO.findOne(resumeId);
		personJobResumeInfo.setUpdateTime(new Date());
		personJobResumeInfo.setUpdateUser(loginUser.getUsername());
		personJobResumeInfo.setDeleteBasic(1);		
		personJobResumeInfoDAO.save(personJobResumeInfo);
	}

	@Override
	public PersonJobResumeInfo findPersonJobResumeInfoById(String resumeId) {
		return personJobResumeInfoDAO.findOne(resumeId);
	}

	@Override
	public void insterProject(PersonJobProjectInfo personJobProjectInfo) {
		personJobProjectInfoDAO.save(personJobProjectInfo);
		
	}

	@Override
	public PersonJobProjectInfo findPersonJobProjectInfoById(String projectId) {
		return personJobProjectInfoDAO.findOne(projectId);
	}

	@Override
	public void delete(String projectId, User loginUser) {
		/*PersonJobProjectInfo personJobProjectInfo=personJobProjectInfoDAO.findOne(projectId);
		personJobProjectInfo.setUpdateTime(new Date());
		personJobProjectInfo.setUpdateUser(loginUser.getUsername());
		personJobProjectInfo.setProjectDelete(1);
		personJobProjectInfoDAO.save(personJobProjectInfo);*/
		personJobProjectInfoDAO.delete(projectId);
	}

	@Override
	public void insterTrainInfo(PersonJobTrainInfo personJobTrainInfo) {
		personJobTrainInfoDAO.save(personJobTrainInfo);
		
	}

	@Override
	public PersonJobTrainInfo findPersonJobTrainInfoById(String trainId) {
		return personJobTrainInfoDAO.findOne(trainId);
	}

	@Override
	public void deleteTraining(String trainId, User loginUser) {
		/*PersonJobTrainInfo personJobTrainInfo=personJobTrainInfoDAO.findOne(trainId);
		personJobTrainInfo.setUpdateTime(new Date());
		personJobTrainInfo.setUpdateUser(loginUser.getUsername());
		personJobTrainInfo.setTrainDelete(1);
		personJobTrainInfoDAO.save(personJobTrainInfo);*/
		personJobTrainInfoDAO.delete(trainId);
	}

	@Override
	public void insterPersonJobInfo(PersonJobInfo personJobInfo, User loginUser) {
		personJobInfo.setUpdateTime(new Date());
		personJobInfo.setUpdateUser(loginUser.getUsername());
		personResumeDAO.save(personJobInfo);
	}

	@Override
	public void deletePersonJobResume(PersonJobResumeInfo personJobResumeInfo) {
		personJobResumeInfoDAO.delete(personJobResumeInfo);
	}
}
