package com.lh.it.resource.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * @version:
* @Description: 技能数据封装类
* @author: GBY
* @date: 2018年12月13日下午5:23:47
 */
@Entity
@Table(name = "SKILLS_INFO")
public class SkillsInfo implements Serializable {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 6792284896989591209L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "S_ID", length = 128)
	private String sId;
	/**
	 * 技能等级名称
	 */
	@Column(name = "S_NAME", length = 60)
	private String sName;
	/**
	 * 所属职能分类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FU_ID")
	private FunctionInfo functionInfo;

	/**
	 * 技能等级分值
	 */
	@Column(name = "S_VALUE", length = 10)
	private String sValue;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public FunctionInfo getFunctionInfo() {
		return functionInfo;
	}

	public void setFunctionInfo(FunctionInfo functionInfo) {
		this.functionInfo = functionInfo;
	}

	public String getsValue() {
		return sValue;
	}

	public void setsValue(String sValue) {
		this.sValue = sValue;
	}

}
