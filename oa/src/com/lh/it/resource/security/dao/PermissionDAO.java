/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.ketayao.ketacustom.dao.PermissionDao.java
 * Class:			PermissionDao
 * Date:			2013-4-16
 * Author:			<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.lh.it.resource.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lh.it.resource.security.entity.main.Permission;

/** 
 * 	
 * @author 	<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:10:16 
 */

public interface PermissionDAO extends JpaRepository<Permission, Long> {

}
