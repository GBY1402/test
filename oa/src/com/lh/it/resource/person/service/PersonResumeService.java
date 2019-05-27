package com.lh.it.resource.person.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobProjectInfo;
import com.lh.it.resource.person.entity.PersonJobResumeInfo;
import com.lh.it.resource.person.entity.PersonJobTrainInfo;
import com.lh.it.resource.security.entity.main.User;

public interface PersonResumeService {

	Page<PersonJobInfo> findPage(Specification<PersonJobInfo> spec, Pageable pageable);

	PersonJobInfo findById(String personJobId);

	void insterWorks(PersonJobResumeInfo personJobResumeInfo);

	void findByWork(String resumeId, User loginUser);

	PersonJobResumeInfo findPersonJobResumeInfoById(String resumeId);

	void insterProject(PersonJobProjectInfo personJobProjectInfo);

	PersonJobProjectInfo findPersonJobProjectInfoById(String projectId);

	void delete(String projectId, User loginUser);

	void insterTrainInfo(PersonJobTrainInfo personJobTrainInfo);

	PersonJobTrainInfo findPersonJobTrainInfoById(String trainId);

	void deleteTraining(String trainId, User loginUser);

	void insterPersonJobInfo(PersonJobInfo personJobInfo, User loginUser);
	
	void deletePersonJobResume(PersonJobResumeInfo personJobResumeInfo);

}
