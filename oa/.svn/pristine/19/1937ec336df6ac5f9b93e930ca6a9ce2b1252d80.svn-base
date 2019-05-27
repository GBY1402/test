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
import org.springframework.web.multipart.MultipartFile;

import com.lh.it.resource.core.Constants;
import com.lh.it.resource.person.entity.PersonBoleInfo;
import com.lh.it.resource.person.service.BoleInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.OssUtil;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

import sun.misc.BASE64Encoder;

/**
 * 伯乐控制层
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/bole")
public class BoleInfoController {

	@Autowired
	private BoleInfoService boleInfoService;

	/**
	 * 账号信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Bole:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<PersonBoleInfo> spec = DynamicSpecifications.bySearchFilter(request, PersonBoleInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("page", boleInfoService.findPage(spec, pageable));
		return "person/bole/list";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Bole:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createJump(Model model) {
		// model.addAttribute("basicsDataInfo",basicsDataInfoService.findByParent((long)
		// 2));
		return "person/bole/create";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Bole:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object createJump(@RequestParam MultipartFile image, @CurrentUser User loginUser,
			PersonBoleInfo personBoleInfo, Model model) {
		try {
			boleInfoService.inseter(image, loginUser, personBoleInfo);
		} catch (Exception e) {
			return AjaxObject.newError("上传图片失败！");
		}
		return AjaxObject.newOk("添加用户成功！").toString();
	}

	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Bole:edit")
	@RequestMapping(value = "/{boleId}/update", method = RequestMethod.GET)
	public String updateJump(@PathVariable("boleId") String boleId, Model model) {
		model.addAttribute("personBoleInfo", boleInfoService.findOne(boleId));
		return "person/bole/update";
	}

}
