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

import com.lh.it.resource.company.entity.CompanyAgreemenInfo;
import com.lh.it.resource.company.entity.EnterBasicInfo;
import com.lh.it.resource.company.service.CompanyAgreemenInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * 企业协议管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/companyAgreement")
public class CompanyAgreemenInfoController {

	@Autowired
	private CompanyAgreemenInfoService companyAgreemenInfoService;

	/**
	 * 急聘/猎聘 企业协议列表
	 * @param pageNumber
	 * @param pageSize
	 * @param request
	 * @param model
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<CompanyAgreemenInfo> spec = DynamicSpecifications.bySearchFilter(request, CompanyAgreemenInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", companyAgreemenInfoService.findPage(spec, pageable));
		return "company/agreement/list";
	}

	/**
	 * 添加急聘 跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(Model model) {
		return "company/agreement/save";
	}

	/**
	 * 添加 急聘/猎聘
	 * @param loginUser
	 * @param companyAgreemenInfo
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@CurrentUser User loginUser, CompanyAgreemenInfo companyAgreemenInfo) {
		companyAgreemenInfo.setCreateUser(loginUser.getUsername());
		companyAgreemenInfo.setCreateTime(new Date());
		companyAgreemenInfo.setUpdateUser(loginUser.getUsername());
		companyAgreemenInfo.setUpdateTime(new Date());
		companyAgreemenInfoService.save(companyAgreemenInfo);
		return AjaxObject.newOk("新增成功").setNavTabId("CompanyAgreement_170").toString();
	}
	
	/**
	 * 修改急聘/猎聘 跳转
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		CompanyAgreemenInfo companyAgreemenInfo = companyAgreemenInfoService.findOne(id);
		model.addAttribute("model", companyAgreemenInfo);
		return "company/agreement/edit";
	}

	/**
	 * 修改 急聘/猎聘
	 * @param loginUser
	 * @param companyAgreemenInfo
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Object edit(@CurrentUser User loginUser, CompanyAgreemenInfo companyAgreemenInfo) {
		companyAgreemenInfo.setUpdateUser(loginUser.getUsername());
		companyAgreemenInfo.setUpdateTime(new Date());
		companyAgreemenInfoService.save(companyAgreemenInfo);
		return AjaxObject.newOk("更新成功").setNavTabId("CompanyAgreement_170").toString();
	}

	/**
	 * 查看急聘/猎聘 详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("CompanyAgreement:edit")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewCompanyAgreement(@PathVariable("id") String id, Model model) {
		model.addAttribute("model", companyAgreemenInfoService.findOne(id));
		return "company/agreement/view";
	}

}
