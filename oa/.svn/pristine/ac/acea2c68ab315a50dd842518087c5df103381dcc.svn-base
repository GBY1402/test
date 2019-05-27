package com.lh.it.resource.company.web.controller;

import java.util.Map;
import java.util.Optional;

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

import com.lh.it.resource.company.entity.HRDetailedInfo;
import com.lh.it.resource.company.service.HrDetailedService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * HR钱包明细
 * 
 * @author lvyao
 *
 */
@Controller
@RequestMapping("/hrWalletDetail")
public class HrWalletDetailController {

	@Autowired
	private HrDetailedService hrDetailedService;

	/**
	 * 钱包明细列表
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param request
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<HRDetailedInfo> spec = DynamicSpecifications.bySearchFilter(request, HRDetailedInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", hrDetailedService.findPage(spec, pageable));
		return "company/detailed/list";
	}

	/**
	 * 跳转 添加钱包明细
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:edit")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "company/detailed/create";
	}

	/**
	 * 添加钱包明细
	 * @param hrDetailedInfo
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object create(HRDetailedInfo hrDetailedInfo, @CurrentUser User loginUser) {
		hrDetailedService.save(hrDetailedInfo, loginUser);
		return AjaxObject.newOk("add success").toString();
	}

	/**
	 * 跳转 修改钱包明细
	 * @param detailedId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:edit")
	@RequestMapping(value = "/{detailedId}/update", method = RequestMethod.GET)
	public String update(@PathVariable("detailedId") String detailedId, Model model) {
		model.addAttribute("walletInfo", hrDetailedService.findOne(detailedId));
		return "company/detailed/update";
	}

	/**
	 * 修改钱包明细
	 * @param hrDetailedInfo
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HRDetailedInfo hrDetailedInfo, @CurrentUser User loginUser) {
		hrDetailedService.update(hrDetailedInfo, loginUser);
		return AjaxObject.newOk("update success").toString();
	}

	/**
	 * 删除钱包明细
	 * @param detailedId
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:delete")
	@RequestMapping(value = "/{detailedId}/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(@PathVariable("detailedId") String detailedId, @CurrentUser User loginUser) {
		hrDetailedService.delete(detailedId, loginUser);
		return AjaxObject.newOk("delete success").setCallbackType("HrWalletDetail_174").setNavTabId("HrWalletDetail_174");
	}

	/**
	 * 完成HR结算支付
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWalletDetail:edit")
	@RequestMapping(value = "/{detailedId}/payment", method = RequestMethod.POST)
	public @ResponseBody Object payment(@PathVariable("detailedId") String detailedId, Model model, @CurrentUser User loginUser) {
		try {
			Optional<Map<String, Object>> optional = Optional.ofNullable(hrDetailedService.payment(detailedId, loginUser));
			if (optional.isPresent()) {
				Map<String, Object> map = optional.get();
				if (map.get("err_code_des").equals("余额不足")) {
					return AjaxObject.newError("余额不足！");
				}
				if (map.get("return_msg").equals("支付失败")) {
					return AjaxObject.newError("支付失败！");
				}
			} else {
				return AjaxObject.newError("支付失败！");
			}
		} catch (Exception e) {
			return AjaxObject.newError("支付失败！");
		}
		return AjaxObject.newOk("支付成功").setCallbackType("");
	}

}
