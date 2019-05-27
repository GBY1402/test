package com.lh.it.resource.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.lh.it.resource.core.entity.Employee;
import com.lh.it.resource.core.vo.EmployeeVo;

public class EmployeeDaoImpl {

	@PersistenceContext
	private EntityManager em;

	public Page<Employee> findByNameLike(Pageable pageable, EmployeeVo empl) {

		// 查询指定员工
		String hql = "from Employee empl where 1=1";

		List<Object> paraList = new ArrayList<Object>();

		if (null != empl) {
			if (StringUtils.isNoneBlank(empl.getName())) {

				hql += " and empl.name like ?";
				paraList.add("%"+empl.getName().trim()+"%");
			}

			if (null != empl.getOrga() && empl.getOrga().getId() != null) {
				hql += " and empl.organization = ?";
				paraList.add(empl.getOrga());
			}

			if (null != empl.getStateType()) {
				hql += " and empl.stateType = ?";
				paraList.add(empl.getStateType());
			}
		}

		Query q = em.createQuery(hql);
		Query q_count = em.createQuery("select count(empl) " + hql);

		for (int i = 0; i < paraList.size(); i++) {
			q.setParameter(i + 1, paraList.get(i));
			q_count.setParameter(i + 1, paraList.get(i));
		}

		q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		q.setMaxResults(pageable.getPageSize());

		long total = (Long) q_count.getSingleResult();

		@SuppressWarnings("unchecked")
		Page<Employee> _page_ = new PageImpl<Employee>(q.getResultList(),
				pageable, total);

		return _page_;

	}
	
	public List<Employee> findEmployeeByQuery(EmployeeVo empl){
		// 查询指定员工
				String hql = "from Employee empl where 1=1";

				List<Object> paraList = new ArrayList<Object>();

				if (null != empl) {
					if (StringUtils.isNoneBlank(empl.getName())) {

						hql += " and empl.name like ?";
						paraList.add("%"+empl.getName()+"%");
					}

				/*	if (null != empl.getOrga() && empl.getOrga().getId() != null) {
						hql += " and empl.organization = ?";
						paraList.add(empl.getOrga());
					}*/

					if (null != empl.getStateType()) {
						hql += " and empl.stateType = ?";
						paraList.add(empl.getStateType());
					}
				}

				Query q = em.createQuery(hql);

				for (int i = 0; i < paraList.size(); i++) {
					q.setParameter(i + 1, paraList.get(i));
				}
		return q.getResultList();
	}
}
