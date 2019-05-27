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

import com.lh.it.resource.common.service.BasicsDataInfoService;
import com.lh.it.resource.common.service.IndustrySkillsService;
import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.company.service.CompanyInfoService;
import com.lh.it.resource.person.entity.HumanBasicInfo;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;
/**
 * 企业基本信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyInfoController {

	@Autowired
	private CompanyInfoService companyInfoService;
	
	@Autowired
	private BasicsDataInfoService basicsDataInfoService;
	
	@Autowired
	private IndustrySkillsService industrySkillsService;
	

	/**
	 *企业基本信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "6") int pageSize,
			ServletRequest request, Model model) {
		Specification<EnterBasicInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterBasicInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", companyInfoService.findPage(spec, pageable));
		return "company/companyinfo/list";
	}
	
	/**
	 * 修改企业信息调转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:edit")
	@RequestMapping(value = "/{enterId}/update", method = RequestMethod.GET)
	public String updateCompanyInfo(@PathVariable("enterId") String enterId,Model model) {
		model.addAttribute("enterBasicInfo",companyInfoService.findById(enterId));
		model.addAttribute("basicsEnterNature",basicsDataInfoService.findByParent((long) 11));
		model.addAttribute("basicsEnterFinanc",basicsDataInfoService.findByParent((long) 18));
		model.addAttribute("basicsEnterNumber",basicsDataInfoService.findByParent((long) 25));
		model.addAttribute("industrylist",industrySkillsService.findByid((long) 1));
		return "company/companyinfo/update";
	}
	
	/**
	 * 修改企业信息功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:save")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object updateCompanyInfo(EnterBasicInfo enterBasicInfo,@CurrentUser User loginUser,Model model) {
		enterBasicInfo.setUpdateTime(new Date());
		enterBasicInfo.setUpdateUser(loginUser.getUsername());
		companyInfoService.inster(enterBasicInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("Company_159").toString();
	}
	
	/**
	 * 添加企业信息调转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createCompanyInfo(Model model) {
		model.addAttribute("basicsEnterNature",basicsDataInfoService.findByParent((long) 11));
		model.addAttribute("basicsEnterFinanc",basicsDataInfoService.findByParent((long) 18));
		model.addAttribute("basicsEnterNumber",basicsDataInfoService.findByParent((long) 25));
		model.addAttribute("industrylist",industrySkillsService.findByid((long) 1));
		return "company/companyinfo/create";
	}
	
	/**
	 * 添加企业信息功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object createCompanyInfo(EnterBasicInfo enterBasicInfo,@CurrentUser User loginUser,Model model) {
		enterBasicInfo.setCreateTime(new Date());
		enterBasicInfo.setCreateUser(loginUser.getUsername());
		enterBasicInfo.setUpdateTime(new Date());
		enterBasicInfo.setUpdateUser(loginUser.getUsername());
		companyInfoService.inster(enterBasicInfo);
		return AjaxObject.newOk("新增成功").setNavTabId("Company_159").toString();
	}
	
	/**
	 * 企业信息详情
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:view")
	@RequestMapping(value = "/{enterId}/view", method = RequestMethod.GET)
	public Object viewCompanyInfo(@PathVariable("enterId") String enterId,Model model) {
		model.addAttribute("enterBasicInfo",companyInfoService.findById(enterId));
		return "company/companyinfo/view";
	}
	
	/**
	 * 删除企业信息
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Company:delete")
	@RequestMapping(value = "/{enterId}/delete", method = RequestMethod.POST)
	public @ResponseBody Object deleteCompanyInfo(@CurrentUser User loginUser,@PathVariable("enterId") String enterId,Model model) {
		companyInfoService.delete(enterId,loginUser);
		return AjaxObject.newOk("删除成功").setCallbackType("Company_159").toString();
	}
	
	/**
	 * 查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lookup",method={RequestMethod.GET, RequestMethod.POST})
	public  String personLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "5") int pageSize,
			ServletRequest request, Model model) {
		Specification<EnterBasicInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterBasicInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", companyInfoService.findPage(spec, pageable));
		return "company/companylookup";
	}
	
}
