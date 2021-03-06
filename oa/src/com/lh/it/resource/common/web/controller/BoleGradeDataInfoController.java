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

import com.lh.it.resource.common.entity.BoleGradeDataInfo;
import com.lh.it.resource.common.service.BoleGradeDataInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * @description 伯乐基础数据维护
 * @author lvyao
 */
@Controller
@RequestMapping("/boleGradeData")
public class BoleGradeDataInfoController {

	@Autowired
	private BoleGradeDataInfoService boleGradeDataInfoService;

	/**
	 * @description 列表
	 * @param model
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<BoleGradeDataInfo> spec = DynamicSpecifications.bySearchFilter(request, BoleGradeDataInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.ASC, "createTime"));
		model.addAttribute("page", boleGradeDataInfoService.findPage(spec, pageable));
		return "boleGradeData/list";
	}

	/**
	 * @description 跳转添加伯乐基础数据页面
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveBoleGradeData() {
		return "boleGradeData/save";
	}

	/**
	 * @description 添加伯乐基础数据
	 * @param loginUser
	 * @param boleGradeDataInfo
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveBoleGradeData(@CurrentUser User loginUser, BoleGradeDataInfo boleGradeDataInfo) {
		boleGradeDataInfo.setDeleteData(0);
		boleGradeDataInfo.setCreateTime(new Date());
		boleGradeDataInfo.setCreateUser(loginUser.getUsername());
		boleGradeDataInfoService.save(boleGradeDataInfo);
		return AjaxObject.newOk("添加成功").setNavTabId("BoleGradeData_164").toString();
	}

	/**
	 * @description 跳转修改伯乐基础数据页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editBoleGradeData(@PathVariable String id, Model model) {
		model.addAttribute("boleGradeData", boleGradeDataInfoService.findOne(id));
		return "boleGradeData/edit";
	}

	/**
	 * @description 修改伯乐基础数据
	 * @param loginUser
	 * @param boleGradeDataInfo
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editBoleGradeData(@CurrentUser User loginUser, BoleGradeDataInfo boleGradeDataInfo) {
		boleGradeDataInfo.setUpdateTime(new Date());
		boleGradeDataInfo.setUpdateUser(loginUser.getUsername());
		boleGradeDataInfoService.save(boleGradeDataInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("BoleGradeData_164").toString();
	}

	/**
	 * @description 查看伯乐基础数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewBoleGradeData(@PathVariable String id, Model model) {
		model.addAttribute("boleGradeData", boleGradeDataInfoService.findOne(id));
		return "boleGradeData/view";
	}

	/**
	 * @description 删除伯乐基础数据
	 * @param id
	 * @return
	 */
	@RequiresPermissions("BoleGradeData:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBoleGradeData(@PathVariable String id) {
		try {
			boleGradeDataInfoService.delete(id);
			return AjaxObject.newOk("删除成功").setCallbackType("BoleGradeData_164").toString();
		} catch (Exception e) {
			return AjaxObject.newError("删除失败：" + e.getMessage()).toString();
		}
	}

}
