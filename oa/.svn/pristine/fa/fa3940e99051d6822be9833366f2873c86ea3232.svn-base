package com.lh.it.resource.company.web.controller;

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

import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.service.BasicsDataInfoService;
import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.company.entity.EnterPersonInfo;
import com.lh.it.resource.company.entity.JobWanfedInfo;
import com.lh.it.resource.company.service.RecruitInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;
/**
 * 招聘信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/recruit")
public class RecruitInfoController {
	
	@Autowired
	private RecruitInfoService recruitInfoService;
	
	@Autowired
	private BasicsDataInfoService basicsDataInfoService;

	/**
	 *企业全职招聘列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String recruitList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<JobWanfedInfo> spec = DynamicSpecifications.bySearchFilter(request, JobWanfedInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", recruitInfoService.findPage(spec, pageable));
		return "company/recruit/list";
	}
	
	/**
	 * 跳转修改全职招聘信息页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:edit")
	@RequestMapping(value = "/{enterId}/update", method = RequestMethod.GET)
	public String updateRecruit(@PathVariable("enterId") String enterId,Model model) {
		model.addAttribute("enter", recruitInfoService.findJobWanfedInfo(enterId));
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/recruit/update";
	}

	/**
	 * 修改全职招聘信息
	 * @param loginUser
	 * @param jobWanfedInfo
	 * @return
	 */
	@RequiresPermissions("Recruit:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateRecruit(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		// 设置企业ID
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("Recruit_160").toString();
	}
	
	/**
	 * 删除全职招聘信息
	 * @param id
	 * @return
	 */
	@RequiresPermissions("Recruit:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteRecruit(@PathVariable String id){
		JobWanfedInfo jobWanfedInfo = recruitInfoService.findJobWanfedInfo(id);
		if(null == jobWanfedInfo){
			return AjaxObject.newError("删除失败<br/>全职招聘信息不存在");
		}
		jobWanfedInfo.setJobDelete(1);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("删除成功").setNavTabId("Recruit_160").setCallbackType("Recruit_160");
	}
	
	/**
	 * 跳转添加全职招聘信息页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String createRecruit(Model model) {
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/recruit/create";
	}
	
	/**
	 * 添加全职招聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String createRecruit(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setCreateTime(new Date());
		jobWanfedInfo.setCreateUser(loginUser.getUsername());
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("新增成功").setNavTabId("Recruit_160").toString();
	}
	
	/**
	 * 查看全职招聘详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewRecruit(@PathVariable String id, Model model){
		model.addAttribute("job", recruitInfoService.findJobWanfedInfo(id));
		return "company/recruit/view";
	}
	
	/**
	 *企业急聘信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitJ:view")
	@RequestMapping(value = "/worry", method={RequestMethod.GET, RequestMethod.POST})
	public String worryList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<JobWanfedInfo> spec = DynamicSpecifications.bySearchFilter(request, JobWanfedInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", recruitInfoService.findPage(spec, pageable));
		return "company/worry/list";
	}
	
	/**
	 * 跳转修改急聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitJ:edit")
	@RequestMapping(value = "/worry/{enterId}/update", method = RequestMethod.GET)
	public String updateWorry(@PathVariable("enterId") String enterId,Model model) {
		model.addAttribute("enter", recruitInfoService.findJobWanfedInfo(enterId));
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/worry/update";
	}
	
	/**
	 * 修改急聘信息
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitJ:edit")
	@RequestMapping(value = "/worry/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateWorry(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("RecruitJ_161").toString();
	}
	
	/**
	 * 跳转添加急聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitJ:save")
	@RequestMapping(value = "/worry/save", method = RequestMethod.GET)
	public String createWorry(Model model) {
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/worry/create";
	}
	
	/**
	 * 添加急聘信息
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitJ:save")
	@RequestMapping(value = "/worry/save", method = RequestMethod.POST)
	@ResponseBody
	public String createWorry(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setCreateTime(new Date());
		jobWanfedInfo.setCreateUser(loginUser.getUsername());
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("新增成功").setNavTabId("RecruitJ_161").toString();
	}
	
	/**
	 * 删除急聘招聘信息
	 * @param id
	 * @return
	 */
	@RequiresPermissions("RecruitJ:delete")
	@RequestMapping(value = "/worry/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteRecruitWorry(@PathVariable String id){
		JobWanfedInfo jobWanfedInfo = recruitInfoService.findJobWanfedInfo(id);
		if(null == jobWanfedInfo){
			return AjaxObject.newError("删除失败<br/>急聘招聘信息不存在");
		}
		jobWanfedInfo.setJobDelete(1);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("删除成功").setNavTabId("RecruitJ_161").setCallbackType("RecruitJ_161");
	}
	
	/**
	 * 查看急聘详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Recruit:view")
	@RequestMapping(value = "/worry/{id}/view", method = RequestMethod.GET)
	public String viewRecruitWorry(@PathVariable String id, Model model){
		model.addAttribute("job", recruitInfoService.findJobWanfedInfo(id));
		return "company/worry/view";
	}
	
	/**
	 *企业猎聘信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:view")
	@RequestMapping(value = "/hunting", method={RequestMethod.GET, RequestMethod.POST})
	public String huntingList(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<JobWanfedInfo> spec = DynamicSpecifications.bySearchFilter(request, JobWanfedInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", recruitInfoService.findPage(spec, pageable));
		return "company/hunting/list";
	}
	
	/**
	 * 跳转修改猎聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:edit")
	@RequestMapping(value = "/hunting/{enterId}/update", method = RequestMethod.GET)
	public String updateHunting(@PathVariable("enterId") String enterId,Model model) {
		model.addAttribute("enter", recruitInfoService.findJobWanfedInfo(enterId));
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/hunting/update";
	}
	
	/**
	 * 修改猎聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:edit")
	@RequestMapping(value = "/hunting/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateHunting(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("RecruitL_162").toString();
	}
	
	/**
	 * 跳转添加猎聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:save")
	@RequestMapping(value = "/hunting/save", method = RequestMethod.GET)
	public String createHunting(Model model) {
		model.addAttribute("fullPay",basicsDataInfoService.findByParent((long) 37));
		model.addAttribute("diploma",basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("workLifeData",basicsDataInfoService.findByParent((long) 48));
		return "company/hunting/create";
	}
	
	/**
	 * 添加猎聘
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:save")
	@RequestMapping(value = "/hunting/save", method = RequestMethod.POST)
	@ResponseBody
	public String createHunting(@CurrentUser User loginUser, JobWanfedInfo jobWanfedInfo) {
		jobWanfedInfo.setCreateTime(new Date());
		jobWanfedInfo.setCreateUser(loginUser.getUsername());
		jobWanfedInfo.setUpdateTime(new Date());
		jobWanfedInfo.setUpdateUser(loginUser.getUsername());
		// 设置行业ID
		jobWanfedInfo = this.getEnterId(jobWanfedInfo);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("新增成功").setNavTabId("RecruitL_162").toString();
	}
	
	/**
	 * 删除猎聘招聘信息
	 * @param id
	 * @return
	 */
	@RequiresPermissions("RecruitL:delete")
	@RequestMapping(value = "/hunting/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object deleteRecruitHunting(@PathVariable String id){
		JobWanfedInfo jobWanfedInfo = recruitInfoService.findJobWanfedInfo(id);
		if(null == jobWanfedInfo){
			return AjaxObject.newError("删除失败<br/>猎聘招聘信息不存在");
		}
		jobWanfedInfo.setJobDelete(1);
		recruitInfoService.saveJobWanfedInfo(jobWanfedInfo);
		return AjaxObject.newOk("删除成功").setNavTabId("RecruitL_162").setCallbackType("RecruitL_162");
	}
	
	/**
	 * 查看急聘详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("RecruitL:view")
	@RequestMapping(value = "/hunting/{id}/view", method = RequestMethod.GET)
	public String viewRecruitHunting(@PathVariable String id, Model model){
		model.addAttribute("job", recruitInfoService.findJobWanfedInfo(id));
		return "company/hunting/view";
	}
	
	// 设置企业ID
	public JobWanfedInfo getEnterId(JobWanfedInfo jobWanfedInfo){
		// 设置行业ID
		jobWanfedInfo.setWorkIndustry(new FunctionInfo());
		jobWanfedInfo.getWorkIndustry().setId(jobWanfedInfo.getWorkFunction().getParent().getId());
		// 设置HR所属公司
		String enterId = recruitInfoService.findEnterBasicInfo(jobWanfedInfo.getEnterPersonInfo().getEnterPerId());
		if(jobWanfedInfo.getEnterBasicInfo() == null){
			EnterBasicInfo enterBasicInfo = new EnterBasicInfo();
			jobWanfedInfo.setEnterBasicInfo(enterBasicInfo);
		}
		jobWanfedInfo.getEnterBasicInfo().setEnterId(enterId);
		return jobWanfedInfo;
	}
	
	/**
	 * HR查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hrLookup",method={RequestMethod.GET, RequestMethod.POST})
	public  String hrLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<EnterPersonInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterPersonInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", recruitInfoService.findPageHr(spec, pageable));
		return "company/hrlookup";
	}
	
}
