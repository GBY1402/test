package com.lh.it.resource.company.dao;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.company.entity.EnterPersonInfo;
/**
 * HR
 * @author Administrator
 *
 */
public interface EnterPersonInfoDAO extends PagingAndSortingRepository<EnterPersonInfo, String>,
JpaSpecificationExecutor<EnterPersonInfo>{

}
