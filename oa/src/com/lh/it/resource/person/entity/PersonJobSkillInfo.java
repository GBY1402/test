package com.lh.it.resource.person.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.lh.it.resource.common.entity.SkillsInfo;

/**
 * @version:
* @Description: 求职技能基础表
* @author: GBY
* @date: 2018年12月19日下午1:43:17
 */
@Entity
@Table(name="PERSON_JOB_SKILL_INFO")
public class PersonJobSkillInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "PERSON_SKILL_ID", length = 128)
	private String personSkillId;

	/**
	 * 求职信息实体类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_JOB_ID")
	private PersonJobInfo personJobInfo;

	/**
	 * 技能数据封装类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "S_ID")
	private SkillsInfo skillsInfo;

	/**
	 * 创建人
	 */
	@Column(name = "CREATE_NAME", length = 40)
	private String createName;

	/**
	 * 技能创建时间
	 */
	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public String getPersonSkillId() {
		return personSkillId;
	}

	public void setPersonSkillId(String personSkillId) {
		this.personSkillId = personSkillId;
	}

	public PersonJobInfo getPersonJobInfo() {
		return personJobInfo;
	}

	public void setPersonJobInfo(PersonJobInfo personJobInfo) {
		this.personJobInfo = personJobInfo;
	}

	public SkillsInfo getSkillsInfo() {
		return skillsInfo;
	}

	public void setSkillsInfo(SkillsInfo skillsInfo) {
		this.skillsInfo = skillsInfo;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
