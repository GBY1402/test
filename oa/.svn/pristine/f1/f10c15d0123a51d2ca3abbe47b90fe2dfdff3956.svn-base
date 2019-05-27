/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ketayao.ketacustom.controller.RoleController.java
 * Class:			RoleController
 * Date:			2012-8-7
 * Author:			<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.lh.it.resource.security.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.lh.it.resource.BeeException;
import com.lh.it.resource.security.entity.main.Role;
import com.lh.it.resource.security.entity.main.RolePermission;
import com.lh.it.resource.security.log.Log;
import com.lh.it.resource.security.log.LogMessageObject;
import com.lh.it.resource.security.log.impl.LogUitl;
import com.lh.it.resource.security.service.ModuleService;
import com.lh.it.resource.security.service.RolePermissionService;
import com.lh.it.resource.security.service.RoleService;
import com.lh.it.resource.security.util.dwz.AjaxObject;
import com.lh.it.resource.security.util.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:44:13 
 */
@Controller
@RequestMapping("/management/security/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private ModuleService moduleService;
	
	private static final String CREATE = "management/security/role/create";
	private static final String UPDATE = "management/security/role/update";
	private static final String LIST = "management/security/role/list";
	private static final String VIEW = "management/security/role/view";
	
	@InitBinder
	public void initListBinder(WebDataBinder binder) {
		// 设置需要包裹的元素个数，默认为256
	    binder.setAutoGrowCollectionLimit(5000);
	}
	
	@RequiresPermissions("Role:save")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		map.put("module", moduleService.getTree());
		return CREATE;
	}
	
	@Log(message="添加了{0}角色。")
	@RequiresPermissions("Role:save")
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(@Valid Role role) {
		List<RolePermission> rolePermissions = Lists.newArrayList();
		for (RolePermission rolePermission : role.getRolePermissions()) {
			if (rolePermission.getPermission() != null && rolePermission.getPermission().getId() != null) {
				rolePermissions.add(rolePermission);
			}
		}
		
		for (RolePermission rolePermission : rolePermissions) {
			rolePermission.setRole(role);
		}
		
		roleService.save(role);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{role.getName()}));
		return AjaxObject.newOk("添加角色成功！").toString();
	}
	
	@RequiresPermissions("Role:edit")
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Role role = roleService.get(id);
		
		map.put("module", moduleService.getTree());
		map.put("role", role);
		return UPDATE;
	}
	
	@Log(message="修改了{0}角色的信息。")
	@RequiresPermissions("Role:edit")
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(@Valid Role role) {
		Role oldRole = roleService.get(role.getId());
		oldRole.setName(role.getName());
		oldRole.setDescription(role.getDescription());
		
		List<RolePermission> newRList = new ArrayList<RolePermission>();
		List<RolePermission> delRList = new ArrayList<RolePermission>();
		
		List<RolePermission> hasRolePermissions = rolePermissionService.findByRoleId(role.getId());
		for (RolePermission rolePermission : role.getRolePermissions()) {
			if (rolePermission.getId() == null && rolePermission.getPermission() != null) {
				rolePermission.setRole(oldRole);
				newRList.add(rolePermission);
			} else if (rolePermission.getId() != null && rolePermission.getPermission() == null) {
				for (RolePermission rp : hasRolePermissions) {
					if (rp.getId().equals(rolePermission.getId())) {
						delRList.add(rp);
						break;
					}
				}
			}
		}
		
		rolePermissionService.save(newRList);
		rolePermissionService.deleteInBatch(delRList);
		roleService.update(oldRole);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{oldRole.getName()}));
		return AjaxObject.newOk("修改角色成功！").toString();
	}
	
	@Log(message="删除了{0}角色。")
	@RequiresPermissions("Role:delete")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable Long id) {
		Role role = roleService.get(id);
		try {
			roleService.delete(role.getId());
		} catch (BeeException e) {
			return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
		}

		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{role.getName()}));
		return AjaxObject.newOk("删除角色成功！").setCallbackType("").toString();
	}
	
	@RequiresPermissions("Role:view")
	@RequestMapping(value="/list", method={RequestMethod.GET, RequestMethod.POST})
	public String list(Page page, String keywords, Map<String, Object> map) {
		List<Role> roles = null;
		if (StringUtils.isNotBlank(keywords)) {
			roles = roleService.find(page, keywords);
		} else {
			roles = roleService.findAll(page);
		}

		map.put("page", page);
		map.put("roles", roles);
		map.put("keywords", keywords);
		return LIST;
	}
	
	@RequiresPermissions("Role:view")
	@RequestMapping(value="/view/{id}", method={RequestMethod.GET})
	public String view(@PathVariable Long id, Map<String, Object> map) {
		Role role = roleService.get(id);
		
		map.put("module", moduleService.getTree());
		map.put("role", role);
		return VIEW;
	}

}
