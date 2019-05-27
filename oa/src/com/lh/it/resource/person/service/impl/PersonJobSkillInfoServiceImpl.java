package com.lh.it.resource.person.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lh.it.resource.person.dao.PersonJobSkillInfoDAO;
import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobSkillInfo;
import com.lh.it.resource.person.service.PersonJobSkillInfoService;
@Service
public class PersonJobSkillInfoServiceImpl implements PersonJobSkillInfoService{

	@Autowired
	private PersonJobSkillInfoDAO personJobSkillInfoDAO;

	@Override
	public void inster(PersonJobSkillInfo personJobSkillInfo) {
		personJobSkillInfoDAO.save(personJobSkillInfo);
	}

	@Override
	public List<PersonJobSkillInfo> findBypersonJobSkillInfo(PersonJobInfo personJobInfo) {
		return personJobSkillInfoDAO.findByPersonJobInfo(personJobInfo);
	}

	@Override
	public void deleteList(List<PersonJobSkillInfo> listSkill) {
		personJobSkillInfoDAO.delete(listSkill);
	}

	@Override
	public void save(PersonJobSkillInfo personJobSkillInfo) {
		personJobSkillInfoDAO.save(personJobSkillInfo);
	}

	@Override
	public void delete(String id) {
		personJobSkillInfoDAO.delete(id);
	}

}
