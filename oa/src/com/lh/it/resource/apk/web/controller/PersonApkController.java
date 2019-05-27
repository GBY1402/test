package com.lh.it.resource.apk.web.controller;

import java.util.Date;

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

import com.lh.it.resource.apk.entity.ApkInfo;
import com.lh.it.resource.apk.service.ApkService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * 上传Apk
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/apk")
public class PersonApkController {
	
	@Autowired
	private ApkService apkService;
	
	/**
	 * 新增页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String createJump(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<ApkInfo> spec = DynamicSpecifications.bySearchFilter(request, ApkInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("listApk", apkService.findAll(spec,pageable));
		return "apk/index";
	}
	
	/**
	 * 调转上传安装包
	 * @return
	 */
	@RequiresPermissions("empl:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createPersonAPK() {
		return "apk/create";
	}
	
	/**
	 * 上传
	 * @param file
	 * @param apkInfo
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("empl:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public String createPersonAPK( @CurrentUser User loginUser,ApkInfo apkInfo) {
		apkService.inster(apkInfo,loginUser);
		return AjaxObject.newOk("新增成功").setNavTabId("APK_149").toString();
	}
	
	/**
	 * 跳转修改APK信息的页面
	 * @param id
	 * @return
	 */
	@RequiresPermissions("empl:edit")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updatePersonAPK(@PathVariable String id, Model model){
		model.addAttribute("apkInfo", apkService.findOne(id));
		return "apk/update";
	}
	
	/**
	 * 修改APK信息
	 * @param loginUser
	 * @param apkInfo
	 * @return
	 */
	@RequiresPermissions("empl:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updatePersonAPK(@CurrentUser User loginUser, ApkInfo apkInfo){
		apkInfo.setUpdateTime(new Date());
		apkInfo.setUpdateName(loginUser.getUsername());
		apkService.update(apkInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("APK_149").toString();
	}
	
	/**
	 * 查看APK信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewPersonAPK(@PathVariable String id, Model model){
		model.addAttribute("apkInfo", apkService.findOne(id));
		return "apk/view";
	}
	
	/**
	 * 删除APK信息
	 * @param id
	 * @return
	 */
	@RequiresPermissions("empl:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public @ResponseBody String updatePersonAPK(@PathVariable String id){
		apkService.delete(id);
		return AjaxObject.newOk("删除成功").setCallbackType("APK_149").toString();
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String createCompanyAPK(String url,RedirectAttributes redirectAttributes) {
		
		return "";
	}
}
