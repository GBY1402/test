package com.lh.it.resource.common.web.controller;

import java.util.List;

import javax.sound.midi.MidiDevice.Info;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;
import com.lh.it.resource.common.service.IndustryService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

@Controller
@RequestMapping("/industry")
public class IndustryController {
	 
	@Autowired
	private IndustryService industryService;
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<FunctionInfo> orgaList = industryService.findAll();
		model.addAttribute("jsonTree",FunctionInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("parentId", FunctionInfo.ROOT_NODE_ID);
		model.addAttribute("nodeList", industryService.findByParen(FunctionInfo.ROOT_NODE_ID));
		return "commonality/industrskill/list";
	}
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(value = "/findchild")
	public String findChild(@RequestParam("eId") Long eId, Model model) {
		model.addAttribute("nodeList", industryService.findByParen(eId));
		model.addAttribute("parentId",eId);
		return "commonality/industrskill/childlist";
	}
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(value = "/lookupTree", method = RequestMethod.GET)
	public String showTree(Model model) {
		List<FunctionInfo> areaList = industryService.findAll();
		model.addAttribute("jsonTree",FunctionInfo.toJsonStr(areaList.iterator()));
//		FunctionInfo rootNode = FunctionInfo.getRootNode();
//		model.addAttribute("rootNode", rootNode);
		return "commonality/industrskill/lookupTree";
	}
	
	@RequiresPermissions("Industry:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@CurrentUser User loginUser,FunctionInfo functionInfo) {
		industryService.update(functionInfo);
		return AjaxObject.newOk("修改成功");
	}

	@RequiresPermissions("Industry:edit")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("representativeInfo", industryService.findOne(id));
		return "commonality/industrskill/edit";
	}
	
	@RequiresPermissions("Industry:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Object save(@CurrentUser User loginUser,FunctionInfo functionInfo) {
		if(functionInfo.getParent().getLevel() == 4)
			return AjaxObject.newError("节点最多为4级");
		functionInfo.setLevel(functionInfo.getParent().getLevel() + 1);
		industryService.save(functionInfo);
		return AjaxObject.newOk("新增成功");
	}

	@RequiresPermissions("Industry:save")
	@RequestMapping(value = "/{parentId}/save", method = RequestMethod.GET)
	public String showSaveChildForm(@PathVariable("parentId") Long parentId,
			Model model) {
		model.addAttribute("parent", industryService.findOne(parentId));
		return "commonality/industrskill/create";
	}

	@RequiresPermissions("Industry:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(@PathVariable("id") Long id) {
		try {
			industryService.delete(id);
			return AjaxObject.newOk("删除成功").setNavTabId("Industry_156").setCallbackType("Industry_156").toString();
		} catch (RuntimeException ex) {
			return AjaxObject.newError(ex.getMessage()).setCallbackType("");
		} catch (Exception ex) {
//			LOG.error("Delete equipment id : " + id, ex);
			return AjaxObject.newError("删除失败！").setCallbackType("");
		}
	}
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("industrySkillsInfo", industryService.findOne(id));
		return "commonality/industrskill/view";
	}
	
	/**
	 * 生成技能
	 * @return
	 */
	@RequestMapping(value = "generator", method = RequestMethod.POST)
	@ResponseBody
	public String generatorSkill(){
		industryService.generatorSkill(4);
		return AjaxObject.newOk("生成技能成功").setNavTabId("Industry_156").setCallbackType("Industry_156").toString();
	}
	
}
