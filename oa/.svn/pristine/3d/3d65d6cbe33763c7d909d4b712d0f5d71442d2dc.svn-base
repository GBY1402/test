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

import com.lh.it.resource.common.entity.HuntingWorryDataInfo;
import com.lh.it.resource.common.service.HuntingWorryDataInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

/**
 * @description 急聘猎聘佣金基础数据设置
 * @author lvyao
 *
 */
@Controller
@RequestMapping("/huntingWorryData")
public class HuntingWorryDataInfoController {

	@Autowired
	private HuntingWorryDataInfoService huntingWorryDataInfoService;

	/**
	 * @description 列表
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<HuntingWorryDataInfo> spec = DynamicSpecifications.bySearchFilter(request, HuntingWorryDataInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.ASC, "createTime"));
		model.addAttribute("page", huntingWorryDataInfoService.findPage(spec, pageable));
		return "huntingWorryData/list";
	}

	/**
	 * @description 跳转添加急聘猎聘佣金基础数据页面
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:save")
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String saveHuntingWorryDataInfo() {
		return "huntingWorryData/save";
	}

	/**
	 * @description 添加急聘猎聘佣金基础数据
	 * @param loginUser
	 * @param huntingWorryDataInfo
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveHuntingWorryDataInfo(@CurrentUser User loginUser, HuntingWorryDataInfo huntingWorryDataInfo) {
		huntingWorryDataInfo.setDeleteData(0);
		huntingWorryDataInfo.setCreateTime(new Date());
		huntingWorryDataInfo.setCreateUser(loginUser.getUsername());
		huntingWorryDataInfoService.save(huntingWorryDataInfo);
		return AjaxObject.newOk("添加成功").toString();
	}

	/**
	 * @description 跳转修改急聘猎聘佣金基础数据页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editHuntingWorryDataInfo(@PathVariable String id, Model model) {
		model.addAttribute("huntingWorryData", huntingWorryDataInfoService.findOne(id));
		return "huntingWorryData/edit";
	}

	/**
	 * @description 修改急聘猎聘佣金基础数据
	 * @param loginUser
	 * @param huntingWorryDataInfo
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editHuntingWorryDataInfo(@CurrentUser User loginUser, HuntingWorryDataInfo huntingWorryDataInfo) {
		huntingWorryDataInfoService.save(huntingWorryDataInfo);
		return AjaxObject.newOk("修改成功").toString();
	}

	/**
	 * @description 查看急聘猎聘佣金基础数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewHuntingWorryDataInfo(@PathVariable String id, Model model) {
		model.addAttribute("huntingWorryData", huntingWorryDataInfoService.findOne(id));
		return "huntingWorryData/view";
	}

	/**
	 * @description 删除伯乐基础数据
	 * @param id
	 * @return
	 */
	@RequiresPermissions("HuntingWorryData:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteHuntingWorryDataInfo(@PathVariable String id) {
		try {
			HuntingWorryDataInfo huntingWorryDataInfo = huntingWorryDataInfoService.findOne(id);
			huntingWorryDataInfo.setDeleteData(1);
			huntingWorryDataInfoService.save(huntingWorryDataInfo);
			return AjaxObject.newOk("删除成功").setCallbackType("HuntingWorryData_166").toString();
		} catch (Exception e) {
			return AjaxObject.newError("删除失败：" + e.getMessage()).toString();
		}
	}

}
