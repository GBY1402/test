package com.lh.it.resource.core.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lh.it.resource.core.dao.EmployeeDao;
import com.lh.it.resource.core.entity.Employee;
import com.lh.it.resource.core.entity.StateType;
import com.lh.it.resource.core.service.EmployeeService;
import com.lh.it.resource.core.util.DateUtils;
import com.lh.it.resource.core.vo.EmployeeVo;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger LOG = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployee(Employee employee) {
		if (employee.getStateType().equals(StateType.OUTJOB)) {// 离职
			employee.setLenveDateTime(DateUtils.now());
		}
		/**
		 * 新增的员工 工号不能重复
		 */
		String jobNumber = employee.getJobnum();//获得新增员工工号
		//查询数据库中已存在的员工工号
		List<Employee> empList = (List<Employee>) employeeDao.findAll();
		for (Employee emp : empList) {
			if(emp.getJobnum().equals(jobNumber)){
				throw new RuntimeException("该工号已被占用");
			}
		}
		
		employee.setCreateDateTime(DateUtils.now());
		employeeDao.save(employee);
	}

	@Override
	public Employee findEmployeeById(String id) {
		return employeeDao.findOne(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		if (employee.getStateType().equals(StateType.OUTJOB)) {// 离职
			employee.setLenveDateTime(DateUtils.now());
		}
		employeeDao.save(employee);
	}

	@Override
	public Iterable<Employee> findAllEmployee() {
		return employeeDao.findAll();
	}

	
	
	

	@Override
	public Page<Employee> findPage(Specification<Employee> spec,
			Pageable pageable) {
		return employeeDao.findAll(spec, pageable);
	}




	/**
	 * 是否需要初始化年假信息。
	 */

	public boolean IS_INITIAL_ANNUAL_LEAVE = false;// 是否需要初始化年假信息。

	/**
	 * 每天定时计算员工的年假，只对在每年本日入职的员工计算年假。
	 */
	@PostConstruct
	@Scheduled(cron = "0 0 4 * * ?")
	public void annualLeave() {
		long _cont = employeeDao.count();
		int pagesize = 100, pageNum = 0;
		String currentDate = DateFormatUtils.format(Calendar.getInstance(),
				"MM-dd");

		List<Employee> emplBar = new ArrayList<Employee>();// 计算需要修改为有年假的员工容器集合

		for (long l = 0; l < _cont; l += pagesize) {
			Pageable pageable = new PageRequest(pageNum, pagesize);
			List<Employee> empList = employeeDao.findAll(pageable).getContent();
			for (Employee emp : empList) {
				String entryDate = DateFormatUtils.format(emp.getEntrytime(),
						"MM-dd");
				LOG.debug("Employee name : {} , Entry Date : {}",
						emp.getName(), entryDate);
				// 统计在职员工的年假信息
				if (!emp.getStateType().equals(StateType.OUTJOB)
						&& (IS_INITIAL_ANNUAL_LEAVE || currentDate
								.equals(entryDate))) {
					emp.setIsyearleave(Employee.IS_YEAR_LEAVE);
					emplBar.add(emp);
				}
			}
		}
		employeeDao.save(emplBar);// 修改年假
		LOG.info("Annual Leave count success……");
	}

	@Override
	public List<Employee> findEmployeeByQuery(EmployeeVo empl) {
		return employeeDao.findEmployeeByQuery(empl);
	}

//	@Override
//	public Page<Employee> findPageList(Pageable pageable, Employee empl) {
//
//		String name = "%" + StringUtils.trimToEmpty(empl.getName()) + "%";
//
//		return employeeDao.findByNameLike(pageable, name);
//	}
}
