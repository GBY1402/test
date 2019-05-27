package com.lh.it.resource.common.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.google.common.collect.Lists;

/**
 * @version:
* @Description: 职能分类数据封装类
* @author: GBY
* @date: 2018年12月13日下午5:16:37
 */
@Entity
@Table(name = "FUNCTION_INFO")
public class FunctionInfo implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8024572922126416886L;

	public static final Long ROOT_NODE_ID = 1l;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FU_ID")
	private Long id;
	/**
	 * 名称
	 */
	@Column(name = "FU_NAME", length = 50)
	private String name;
	/**
	 * 描述
	 */
	@Column(name = "DESCRIPTION", length = 255)
	private String description;
	/**
	 * 自关联（树形数据存储方式）
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private FunctionInfo parent;
	/**
	 * 等级
	 */
	@Column(name = "LEVEL")
	private Integer level;
	/**
	 * 获取每个自身属性下的子集List列表
	 */
	@OneToMany(targetEntity = FunctionInfo.class, mappedBy = "parent", fetch = FetchType.EAGER)
	private List<FunctionInfo> childInSk = Lists.newArrayList();
	/**
	 * 技能等级List列表
	 */
	@OneToMany(cascade = (CascadeType.REMOVE), targetEntity = SkillsInfo.class, mappedBy = "functionInfo", fetch = FetchType.LAZY)
	@OrderBy("sValue ASC")
	private List<SkillsInfo> childSkills = Lists.newArrayList();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FunctionInfo getParent() {
		return parent;
	}
	public void setParent(FunctionInfo parent) {
		this.parent = parent;
	}
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public List<FunctionInfo> getChildInSk() {
		return childInSk;
	}
	public void setChildInSk(List<FunctionInfo> childInSk) {
		this.childInSk = childInSk;
	}
	public List<SkillsInfo> getChildSkills() {
		return childSkills;
	}
	public void setChildSkills(List<SkillsInfo> childSkills) {
		this.childSkills = childSkills;
	}
	
	public static String toJsonStr(Iterator<FunctionInfo> iter) {
		StringBuffer val = new StringBuffer("[");
		while (iter.hasNext()) {
			FunctionInfo fun = iter.next();
			val.append("{\"id\":");
			val.append(fun.getId());
			val.append(",\"name\":\"");
			val.append(fun.getName());
			val.append("\",\"pid\":");
			val.append(fun.getParent() == null ? 0 : fun.getParent().getId());
			val.append(",\"pidname\":\"");
			val.append(fun.getParent() == null ? 0 : fun.getParent().getName());
			val.append("\",\"isParent\":");
			val.append(fun.getLevel()==4?"false":"true");
			val.append("},");
		}
		int start = val.lastIndexOf(",") < 1 ? val.length() : val.lastIndexOf(",");
		val.replace(start, val.length(), "]");
		return val.toString();
	}
}
