package com.lh.it.resource.person.web.controller;

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

import com.lh.it.resource.person.entity.JobperCentreInfo;
import com.lh.it.resource.person.service.JobperCenterInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * 简历投递记录
 * @author lvyao
 *
 */
@Controller
@RequestMapping("/jobper")
public class JobperCenterInfoController {

	@Autowired
	private JobperCenterInfoService jobperCenterInfoService;
	
	/**
	 * 简历投递列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Jobper:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<JobperCentreInfo> spec = DynamicSpecifications.bySearchFilter(request, JobperCentreInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", jobperCenterInfoService.findPage(spec, pageable));
		return "person/jobper/list";
	}
	
	/**
	 * 查看简历投递详情
	 * @return
	 */
	@RequiresPermissions("Jobper:view")
	@RequestMapping(value = "/{centreId}/view", method = RequestMethod.GET)
	public String viewJobper(@PathVariable String centreId, Model model){
		model.addAttribute("jobper", jobperCenterInfoService.findOne(centreId));
		return "person/jobper/view";
	}
	
	/**
	 * 跳转更新
	 * @return
	 */
	@RequiresPermissions("Jobper:edit")
	@RequestMapping(value = "/{centreId}/edit", method = RequestMethod.GET)
	public String editJobper(@PathVariable String centreId, Model model){
		model.addAttribute("jobper", jobperCenterInfoService.findOne(centreId));
		return "person/jobper/edit";
	}
	
	/**
	 * 更新
	 * @return
	 */
	@RequiresPermissions("Jobper:edit")
	@RequestMapping(value = "//edit", method = RequestMethod.POST)
	@ResponseBody
	public String editJobper(@CurrentUser User loginUser, JobperCentreInfo jobperCentreInfo){
		jobperCentreInfo.setUpdateUser(loginUser.getUsername());
		jobperCentreInfo.setUpdateTime(new Date());
		jobperCenterInfoService.save(jobperCentreInfo);
		return AjaxObject.newOk("更新成功").setNavTabId("Jobper_169").toString();
	}
	
	/**
	 * 后台删除简历投递记录
	 * @return
	 */
	@RequiresPermissions("Jobper:delete")
	@RequestMapping(value = "/{centreId}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteJobper(@PathVariable String centreId){
		JobperCentreInfo jobperCentreInfo = jobperCenterInfoService.findOne(centreId);
		if(null == jobperCentreInfo){
			return AjaxObject.newError("删除失败!<br/>不存在对应简历投递记录").toString();
		}
		// 后台删除所以设置删除状态为后台删除
		jobperCentreInfo.setDeleteCentre(1);
		jobperCenterInfoService.save(jobperCentreInfo);
		return AjaxObject.newOk("删除成功").setCallbackType("Jobper_169").toString();
	}
	
}
