package com.lh.it.resource.common.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;
import com.lh.it.resource.common.service.IndustrySkillsService;
import com.lh.it.resource.common.service.SkillsService;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;

@Controller
@RequestMapping("/industryskills")
public class IndustrySkillsController {
	
	@Autowired
	private IndustrySkillsService industrySkillsService;
	
	@Autowired
	private SkillsService skillsService;
	
	/**
	 * 后台招聘选择技能
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/industrySkillsInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String lists(@PathVariable("id") String id, Model model) {
		List<FunctionInfo> orgaList = industrySkillsService.findAll();
		model.addAttribute("jsonTree", FunctionInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("parentId", FunctionInfo.ROOT_NODE_ID);
		model.addAttribute("recruitId", id);
		model.addAttribute("nodeList", industrySkillsService.findByParen(FunctionInfo.ROOT_NODE_ID));
		return "commonality/skills/list";
	}
	
	/**
	 * 后台招聘的技能选择
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/{sid}/skillpoint", method = RequestMethod.GET)
	public Object skill(@PathVariable("id") Long id, @PathVariable("sid") String sid, Model model) {
		FunctionInfo industrySkillsInfo = new FunctionInfo();
		industrySkillsInfo.setId(id);
		List<FunctionInfo> industrySkillsInfos = industrySkillsService.findByParent(industrySkillsInfo);
		Map map = new HashMap();
		for (int i = 0; i < industrySkillsInfos.size(); i++) {
			List<SkillsInfo> skillsInfos = skillsService.findByIndustrySkillsInfo(industrySkillsInfos.get(i));
			map.put(i, skillsInfos);
		}
		model.addAttribute("map", map);
		model.addAttribute("sid", sid);
		model.addAttribute("id", id);
		return "commonality/skills/skillsInfo_create";
	}
	
	/**
	 * 后台招聘选择技能
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{level}/lookup", method = { RequestMethod.GET, RequestMethod.POST })
	public String lists(@PathVariable Integer level, Model model) {
		List<FunctionInfo> orgaList = industrySkillsService.findAll(level);
		model.addAttribute("jsonTree", FunctionInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("parentId", FunctionInfo.ROOT_NODE_ID);
		model.addAttribute("nodeList", industrySkillsService.findByParen(FunctionInfo.ROOT_NODE_ID));
		return "commonality/skills/lookup";
	}
	
	/**
	 * 后台招聘的技能选择
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
	public Object detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("info", industrySkillsService.findByParent(id));
		return "commonality/skills/skillsInfo_detail";
	}
	
	/**
	 * 后台招聘的技能选择
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/{sid}/detail", method = RequestMethod.GET)
	public Object detail(@PathVariable("id") Long id, @PathVariable("sid") String sid, Model model) {
		model.addAttribute("info", industrySkillsService.findOne(id));
		return "commonality/skills/skillsInfo_detail";
	}
}
