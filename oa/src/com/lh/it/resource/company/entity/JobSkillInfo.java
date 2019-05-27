package com.lh.it.resource.company.entity;

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
* @Description: 职位技能表
* @author: GBY
* @date: 2018年12月13日下午5:51:42
 */
@Entity
@Table(name="JOB_SKILL_INFO")
public class JobSkillInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "JOB_SKILL_ID", length = 128)
	private String jobSkillId;

	/**
	 * 招聘信息实体类
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_WANFED_ID")
	private JobWanfedInfo jobWanfedInfo;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	public String getJobSkillId() {
		return jobSkillId;
	}

	public void setJobSkillId(String jobSkillId) {
		this.jobSkillId = jobSkillId;
	}

	public JobWanfedInfo getJobWanfedInfo() {
		return jobWanfedInfo;
	}

	public void setJobWanfedInfo(JobWanfedInfo jobWanfedInfo) {
		this.jobWanfedInfo = jobWanfedInfo;
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
