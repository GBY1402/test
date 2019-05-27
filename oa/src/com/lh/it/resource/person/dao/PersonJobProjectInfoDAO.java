package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.person.entity.PersonJobProjectInfo;

public interface PersonJobProjectInfoDAO extends PagingAndSortingRepository<PersonJobProjectInfo, String>,
JpaSpecificationExecutor<PersonJobProjectInfo>{

}
