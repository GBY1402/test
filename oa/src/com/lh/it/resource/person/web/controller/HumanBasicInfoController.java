package com.lh.it.resource.person.web.controller;

import java.util.Date;

import javax.jws.soap.SOAPBinding.Use;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lh.it.resource.common.entity.UserAddInfo;
import com.lh.it.resource.common.service.BasicsDataInfoService;
import com.lh.it.resource.common.service.UserAddInfoService;
import com.lh.it.resource.common.vo.UserAddInfoVO;
import com.lh.it.resource.core.Constants;
import com.lh.it.resource.person.entity.HumanBasicInfo;
import com.lh.it.resource.person.service.HumanBasicInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.security.util.persistence.DynamicSpecifications;
import com.lh.it.resource.utils.OssUtil;
import com.lh.it.resource.utils.dwz.AjaxObject;
import com.lh.it.resource.web.bind.annotation.CurrentUser;

import sun.misc.BASE64Encoder;

/**
 * 个人信息管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/person")
public class HumanBasicInfoController {

	@Autowired
	private HumanBasicInfoService humanBasicInfoService;

	@Autowired
	private BasicsDataInfoService basicsDataInfoService;

	@Autowired
	private UserAddInfoService userAddInfoService;

	/**
	 * 账号信息列表
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:view")
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, ServletRequest request,
			Model model) {
		Specification<HumanBasicInfo> spec = DynamicSpecifications.bySearchFilter(request, HumanBasicInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("humanDiploma", basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("page", humanBasicInfoService.findPage(spec, pageable));
		return "person/list";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createJump(Model model) {
		model.addAttribute("basicsDataInfo", basicsDataInfoService.findByParent((long) 2));
		return "person/create";
	}

	/**
	 * 查看页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:view")
	@RequestMapping(value = "/{personJobId}/view", method = RequestMethod.GET)
	public String createJump(@PathVariable("personJobId") String personJobId, Model model) {
		model.addAttribute("humanBasicInfo", humanBasicInfoService.findOne(personJobId));
		return "person/view";
	}

	/**
	 * 添加新用户
	 * 
	 * @param loginUser
	 * @param vo
	 * @return
	 */
	@RequiresPermissions("Resume:save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object createPerson(@CurrentUser User loginUser, UserAddInfoVO vo) {
		try {
			userAddInfoService.save(vo);
			return AjaxObject.newOk("添加成功").setNavTabId("Resume_153");
		} catch (Exception e) {
			return AjaxObject.newError(e.getMessage());
		}
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody Object createJump(@CurrentUser User loginUser, @RequestParam MultipartFile image,
			HumanBasicInfo humanBasicInfo, Model model) {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			if (image.getSize() > 0) {
				String imageStr = String.valueOf(encoder.encode(image.getBytes()));
				String BackimpagePathnew = OssUtil.uploadStuAvatar(imageStr, humanBasicInfo.getHumanImage(),
						Constants.RESUME_FILE_USER, image.getOriginalFilename());
				humanBasicInfo.setHumanImage(BackimpagePathnew);
			}
		} catch (Exception e) {
			return AjaxObject.newError("上传图片失败！");
		}
		humanBasicInfo.setCreateTime(new Date());
		humanBasicInfo.setCreateUser(loginUser.getUsername());
		humanBasicInfo.setUpdateTime(new Date());
		humanBasicInfo.setUpdateUser(loginUser.getUsername());
		humanBasicInfoService.inster(humanBasicInfo);
		return AjaxObject.newOk("添加用户成功！").toString();
	}

	/**
	 * 修改页面跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/{personJobId}/update", method = RequestMethod.GET)
	public String updateJump(@PathVariable("personJobId") String personJobId, Model model) {
		model.addAttribute("humanBasicInfo", humanBasicInfoService.findOne(personJobId));
		model.addAttribute("basicsDataInfo", basicsDataInfoService.findByParent((long) 2));
		return "person/update";
	}

	/**
	 * 修改
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object updateJump(@CurrentUser User loginUser, @RequestParam MultipartFile image,
			HumanBasicInfo humanBasicInfo, RedirectAttributes redirectAttributes) {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			if (image.getSize() > 0) {
				String imageStr = String.valueOf(encoder.encode(image.getBytes()));
				String BackimpagePathnew = OssUtil.uploadStuAvatar(imageStr, humanBasicInfo.getHumanImage(),
						Constants.RESUME_FILE_USER, image.getOriginalFilename());
				humanBasicInfo.setHumanImage(BackimpagePathnew);
			}
		} catch (Exception e) {
			return AjaxObject.newError("上传图片失败！");
		}
		humanBasicInfo.setUpdateTime(new Date());
		humanBasicInfo.setUpdateUser(loginUser.getUsername());
		humanBasicInfoService.inster(humanBasicInfo);
		return AjaxObject.newOk("修改用户成功！").toString();
	}

	/**
	 * 删除个人图片
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:edit")
	@RequestMapping(value = "/{personJobId}/deleteimage", method = RequestMethod.GET)
	@ResponseBody
	public Object deleteImage(@CurrentUser User loginUser, @PathVariable("personJobId") String personJobId,
			Model model) {
		HumanBasicInfo humanBasicInfo = humanBasicInfoService.findById(personJobId);
		humanBasicInfo.setHumanImage(null);
		humanBasicInfo.setUpdateTime(new Date());
		humanBasicInfo.setUpdateUser(loginUser.getUsername());
		humanBasicInfoService.inster(humanBasicInfo);
		return AjaxObject.newOk("删除图像成功！").toString();
	}

	/**
	 * 删除个人信息
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("Resume:delete")
	@RequestMapping(value = "/{personJobId}/delete", method = RequestMethod.POST)
	public @ResponseBody Object personDelete(@CurrentUser User loginUser,
			@PathVariable("personJobId") String personJobId, Model model) {
		// humanBasicInfoService.delete(personJobId);
		HumanBasicInfo humanBasicInfo = humanBasicInfoService.findById(personJobId);
		humanBasicInfo.setDeleteBasic(1);
		humanBasicInfo.setUpdateTime(new Date());
		humanBasicInfo.setUpdateUser(loginUser.getUsername());
		humanBasicInfo.getUserAddInfo().setUserDelete(1);
		humanBasicInfo.getUserAddInfo().setUpdateUser(loginUser.getUsername());
		humanBasicInfo.getUserAddInfo().setUpdateTime(new Date());
		humanBasicInfoService.inster(humanBasicInfo);
		return AjaxObject.newOk("删除成功").setCallbackType("");
	}

	/**
	 * 查找带回
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/personlookup", method = { RequestMethod.GET, RequestMethod.POST })
	public String personLookup(@RequestParam(value = "pageNum", defaultValue = "1") int pageNumber,
			@RequestParam(value = "numPerPage", defaultValue = "5") int pageSize, ServletRequest request, Model model) {
		Specification<HumanBasicInfo> spec = DynamicSpecifications.bySearchFilter(request, HumanBasicInfo.class);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "updateTime"));
		model.addAttribute("humanDiploma", basicsDataInfoService.findByParent((long) 2));
		model.addAttribute("page", humanBasicInfoService.findPage(spec, pageable));
		return "person/personlookup";
	}
}
