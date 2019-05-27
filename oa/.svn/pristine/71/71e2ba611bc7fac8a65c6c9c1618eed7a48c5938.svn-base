package com.lh.it.resource.common.web.controller;

import java.util.List;

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
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;
import com.lh.it.resource.common.service.IndustryService;
import com.lh.it.resource.common.service.SkillsService;
import com.lh.it.resource.person.entity.HumanBasicInfo;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

@Controller
@RequestMapping("/skills")
public class SkillsController {
	 
	@Autowired
	private IndustryService industryService;
	
	@Autowired
	private SkillsService skillsService;
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		List<FunctionInfo> orgaList = industryService.findAll();
		model.addAttribute("jsonTree",FunctionInfo.toJsonStr(orgaList.iterator()));
		model.addAttribute("id", FunctionInfo.ROOT_NODE_ID);
		model.addAttribute("nodeList", skillsService.findByIndustrySkillsInfo(orgaList.get(0)));
		return "commonality/beasSkill/list";
	}
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(value = "/findchild")
	public String findChild(@RequestParam("eId") Long eId, Model model) {
		FunctionInfo functionInfo=new FunctionInfo();
		functionInfo.setId(eId);
		model.addAttribute("nodeList", skillsService.findByIndustrySkillsInfo(functionInfo));
		model.addAttribute("id",eId);
		return "commonality/beasSkill/childlist";
	}
	
	@RequiresPermissions("Industry:view")
	@RequestMapping(value = "/lookupTree", method = RequestMethod.GET)
	public String showTree(Model model) {
		List<FunctionInfo> areaList = industryService.findAll();
		model.addAttribute("jsonTree",FunctionInfo.toJsonStr(areaList.iterator()));
//		FunctionInfo rootNode = FunctionInfo.getRootNode();
//		model.addAttribute("rootNode", rootNode);
		return "commonality/beasSkill/lookupTree";
	}
	
	@RequiresPermissions("Industry:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(@CurrentUser User loginUser,SkillsInfo skillsInfo) {
		skillsService.update(skillsInfo);
		return AjaxObject.newOk("修改成功");
	}

	@RequiresPermissions("Industry:edit")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
		model.addAttribute("skillsInfo", skillsService.findOne(id));
		return "commonality/beasSkill/edit";
	}
	
	@RequiresPermissions("Industry:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Object save(@CurrentUser User loginUser,SkillsInfo skillsInfo) {
		skillsService.update(skillsInfo);
		return AjaxObject.newOk("新增成功");
	}

	@RequiresPermissions("Industry:save")
	@RequestMapping(value = "/{parentId}/save", method = RequestMethod.GET)
	public String showSaveChildForm(@PathVariable("parentId") Long parentId,
			Model model) {
		model.addAttribute("parent", industryService.findOne(parentId));
		return "commonality/beasSkill/create";
	}

	@RequiresPermissions("Industry:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(@PathVariable("id") String id) {
		try {
			skillsService.delete(id);
			return AjaxObject.newOk("删除成功").setCallbackType("Industry_156").toString();
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
		return "commonality/beasSkill/view";
	}
	
	/**
	 * 查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/skillsLookup",method={RequestMethod.GET, RequestMethod.POST})
	public  String personLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<SkillsInfo> spec = DynamicSpecifications.bySearchFilter(request, SkillsInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize);
		model.addAttribute("page", skillsService.findPage(spec, pageable));
		return "commonality/skills/skillslookup";
	}
	
}
