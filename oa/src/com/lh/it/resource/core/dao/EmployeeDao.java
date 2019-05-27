package com.lh.it.resource.core.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lh.it.resource.core.entity.Employee;
import com.lh.it.resource.core.vo.EmployeeVo;
import com.lh.it.resource.security.entity.main.Organization;

/**
 * 
 * @author zhoushuai@189.cn
 *
 */
public interface EmployeeDao extends PagingAndSortingRepository<Employee, String>,
		JpaSpecificationExecutor<Employee> {

	/**
	 * 员工信息分页检索
	 * @param empl
	 * @param pageable
	 * @return
	 */
	public Page<Employee> findByNameLike(Pageable pageable,EmployeeVo empl);
	
	public List<Employee> findEmployeeByQuery(EmployeeVo empl);
	
	public List<Employee> findAllByOrganization(Organization orga);
	
//	public Page<Employee> findPage(Pageable pageable,String emplName);
}
