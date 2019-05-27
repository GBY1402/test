package com.lh.it.resource.person.service;

import java.util.List;

import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobSkillInfo;

public interface PersonJobSkillInfoService {

	void inster(PersonJobSkillInfo personJobSkillInfo);

	List<PersonJobSkillInfo> findBypersonJobSkillInfo(PersonJobInfo personJobInfo);

	void deleteList(List<PersonJobSkillInfo> listSkill);
	
	void save(PersonJobSkillInfo personJobSkillInfo);

	void delete(String id);
	
}
