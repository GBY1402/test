package com.lh.it.resource.core.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lh.it.resource.core.entity.EducationType;
import com.lh.it.resource.core.entity.Employee;
import com.lh.it.resource.core.entity.RecruitmentChannelType;
import com.lh.it.resource.core.entity.StateType;
import com.lh.it.resource.core.service.EmployeeService;
import com.lh.it.resource.core.util.ViewExcel;
import com.lh.it.resource.core.vo.EmployeeVo;
import com.lh.it.resource.security.entity.main.Organization;
import com.lh.it.resource.security.service.OrganizationService;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.dwz.AjaxObject;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private OrganizationService organizationService;

	/**
	 * 招聘渠道
	 * 
	 * @return
	 */
	@ModelAttribute("types")
	public RecruitmentChannelType[] recruitmentChannelType() {
		return RecruitmentChannelType.values();
	}

	/**
	 * 公司人员状态
	 * 
	 * @return
	 */
	@ModelAttribute("stateTypes")
	public StateType[] stateType() {
		return StateType.values();
	}

	/**
	 * 员工学历
	 * 
	 * @return
	 */
	@ModelAttribute("edtypes")
	public EducationType[] educationTypes() {
		return EducationType.values();
	}

	/**
	 * 员工信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:view")
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String list(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			ServletRequest request, Model model) {
		
		Specification<Employee> spec = DynamicSpecifications.bySearchFilter(request, Employee.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(Direction.DESC, "createDateTime"));
		
		model.addAttribute("page", employeeService.findPage(spec, pageable));
		
		return "employee/list";
	}

	/**
	 * 导出Excel
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:download")
	@RequestMapping("download")
	public ModelAndView viewExcel(HttpServletRequest request,
			HttpServletResponse response,EmployeeVo empl,Organization organization) {
		
		//根据参数查询导出记录
		Map<String, Iterable<Employee>> model = new HashMap<String, Iterable<Employee>>();
		model.put("list", employeeService.findEmployeeByQuery(empl));
		model.get("list");

		return new ModelAndView(new ViewExcel(), model);
	}


	/**
	 * 新增页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createJump(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/create";
	}

	/**
	 * 新增功能
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Object create(Employee employee,RedirectAttributes redirectAttributes) {
		
		try {
			employeeService.saveEmployee(employee);
		} catch (Exception e) {
			return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
		}

		return AjaxObject.newOk("新增成功").setNavTabId("empl_67").toString();
	}

	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("empl:edit")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateJump(@PathVariable("id") String id, Model model) {
		model.addAttribute("employee", employeeService.findEmployeeById(id));
		return "employee/update";
	}

	/**
	 * 修改功能
	 * 
	 * @param employee
	 * @return
	 */
	@RequiresPermissions("empl:edit")
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(Employee employee) {
			employeeService.updateEmployee(employee);
		return AjaxObject.newOk("修改成功").setNavTabId("empl_67").toString();
	}
	
	@RequiresPermissions("empl:view")
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String view(@PathVariable("id") String id, Model model) {
		model.addAttribute("employee", employeeService.findEmployeeById(id));
		return "employee/view";
	}

	/**
	 * 获取所有员工信息，用于弹出框查找带回
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param model
	 * @return
	 */
	/*@RequiresPermissions("empl:view")*/
	@RequestMapping(value = "/lookup")
	public String showLookup(
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize,
			Model model, ServletRequest request) {
		
		Specification<Employee> spec = DynamicSpecifications.bySearchFilter(request, Employee.class);
		Pageable pageable = new PageRequest(pageNumber-1, pageSize, new Sort(
				Direction.DESC, "name"));
		model.addAttribute("page", employeeService.findPage(spec, pageable));
		return "employee/lookup";
	}
	
	@RequiresPermissions(value={"empl:edit", "empl:save"}, logical=Logical.OR)
	@RequestMapping(value="/lookupOrga/{id}", method={RequestMethod.GET})
	public String lookup(@PathVariable Long id, Map<String, Object> map) {
		Organization organization  = organizationService.getTree();
		
		map.put("organization", organization);
		return "employee/lookup_orga";
	}
}
