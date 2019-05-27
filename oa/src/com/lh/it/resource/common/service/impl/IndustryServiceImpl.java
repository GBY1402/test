package com.lh.it.resource.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lh.it.resource.common.dao.IndustryDAO;
import com.lh.it.resource.common.dao.SkillsDAO;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.SkillsInfo;
import com.lh.it.resource.common.service.IndustryService;
@Service
public class IndustryServiceImpl implements IndustryService{

	@Autowired
	private IndustryDAO industryDAO ;
	
	@Autowired
	private SkillsDAO skillsDao;

	@Override
	public List<FunctionInfo> findByParen(Long rootNodeId) {
		FunctionInfo functionInfo =new FunctionInfo();
		functionInfo.setId(rootNodeId);
		return industryDAO.findByParent(functionInfo);
	}

	@Override
	public List<FunctionInfo> findAll() {
		return (List<FunctionInfo>) industryDAO.findAll();
	}

	@Override
	public void update(FunctionInfo functionInfo) {
		industryDAO.save(functionInfo);
	}

	@Override
	public FunctionInfo findOne(Long id) {
		return industryDAO.findOne(id);
	}

	@Override
	public void delete(Long id) {
		industryDAO.delete(id);
	}
	//删除
	@Override
	public void inster(FunctionInfo beas) {
		// TODO Auto-generated method stub
		industryDAO.save(beas);
	}

	@Override
	public List<FunctionInfo> generatorSkill(Integer level) {
		List<FunctionInfo> functionInfoList = industryDAO.findByLevel(4);
		List<SkillsInfo> skillsList = Lists.newArrayList();
		for (FunctionInfo info : functionInfoList) {
			SkillsInfo skillsInfo1 = new SkillsInfo();
			skillsInfo1.setFunctionInfo(info);
			skillsInfo1.setsName("初级");
			skillsInfo1.setsValue("1");
			SkillsInfo skillsInfo2 = new SkillsInfo();
			skillsInfo2.setFunctionInfo(info);
			skillsInfo2.setsName("中级");
			skillsInfo2.setsValue("2");
			SkillsInfo skillsInfo3 = new SkillsInfo();
			skillsInfo3.setFunctionInfo(info);
			skillsInfo3.setsName("高级");
			skillsInfo3.setsValue("3");
			skillsList.add(skillsInfo1);
			skillsList.add(skillsInfo2);
			skillsList.add(skillsInfo3);
		}
		skillsDao.deleteAll();
		skillsDao.save(skillsList);
		return null;
	}

	@Override
	public void save(FunctionInfo functionInfo) {
		functionInfo = industryDAO.save(functionInfo);
		if(functionInfo.getLevel().intValue() == 4){
			List<SkillsInfo> skillsList = Lists.newArrayList();
			SkillsInfo skillsInfo1 = new SkillsInfo();
			skillsInfo1.setFunctionInfo(functionInfo);
			skillsInfo1.setsName("初级");
			skillsInfo1.setsValue("1");
			SkillsInfo skillsInfo2 = new SkillsInfo();
			skillsInfo2.setFunctionInfo(functionInfo);
			skillsInfo2.setsName("中级");
			skillsInfo2.setsValue("2");
			SkillsInfo skillsInfo3 = new SkillsInfo();
			skillsInfo3.setFunctionInfo(functionInfo);
			skillsInfo3.setsName("高级");
			skillsInfo3.setsValue("3");
			skillsList.add(skillsInfo1);
			skillsList.add(skillsInfo2);
			skillsList.add(skillsInfo3);
			skillsDao.save(skillsList);
		}
	}

}
