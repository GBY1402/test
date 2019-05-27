package com.lh.it.resource.person.web.controller;

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

import com.lh.it.resource.person.entity.WalletInfo;
import com.lh.it.resource.person.service.WalletService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;
/**
 * 个人钱包
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	private WalletService walletService;

	/**
	 * 钱包信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<WalletInfo> spec = DynamicSpecifications.bySearchFilter(request, WalletInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", walletService.findPage(spec, pageable));
		return "person/wallet/list";
	}
	
	/**
	 * 添加钱包页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:edit")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createWallet(Model model) {
		return "person/wallet/create";
	}
	
	/**
	 *  添加钱包
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object createWallet(WalletInfo walletInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		WalletInfo entity = walletService.inster(walletInfo,loginUser);
		return null == entity ? AjaxObject.newError("一个账号只能添加一个钱包") : AjaxObject.newOk("添加成功！"); 
	}

	/**
	 * 修改钱包页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:edit")
	@RequestMapping(value = "/{walletId}/update", method = RequestMethod.GET)
	public String updateWallet(@PathVariable("walletId") String walletId,Model model) {
		model.addAttribute("walletInfo", walletService.findOne(walletId));
		return "person/wallet/update";
	}
	
	/**
	 *  修改钱包
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object updateWallet(WalletInfo walletInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		walletService.update(walletInfo,loginUser);
		return AjaxObject.newOk("修改钱包成功").toString();
	}
	
	/**
	 * 删除钱包
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Wallet:delete")
	@RequestMapping(value = "/{walletId}/delete", method = RequestMethod.POST)
	public  @ResponseBody Object deleteWallet(@PathVariable("walletId") String walletId,Model model,@CurrentUser User loginUser) {
		walletService.delete(walletId,loginUser);
		return AjaxObject.newOk("删除成功").setCallbackType("Wallet_171").setNavTabId("Wallet_171");
	}
	
	/**
	 * 查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lookup",method={RequestMethod.GET, RequestMethod.POST})
	public  String personLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<WalletInfo> spec = DynamicSpecifications.bySearchFilter(request, WalletInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", walletService.findPage(spec, pageable));
		return "person/wallet/lookup";
	}
}
