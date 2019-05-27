package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.person.entity.PersonJobResumeInfo;

public interface PersonJobResumeInfoDAO extends PagingAndSortingRepository<PersonJobResumeInfo, String>,
JpaSpecificationExecutor<PersonJobResumeInfo>{

}
