package com.lh.it.resource.person.web.controller;
import java.util.Date;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lh.it.resource.apk.web.controller.test;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.service.BasicsDataInfoService;
import com.lh.it.resource.common.service.IndustrySkillsService;
import com.lh.it.resource.person.entity.PersonJobInfo;
import com.lh.it.resource.person.entity.PersonJobProjectInfo;
import com.lh.it.resource.person.entity.PersonJobResumeInfo;
import com.lh.it.resource.person.entity.PersonJobSkillInfo;
import com.lh.it.resource.person.entity.PersonJobTrainInfo;
import com.lh.it.resource.person.entity.RecruitSkillVO;
import com.lh.it.resource.person.service.PersonJobInfoService;
import com.lh.it.resource.person.service.PersonJobSkillInfoService;
import com.lh.it.resource.person.service.PersonResumeService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;
/**
 * 个人简历view控制层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/resume")
public class PersonResumeController {

	@Autowired
	private PersonJobInfoService personJobInfoService;
	
	@Autowired
	private PersonResumeService personResumeService;
	
	@Autowired
	private BasicsDataInfoService basicsDataInfoService;
	
	@Autowired
	private IndustrySkillsService industrySkillsService;
	
	@Autowired
	private PersonJobSkillInfoService personJobSkillInfoService;
	

	/**
	 * 账号信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		Specification<PersonJobInfo> spec = DynamicSpecifications.bySearchFilter(request, PersonJobInfo.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", personResumeService.findPage(spec, pageable));
		model.addAttribute("humanId", request.getParameter("humanId"));
		return "person/resume/list";
	}
	
	
	/**
	 * 添加工作经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{personJobId}/showResumeWorkAdd", method = RequestMethod.GET)
	public String createWorks(@PathVariable("personJobId") String personJobId,Model model) {
		model.addAttribute("basicsDataInfo",basicsDataInfoService.findByParent((long) 37));
		return "person/resume/workcreate";
	}
	
	/**
	 * 添加工作经验功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeWorkAdd", method = RequestMethod.POST)
	public @ResponseBody Object createWorks(PersonJobResumeInfo personJobResumeInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobResumeInfo.setCreateTime(new Date());
		personJobResumeInfo.setCreateUser(loginUser.getUsername());
		personJobResumeInfo.setUpdateTime(new Date());
		personJobResumeInfo.setUpdateUser(loginUser.getUsername());
		personJobResumeInfo.setDeleteBasic(0);
		personResumeService.insterWorks(personJobResumeInfo);
		return AjaxObject.newOk("添加工作经验成功！").toString();
	}
	
	/**
	 * 修改工作经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{resumeId}/showResumeWorkUpdate", method = RequestMethod.GET)
	public String updateWorks(@PathVariable("resumeId") String resumeId,Model model) {
		model.addAttribute("personJobResumeInfo",personResumeService.findPersonJobResumeInfoById(resumeId));
		model.addAttribute("basicsDataInfo",basicsDataInfoService.findByParent((long) 37));
		return "person/resume/workupdate";
	}
	
	/**
	 * 修改工作经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeWorkUpdate", method = RequestMethod.POST)
	public @ResponseBody Object updateWorks(PersonJobResumeInfo personJobResumeInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobResumeInfo.setUpdateTime(new Date());
		personJobResumeInfo.setUpdateUser(loginUser.getUsername());
		return AjaxObject.newOk("修改工作经验成功！").toString();
	}
	
	
	/**
	 * 删除工作经验页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:delete")
	@RequestMapping(value = "/{resumeId}/resumeWorkDel", method = RequestMethod.POST)
	public @ResponseBody Object createWorks(@PathVariable("resumeId") String resumeId,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		PersonJobResumeInfo personJobResumeInfo = personResumeService.findPersonJobResumeInfoById(resumeId);
		personResumeService.deletePersonJobResume(personJobResumeInfo);
		return AjaxObject.newOk("删除工作经验成功！").toString();
	}
	
	/**
	 * 添加教育经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{personJobId}/showResumeTrainingAdd", method = RequestMethod.GET)
	public String showResumeTrainingAdd(@PathVariable("personJobId") String personJobId,Model model) {
		model.addAttribute("personJobId",personJobId);
		return "person/resume/trainingcreate";
	}
	
	/**
	 * 添加教育经验功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeTrainingAdd", method = RequestMethod.POST)
	public @ResponseBody Object showResumeTrainingAdd(PersonJobTrainInfo personJobTrainInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobTrainInfo.setCreateTime(new Date());
		personJobTrainInfo.setCreateUser(loginUser.getUsername());
		personJobTrainInfo.setUpdateTime(new Date());
		personJobTrainInfo.setUpdateUser(loginUser.getUsername());
		personJobTrainInfo.setTrainDelete(0);
		personResumeService.insterTrainInfo(personJobTrainInfo);
		return AjaxObject.newOk("添加工作经验成功！").toString();
	}
	
	/**
	 * 修改教育经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{trainId}/showResumeTrainingUpdate", method = RequestMethod.GET)
	public String updateTraining(@PathVariable("trainId") String trainId,Model model) {
		model.addAttribute("personJobTrainInfo",personResumeService.findPersonJobTrainInfoById(trainId));
		model.addAttribute("basicsDataInfo",basicsDataInfoService.findByParent((long) 37));
		return "person/resume/trainingupdate";
	}
	
	/**
	 * 修改教育经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeTrainingUpdate", method = RequestMethod.POST)
	public @ResponseBody Object updateTraining(PersonJobTrainInfo personJobTrainInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobTrainInfo.setUpdateTime(new Date());
		personJobTrainInfo.setUpdateUser(loginUser.getUsername());
		return AjaxObject.newOk("修改工作经验成功！").toString();
	}
	
	
	/**
	 * 删除教育经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:delete")
	@RequestMapping(value = "/{trainId}/resumeTrainingDel", method = RequestMethod.POST)
	public @ResponseBody Object resumeTrainingDel(@PathVariable("trainId") String trainId,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personResumeService.deleteTraining(trainId,loginUser);
		return AjaxObject.newOk("删除教育经历成功！").toString();
	}
	
	/**
	 * 添加项目经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{personJobId}/showResumeProjectAdd", method = RequestMethod.GET)
	public String showResumeProjectAdd(@PathVariable("personJobId") String personJobId,Model model) {
		model.addAttribute("personJobId",personJobId);
		return "person/resume/projectcreate";
	}
	
	/**
	 * 添加个人技能页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{personJobId}/showResumeSkillsAdd", method = RequestMethod.GET)
	public String showResumeSkillsAdd(@PathVariable("personJobId") String personJobId, Model model) {
		model.addAttribute("personJobId",personJobId);
		return "person/resume/skillscreate";
	}
	
	/**
	 * 添加个人技能
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/resumeSkillsAdd", method = RequestMethod.POST)
	@ResponseBody
	public String resumeSkillsAdd(@CurrentUser User loginUser, PersonJobSkillInfo personJobSkillInfo){
		personJobSkillInfo.setCreateName(loginUser.getUsername());
		personJobSkillInfo.setCreateTime(new Date());
		personJobSkillInfoService.save(personJobSkillInfo);
		return AjaxObject.newOk("添加成功").toString();
	}
	
	/**
	 * 添加项目经验功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeProjectAdd", method = RequestMethod.POST)
	public @ResponseBody Object showResumeProjectAdd(PersonJobProjectInfo personJobProjectInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobProjectInfo.setCreateTime(new Date());
		personJobProjectInfo.setCreateUser(loginUser.getUsername());
		personJobProjectInfo.setUpdateTime(new Date());
		personJobProjectInfo.setUpdateUser(loginUser.getUsername());
		personJobProjectInfo.setProjectDelete(0);
		personResumeService.insterProject(personJobProjectInfo);
		return AjaxObject.newOk("添加工作经验成功！").toString();
	}
	
	/**
	 * 修改项目经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/{projectId}/showResumeProjectUpdate", method = RequestMethod.GET)
	public String showResumeProjectUpdate(@PathVariable("projectId") String projectId,Model model) {
		model.addAttribute("personJobProjectInfo",personResumeService.findPersonJobProjectInfoById(projectId));
		return "person/resume/projectupdate";
	}
	
	/**
	 * 修改项目经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:edit")
	@RequestMapping(value = "/showResumeProjectUpdate", method = RequestMethod.POST)
	public @ResponseBody Object showResumeProjectUpdate(PersonJobProjectInfo personJobProjectInfo,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personJobProjectInfo.setUpdateTime(new Date());
		personJobProjectInfo.setUpdateUser(loginUser.getUsername());
		personResumeService.insterProject(personJobProjectInfo);
		return AjaxObject.newOk("修改工作经验成功！").toString();
	}
	
	
	/**
	 * 删除项目经验页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:delete")
	@RequestMapping(value = "/{projectId}/resumeProjectDel", method = RequestMethod.POST)
	public @ResponseBody Object resumeProjectDel(@PathVariable("projectId") String projectId,@CurrentUser User loginUser
			,RedirectAttributes redirectAttributes) {
		personResumeService.delete(projectId,loginUser);
		return AjaxObject.newOk("删除项目经验成功！").toString();
	}
	

	/**
	 * 添加页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createJump(Model model) {
		return "person/resume/resumeName_create";
	}
	
	/**
	 * 添加简历
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object createResume(@CurrentUser User loginUser, PersonJobInfo personJobInfo) {
		PersonJobInfo info = personJobInfoService.findByHumanBasicInfo(personJobInfo.getHumanBasicInfo().getHumanId());
		if(null != info)
			return AjaxObject.newError("添加失败！<br/>该用户已经有简历了");
		personJobInfo.setCreateTime(new Date());
		personJobInfo.setCreateUser(loginUser.getUsername());
		personJobInfoService.save(personJobInfo);
		return AjaxObject.newOk("添加成功").toString();
	}
	
	
	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/{personJobId}/update", method = {RequestMethod.GET,RequestMethod.POST})
	public String updateJump(@PathVariable("personJobId") String personJobId, Model model) {
		model.addAttribute("personJobInfo",personResumeService.findById(personJobId));
		return "person/resume/update";
	}
	
	/**
	 * 修改简历主信息跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/{personJobId}/showResumeBasicUpdate", method = RequestMethod.GET)
	public String showResumeBasicUpdate(@PathVariable("personJobId") String personJobId, Model model) {
		model.addAttribute("personJobInfo",personResumeService.findById(personJobId));
		model.addAttribute("basicsDataInfo",basicsDataInfoService.findByParent((long) 37));
		return "person/resume/resumeBasic_update";
	}
	
	/**
	 * 修改简历主信息
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/resumeBasicUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Object showResumeBasicUpdate(@CurrentUser User loginUser, PersonJobInfo personJobInfo) {
		personJobInfo.setUpdateUser(loginUser.getUsername());
		personJobInfo.setUpdateTime(new Date());
		if(personJobInfo.getPersonIndustry() == null){
			personJobInfo.setPersonIndustry(new FunctionInfo());
		}
		personJobInfo.getPersonIndustry().setId(personJobInfo.getPersonFunction().getParent().getId());
		personJobInfoService.save(personJobInfo);
		return AjaxObject.newOk("修改成功").toString();
	}
	
	/**
	 * 添加技能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/skillpoint", method = RequestMethod.POST)
	public @ResponseBody Object skillpoint(@RequestParam("ids")String ids,@RequestParam("id")Long id,
			RecruitSkillVO list, Model model,@CurrentUser User loginUser) {
		PersonJobInfo personJobInfo=personResumeService.findById(ids);
		FunctionInfo functionInfo=industrySkillsService.findByParen(id);
		personJobInfo.setPersonFunction(functionInfo);
		personJobInfo.setPersonIndustry(functionInfo.getParent());
		personResumeService.insterPersonJobInfo(personJobInfo,loginUser);
		PersonJobSkillInfo personJobSkillInfo =new PersonJobSkillInfo();
		List<PersonJobSkillInfo> listSkill=personJobSkillInfoService.findBypersonJobSkillInfo(personJobInfo);
		for(int i=0;i<list.getSkillsInfos().size();i++) {
			if(listSkill.size()>=0) {
			personJobSkillInfoService.deleteList(listSkill);
			}
			personJobSkillInfo.setPersonSkillId(null);
			personJobSkillInfo.setSkillsInfo(list.getSkillsInfos().get(i));
			personJobSkillInfo.setPersonJobInfo(personJobInfo);
			personJobSkillInfo.setCreateName(loginUser.getUsername());
			personJobSkillInfo.setCreateTime(new Date());
			personJobSkillInfoService.inster(personJobSkillInfo);
		}
		return AjaxObject.newOk("新增成功").setNavTabId("Resume_105").toString();
	}
	
	/**
	 * 删除简历
	 * @param id
	 * @return
	 */
	@RequiresPermissions("Resume:delete")
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object showResumeBasicUpdate(@PathVariable String id) {
		PersonJobInfo personJobInfo = personJobInfoService.findOne(id);
		if(null == personJobInfo)
			return AjaxObject.newError("简历不存在");
		personJobInfoService.delete(personJobInfo);
		return AjaxObject.newOk("删除成功").setCallbackType("PResume_154").toString();
	}
	
	/**
	 * 删除技能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("PResume:delete")
	@RequestMapping(value = "/{personSkillId}/skillsDel", method = RequestMethod.POST)
	public @ResponseBody Object skillsDel(@PathVariable("personSkillId") String personSkillId) {
		personJobSkillInfoService.delete(personSkillId);
		return AjaxObject.newOk("删除技能成功！").toString();
	}
	
	/**
	 * 查看简历详情
	 * @param personJobId
	 * @return
	 */
	@RequiresPermissions("PResume:view")
	@RequestMapping(value = "/{personJobId}/view", method = RequestMethod.GET)
	public Object viewResume(@PathVariable String personJobId, Model model){
		model.addAttribute("personJobInfo",personResumeService.findById(personJobId));
		return "person/resume/view";
	}
	
}
