package com.lh.it.resource.common.web.controller;

import javax.servlet.ServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lh.it.resource.common.entity.UserAddInfo;
import com.lh.it.resource.common.service.AccountNumberService;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
/**
 * 账号管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/account")
public class AccountNumberController {
	
	@Autowired
	private AccountNumberService accountNumberService;

	/**
	 * 账号信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<UserAddInfo> spec = DynamicSpecifications.bySearchFilter(request, UserAddInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", accountNumberService.findPage(spec, pageable));
		return "common/list";
	}
	
	/**
	 * 新增页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createJump(Model model) {
		return "common/create";
	}
	
	/**
	 * 新增页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object createJump(UserAddInfo userAddInfo,RedirectAttributes redirectAttributes) {
		accountNumberService.inster(userAddInfo);
		return AjaxObject.newOk("添加用户成功！").toString();
	}
	
	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:edit")
	@RequestMapping(value = "/{userId}/update", method = RequestMethod.GET)
	public String updateJump(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("userAddInfo",accountNumberService.findById(userId));
		return "common/update";
	}

	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object updateJump(UserAddInfo userAddInfo,RedirectAttributes redirectAttributes) {
		accountNumberService.update(userAddInfo);
		return AjaxObject.newOk("修改用户成功！").toString();
	}
	
	/**
	 * 删除账号
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:dlete")
	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
	@ResponseBody
	public Object deleteJump(@PathVariable("userId") String userId,RedirectAttributes redirectAttributes) {
		accountNumberService.delete(userId);
		return AjaxObject.newOk("删除用户成功！").toString();
	}
	
	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Account:view")
	@RequestMapping(value = "/{userId}/view", method = RequestMethod.GET)
	public String view(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("userAddInfo",accountNumberService.findById(userId));
		return "common/view";
	}
}
