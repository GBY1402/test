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

import com.lh.it.resource.common.entity.RegionAllInfo;
import com.lh.it.resource.common.service.RegionAllInfoService;
import com.lh.it.resource.utils.dwz.AjaxObject;

/**
 * @description 省市乡县数据管理
 * 
 * @author lvyao
 */
@Controller
@RequestMapping("/region")
public class RegionAllInfoController {

	@Autowired
	private RegionAllInfoService regionAllInfoService;
	
	/**
	 * @description 列表
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Region:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<RegionAllInfo> orgaList = regionAllInfoService.findAll();
		model.addAttribute("jsonTree",RegionAllInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("parentId", RegionAllInfo.ROOT_NODE_ID);
		model.addAttribute("nodeList", regionAllInfoService.findByParent(RegionAllInfo.ROOT_NODE_ID));
		return "region/list";
	}
	
	/**
	 * @description 查询子节点数据
	 */
	@RequiresPermissions("Region:view")
	@RequestMapping(value = "/findChild")
	public String findChild(@RequestParam("eId") Long eId, Model model) {
		model.addAttribute("nodeList", regionAllInfoService.findByParent(eId));
		model.addAttribute("parentId",eId);
		return "region/childlist";
	}
	
	/**
	 * @description 跳转保存省市区县数据的页面
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Region:save")
	@RequestMapping(value = "/{pid}/save", method = RequestMethod.GET)
	public String saveRegion(@PathVariable Long pid, Model model){
		model.addAttribute("parent", regionAllInfoService.findOne(pid));
		return "region/save";
	}
	
	/**
	 * @description 保存省市区县数据
	 * @param regionAllInfo
	 * @return
	 */
	@RequiresPermissions("Region:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveRegion(RegionAllInfo regionAllInfo){
		regionAllInfo.setCreateTime(Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000)));
		regionAllInfoService.save(regionAllInfo);
		return AjaxObject.newOk("添加成功").setNavTabId("Region_168").toString();
	}
	
	/**
	 * @description 跳转更新省市区县数据的页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Region:edit")
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editRegion(@PathVariable Long id, Model model){
		model.addAttribute("region", regionAllInfoService.findOne(id));
		return "region/edit";
	}
	
	/**
	 * @description 更新省市区县的数据
	 * @param regionAllInfo
	 * @return
	 */
	@RequiresPermissions("Region:edit")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public String editRegion(RegionAllInfo regionAllInfo){
		regionAllInfo.setUpdateTime(Integer.parseInt(String.valueOf(System.currentTimeMillis() / 1000)));
		regionAllInfoService.save(regionAllInfo);
		return AjaxObject.newOk("修改成功").setNavTabId("Region_168").toString();
	}	
	
	/**
	 * @description 查看省市区县的数据
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Region:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String viewRegion(@PathVariable Long id, Model model){
		model.addAttribute("region", regionAllInfoService.findOne(id));
		return "region/view";
	}

	/**
	 * @description 删除省市区县的数据
	 * @param id
	 * @return
	 */
	@RequiresPermissions("Region:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteRegion(@PathVariable Long id){
		regionAllInfoService.delete(id);
		try {
			return AjaxObject.newOk("删除成功").setNavTabId("Region_168").setCallbackType("Region_168").toString();
		} catch (Exception e) {
			return AjaxObject.newError("删除失败：" + e.getMessage()).toString();
		}
	}
	
}
