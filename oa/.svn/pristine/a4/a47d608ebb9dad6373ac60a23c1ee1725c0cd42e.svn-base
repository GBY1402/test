/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.ketayao.ketacustom.service.impl.RolePermissionServiceImpl.java
 * Class:			RolePermissionServiceImpl
 * Date:			2013-4-16
 * Author:			<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.lh.it.resource.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lh.it.resource.security.dao.RolePermissionDAO;
import com.lh.it.resource.security.entity.main.RolePermission;
import com.lh.it.resource.security.service.RolePermissionService;

/** 
 * 	
 * @author 	<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:14:10 
 */
@Service
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	/**   
	 * @param rolePermission  
	 * @see com.lh.it.resource.security.service.RolePermissionService#save(com.lh.it.resource.security.entity.main.RolePermission)  
	 */
	@Override
	public void save(RolePermission rolePermission) {
		rolePermissionDAO.save(rolePermission);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.lh.it.resource.security.service.RolePermissionService#get(java.lang.Long)  
	 */
	@Override
	public RolePermission get(Long id) {
		return rolePermissionDAO.findOne(id);
	}

	/**   
	 * @param rolePermission  
	 * @see com.lh.it.resource.security.service.RolePermissionService#update(com.lh.it.resource.security.entity.main.RolePermission)  
	 */
	@Override
	public void update(RolePermission rolePermission) {
		rolePermissionDAO.save(rolePermission);
	}

	/**   
	 * @param id  
	 * @see com.lh.it.resource.security.service.RolePermissionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		rolePermissionDAO.delete(id);
	}

	/**   
	 * @param roleId
	 * @return  
	 * @see com.lh.it.resource.security.service.RolePermissionService#findByRoleId(java.lang.Long)  
	 */
	@Override
	public List<RolePermission> findByRoleId(Long roleId) {
		return rolePermissionDAO.findByRoleId(roleId);
	}

	/* (non-Javadoc)
	 * @see com.ketayao.ketacustom.service.RolePermissionService#save(java.lang.Iterable)
	 */
	@Override
	public void save(Iterable<RolePermission> entities) {
		rolePermissionDAO.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.ketayao.ketacustom.service.RolePermissionService#deleteInBatch(java.lang.Iterable)
	 */
	@Override
	public void deleteInBatch(Iterable<RolePermission> entities) {
		rolePermissionDAO.deleteInBatch(entities);
	}
}
