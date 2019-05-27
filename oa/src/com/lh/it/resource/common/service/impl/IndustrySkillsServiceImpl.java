package com.lh.it.resource.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.lh.it.resource.security.util.dwz.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.lh.it.resource.common.dao.IndustrySkillsDAO;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.service.IndustrySkillsService;
import com.lh.it.resource.security.entity.main.Module;
import com.lh.it.resource.security.util.dwz.PageUtils;
@Service
public class IndustrySkillsServiceImpl implements IndustrySkillsService{
	
	@Autowired
	private IndustrySkillsDAO industrySkillsDAO;

	@Override
	public List<FunctionInfo> findAll() {
		return (List<FunctionInfo>) industrySkillsDAO.findAll();
	}

	@Override
	public FunctionInfo findByParen(Long rootNodeId) {
		FunctionInfo functionInfo =new FunctionInfo();
		functionInfo.setId(rootNodeId);
		List<FunctionInfo> list=industrySkillsDAO.findByParent(functionInfo);
		return list.get(0);
	}

	@Override
	public List<FunctionInfo> findByParent(FunctionInfo industrySkillsInfo) {
		return industrySkillsDAO.findByParent(industrySkillsInfo);
	}

	@Override
	public FunctionInfo findById() {
		return industrySkillsDAO.findOne((long) 0);
	}

	@Override
	public List<FunctionInfo> find(Long parentModuleId, String keywords, Page page) {
		org.springframework.data.domain.Page<FunctionInfo> springDataPage = 
				industrySkillsDAO.findByParentIdAndNameContaining(parentModuleId, keywords, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<FunctionInfo> find(Long parentModuleId, Page page) {
		org.springframework.data.domain.Page<FunctionInfo> springDataPage = 
				industrySkillsDAO.findByParentId(parentModuleId, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public org.springframework.data.domain.Page<FunctionInfo> findPage(FunctionInfo industrySkillsInfo,
			Pageable pageable) {
		return industrySkillsDAO.findByParent(industrySkillsInfo, pageable);
	}

	@Override
	public void inster(FunctionInfo functionInfo) {
		FunctionInfo FunctionInfo =new FunctionInfo();
		FunctionInfo.setLevel(1);
		FunctionInfo.setName(functionInfo.getName());
		FunctionInfo.setDescription(functionInfo.getName());
		FunctionInfo FunctionInfoone=industrySkillsDAO.save(FunctionInfo);
		for(FunctionInfo FunctionInfotow:functionInfo.getChildInSk()) {
			FunctionInfotow.setParent(FunctionInfoone);
			FunctionInfo backFunctionInfotow=industrySkillsDAO.save(FunctionInfotow);
			for(FunctionInfo FunctionInfotree:FunctionInfotow.getChildInSk()) {
				FunctionInfotree.setParent(backFunctionInfotow);
				FunctionInfo backFunctionInfotree=industrySkillsDAO.save(FunctionInfotree);
				for(FunctionInfo FunctionInfozui:backFunctionInfotree.getChildInSk()) {
					FunctionInfozui.setParent(backFunctionInfotree);
					industrySkillsDAO.save(FunctionInfozui);
				}
			}
			
		}
	}

	@Override
	public List<FunctionInfo> findByid(Long i) {
		FunctionInfo functionInfo =new FunctionInfo();
		functionInfo.setId(i);
		return industrySkillsDAO.findByParent(functionInfo);
	}

	@Override
	public FunctionInfo findOne(Long id) {
		return industrySkillsDAO.findOne(id);
	}

	@Override
	public List<FunctionInfo> findAll(Integer level) {
		return industrySkillsDAO.findAll(level);
	}

	@Override
	public List<FunctionInfo> findByParent(Long parentId) {
		return industrySkillsDAO.findByParent(parentId);
	}



}
