package com.lh.it.resource.person.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.lh.it.resource.person.entity.PersonBoleInfo;
/**
 * 伯乐信息数据控制层
 * @author Administrator
 *
 */
public interface BoleInfoDAO extends PagingAndSortingRepository<PersonBoleInfo, String>,
JpaSpecificationExecutor<PersonBoleInfo>{

}
