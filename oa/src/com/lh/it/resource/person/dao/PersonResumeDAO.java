package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.person.entity.PersonJobInfo;

public interface PersonResumeDAO extends PagingAndSortingRepository<PersonJobInfo, String>,
JpaSpecificationExecutor<PersonJobInfo>{

}
