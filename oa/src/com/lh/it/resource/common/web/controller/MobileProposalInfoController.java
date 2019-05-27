package com.lh.it.resource.common.web.controller;

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

import com.lh.it.resource.common.entity.MobileProposalInfo;
import com.lh.it.resource.common.service.MobileProposalInfoService;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;

/**
 * @description APP反馈与建议
 * @author lvyao
 */
@Controller
@RequestMapping("/appProposal")
public class MobileProposalInfoController {

	@Autowired
	private MobileProposalInfoService mobileProposalInfoService;

	/**
	 * @description 列表
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param request
	 * @param model
	 * @return
	 */
	@RequiresPermissions("AppProposal:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request, Model model) {
		Specification<MobileProposalInfo> spec = DynamicSpecifications.bySearchFilter(request, MobileProposalInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "mobileTime"));
		model.addAttribute("page", mobileProposalInfoService.findPage(spec, pageable));
		return "appProposal/list";
	}

	/**
	 * @description 查看APP反馈
	 * 
	 * @return
	 */
	@RequiresPermissions("AppProposal:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewAppProposal(@PathVariable String id, Model model) {
		model.addAttribute("appProposal", mobileProposalInfoService.findOne(id));
		return "appProposal/view";
	}

	/**
	 * @description 删除APP反馈
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("AppProposal:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteAppProposal(@PathVariable String id) {
		try {
			mobileProposalInfoService.delete(id);
			return AjaxObject.newOk("删除成功").setCallbackType("AppProposal_167").toString();
		} catch (Exception e) {
			return AjaxObject.newError("删除失败：" + e.getMessage()).toString();
		}
	}

	/**
	 * @description 跳转添加APP反馈的页面
	 * @return
	 */
	@RequiresPermissions("AppProposal:save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveAppProposal(){
		return "appProposal/save";
	}
	
	/**
	 * @description 添加APP反馈
	 * @param mobileProposalInfo
	 * @return
	 */
	@RequiresPermissions("AppProposal:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveAppProposal(MobileProposalInfo mobileProposalInfo){
		mobileProposalInfo.setMobileTime(new Date());
		mobileProposalInfoService.save(mobileProposalInfo);
		return AjaxObject.newOk("添加成功").setNavTabId("AppProposal_167").toString();
	}

	/**
	 * @description 跳转修改APP反馈的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("AppProposal:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editAppProposal(@PathVariable String id, Model model){
		model.addAttribute("appProposal", mobileProposalInfoService.findOne(id));
		return "appProposal/edit";
	}
	
	/**
	 * @description 修改APP反馈
	 * @param mobileProposalInfo
	 * @return
	 */
	@RequiresPermissions("AppProposal:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editAppProposal(MobileProposalInfo mobileProposalInfo){
		mobileProposalInfoService.save(mobileProposalInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("AppProposal_167").toString();
	}
	
}
