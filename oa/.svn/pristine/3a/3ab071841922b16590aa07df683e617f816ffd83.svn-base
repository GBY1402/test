package com.lh.it.resource.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.lh.it.resource.common.dao.SkillsDAO;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;
import com.lh.it.resource.common.service.SkillsService;
@Service
public class skillsServiceImpl implements SkillsService{
	
	@Autowired
	private SkillsDAO skillsDAO;

	@Override
	public List<SkillsInfo> findByIndustrySkillsInfo(FunctionInfo functionInfo) {
		return skillsDAO.findByFunctionInfo(functionInfo);
	}

	@Override
	public Page<SkillsInfo> finAll(Pageable pageable) {
		return skillsDAO.findAll(pageable);
	}

	@Override
	public void update(SkillsInfo skillsInfo) {
		skillsDAO.save(skillsInfo);
	}

	@Override
	public SkillsInfo findOne(String id) {
		return skillsDAO.findOne(id);
	}

	@Override
	public void delete(String id) {
		skillsDAO.delete(id);
	}

	@Override
	public Page<SkillsInfo> findPage(Specification<SkillsInfo> spec, Pageable pageable) {
		return skillsDAO.findAll(spec, pageable);
	}

}
