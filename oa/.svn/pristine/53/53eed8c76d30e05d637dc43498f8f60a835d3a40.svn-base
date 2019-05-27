package com.lh.it.resource.common.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lh.it.resource.common.entity.BasicsDataInfo;
import com.lh.it.resource.common.service.BasicsDataInfoService;
import com.lh.it.resource.utils.dwz.AjaxObject;

/**
 * 公共基础数据维护
 * @author lvyao
 */
@Controller
@RequestMapping("/basics")
public class BasicsDataInfoController {

	@Autowired
	private BasicsDataInfoService basicsDataInfoService;
	
	/**
	 * 列表
	 * @param model
	 * @return
	 */
	@RequiresPermissions("BasicsData:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<BasicsDataInfo> orgaList = basicsDataInfoService.findAll();
		model.addAttribute("jsonTree",BasicsDataInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("parentId", BasicsDataInfo.ROOT_NODE_ID);
		model.addAttribute("nodeList", basicsDataInfoService.findByParent(BasicsDataInfo.ROOT_NODE_ID));
		return "basics/list";
	}
	
	/**
	 * 查询子节点数据
	 */
	@RequiresPermissions("BasicsData:view")
	@RequestMapping(value = "/findChild")
	public String findChild(@RequestParam("eId") Long eId, Model model) {
		model.addAttribute("nodeList", basicsDataInfoService.findByParent(eId));
		model.addAttribute("parentId",eId);
		return "basics/childlist";
	}
	
	/**
	 * 跳转添加基础数据
	 * @return
	 */
	@RequiresPermissions("BasicsData:save")
	@RequestMapping(value = "/{parentId}/save", method = RequestMethod.GET)
	public String saveBasicsData(@PathVariable Long parentId, Model model){
		model.addAttribute("parent", basicsDataInfoService.findOne(parentId));
		return "basics/save";
	}
	
	/**
	 * 添加基本数据
	 * @param basicsDataInfo
	 * @return
	 */
	@RequiresPermissions("BasicsData:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveBasicsData(BasicsDataInfo basicsDataInfo){
		if(basicsDataInfo.getcGrade() > 3)
			return AjaxObject.newError("节点最多为2级").toString();
		basicsDataInfoService.insert(basicsDataInfo);
		return AjaxObject.newOk("添加成功").toString();
	}
	
	/**
	 * 跳转更新基础数据
	 * @return
	 */
	@RequiresPermissions("BasicsData:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editBasicsData(@PathVariable Long id, Model model){
		model.addAttribute("basicsData", basicsDataInfoService.findOne(id));
		return "basics/edit";
	}
	
	/**
	 * 更新基本数据
	 * @param basicsDataInfo
	 * @return
	 */
	@RequiresPermissions("BasicsData:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editBasicsData(BasicsDataInfo basicsDataInfo){
		basicsDataInfoService.insert(basicsDataInfo);
		return AjaxObject.newOk("更新成功").toString();
	}
	
	/**
	 * 查看基本数据详情
	 */
	@RequiresPermissions("BasicsData:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewBasicsData(@PathVariable Long id, Model model) {
		model.addAttribute("basicsData", basicsDataInfoService.findOne(id));
		return "basics/view";
	}
	
	@RequiresPermissions("BasicsData:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBasicsData(@PathVariable Long id){
		try {
			basicsDataInfoService.delete(id);
			return AjaxObject.newOk("删除成功").setNavTabId("BasicsData_165").setCallbackType("BasicsData_165").toString();
		}catch (Exception e) {
			return AjaxObject.newError("删除失败:" + e.getMessage()).toString();
		}
	}
	
}
