package com.lh.it.resource.person.web.controller;

import java.util.Map;

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

import com.lh.it.resource.person.entity.PersonDetailedInfo;
import com.lh.it.resource.person.service.PersonDetailedService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * 个人钱包明细
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/persondetailed")
public class PersonDetailedController {

	@Autowired
	private PersonDetailedService  personDetailedService;
	
	/**
	 * 钱包信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<PersonDetailedInfo> spec = DynamicSpecifications.bySearchFilter(request, PersonDetailedInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", personDetailedService.findPage(spec, pageable));
		return "person/detailed/list";
	}
	
	/**
	 * 添加钱包明细页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:edit")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "person/detailed/create";
	}
	
	/**
	 *  添加钱包明细
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object create(PersonDetailedInfo personDetailedInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personDetailedService.inster(personDetailedInfo,loginUser);
		return AjaxObject.newOk("修改成功！").toString();
	}
	
	/**
	 * 修改钱包明细页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:edit")
	@RequestMapping(value = "/{detailedId}/update", method = RequestMethod.GET)
	public String update(@PathVariable("detailedId") String detailedId,Model model) {
		model.addAttribute("walletInfo", personDetailedService.findOne(detailedId));
		return "person/detailed/update";
	}
	
	/**
	 *  修改钱包明细
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(PersonDetailedInfo personDetailedInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personDetailedService.update(personDetailedInfo,loginUser);
		return AjaxObject.newOk("修改成功！").toString();
	}
	
	/**
	 * 删除钱包明细页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:delete")
	@RequestMapping(value = "/{detailedId}/delete", method = RequestMethod.POST)
	public  @ResponseBody Object delete(@PathVariable("detailedId") String detailedId,Model model,@CurrentUser User loginUser) {
		personDetailedService.delete(detailedId,loginUser);
		return AjaxObject.newOk("删除成功").setCallbackType("Persondetailed_173").setNavTabId("Persondetailed_173");
	}
	
	/**
	 * 完成个人支付
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Persondetailed:edit")
	@RequestMapping(value = "/{detailedId}/payment", method = RequestMethod.POST)
	public  @ResponseBody Object payment(@PathVariable("detailedId") String detailedId,Model model,@CurrentUser User loginUser) {
		try {
		Map<String,Object> map=personDetailedService.payment(detailedId,loginUser);
		if(map==null){
			return AjaxObject.newError("支付失败！");
		}
		if(map.get("err_code_des").equals("余额不足")){
			
			return AjaxObject.newError("余额不足！");
		}
		if(map.get("return_msg").equals("支付失败")){
			return AjaxObject.newError("支付失败！");
			} 
		}catch (Exception e) {
			return AjaxObject.newError("支付失败！");
		}
		return AjaxObject.newOk("支付成功").setCallbackType("");
	}
}
