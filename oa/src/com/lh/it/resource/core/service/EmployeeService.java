package com.lh.it.resource.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.lh.it.resource.core.entity.Employee;
import com.lh.it.resource.core.vo.EmployeeVo;

/**
 * 
 * @author zhoushuai@189.cn
 * 
 */
public interface EmployeeService {

	  /**
     * 保存用户
     * @param user
     */
    void saveEmployee(Employee user);
    
    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    Employee findEmployeeById(String id);
    
    /**
     * 更新用户
     * @param user
     */
    void updateEmployee(Employee employee);
    
    /**
     * 查找所有用户
     * @param id
     */
    Iterable<Employee> findAllEmployee();
    
    List<Employee> findEmployeeByQuery(EmployeeVo empl);
    
//    /**
//     * 分页检索
//     * @param pageable
//     * @return
//     */
//    Page<Employee> findPageList(Pageable pageable,Employee empl);
    
	/**
	 * 年假统计
	 */
	void annualLeave();

	Page<Employee> findPage(Specification<Employee> spec, Pageable pageable);
}
