package com.lh.it.resource.company.web.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lh.it.resource.company.entity.EnterHRWalletInfo;
import com.lh.it.resource.company.service.HrWalletService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * HR钱包
 * 
 * @author lvyao
 *
 */
@Controller
@RequestMapping("/hrWallet")
public class HrWalletController {

	@Autowired
	private HrWalletService hrWalletService;

	/**
	 * HR钱包信息列表
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param request
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWallet:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<EnterHRWalletInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterHRWalletInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", hrWalletService.findPage(spec, pageable));
		return "company/hrwallet/list";
	}

	/**
	 * 跳转 添加钱包
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWallet:edit")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createHrWallet(Model model) {
		return "company/hrwallet/create";
	}

	/**
	 * 添加钱包
	 * 
	 * @param enterHRWalletInfo
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWallet:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object createHrWallet(EnterHRWalletInfo enterHRWalletInfo, @CurrentUser User loginUser) {
		Optional<EnterHRWalletInfo> optional = Optional.ofNullable(hrWalletService.save(enterHRWalletInfo, loginUser));
		return optional.isPresent() ? AjaxObject.newOk("添加成功！") : AjaxObject.newError("一个账号只能添加一个钱包");
	}

	/**
	 * 跳转 修改钱包
	 * 
	 * @param walletId
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HrWallet:edit")
	@RequestMapping(value = "/{walletId}/update", method = RequestMethod.GET)
	public String updateHrWallet(@PathVariable("walletId") String walletId, Model model) {
		model.addAttribute("walletInfo", hrWalletService.findOne(walletId));
		return "company/hrwallet/update";
	}

	/**
	 * 修改钱包
	 * 
	 * @param enterHRWalletInfo
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWallet:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object updateHrWallet(EnterHRWalletInfo enterHRWalletInfo, @CurrentUser User loginUser) {
		hrWalletService.update(enterHRWalletInfo, loginUser);
		return AjaxObject.newOk("修改钱包成功").toString();
	}

	/**
	 * 删除钱包
	 * 
	 * @param walletId
	 * @param loginUser
	 * @return
	 */
	@RequiresPermissions("HrWallet:delete")
	@RequestMapping(value = "/{walletId}/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(@PathVariable("walletId") String walletId, @CurrentUser User loginUser) {
		hrWalletService.delete(walletId, loginUser);
		return AjaxObject.newOk("删除成功").setCallbackType("HrWallet_172").setNavTabId("HrWallet_172");
	}

	/**
	 * 查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lookup", method = { RequestMethod.GET, RequestMethod.POST })
	public String personLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<EnterHRWalletInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterHRWalletInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", hrWalletService.findPage(spec, pageable));
		return "company/hrwallet/lookup";
	}

	/**
	 * HR查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hrLookupByWallet", method = { RequestMethod.GET, RequestMethod.POST })
	public String hrLookupByWallet(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "10") int pageSize, ServletRequest request,
			Model model) {
		Specification<EnterHRWalletInfo> spec = DynamicSpecifications.bySearchFilter(request, EnterHRWalletInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", hrWalletService.findPage(spec, pageable));
		return "company/detailed/hrlookup";
	}

}
