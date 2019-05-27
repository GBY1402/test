package com.lh.it.resource.person.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobSkillInfo;

public interface PersonJobSkillInfoDAO extends PagingAndSortingRepository<PersonJobSkillInfo, String>,
JpaSpecificationExecutor<PersonJobSkillInfo>{

	List<PersonJobSkillInfo> findByPersonJobInfo(PersonJobInfo personJobInfo);

}
