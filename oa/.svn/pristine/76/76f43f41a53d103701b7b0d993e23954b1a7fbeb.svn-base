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

/**
 * @version:
* @Description: 工作经历基础表
* @author: GBY
* @date: 2018年12月18日下午5:26:55
 */
@Entity
@Table(name = "PERSON_JOB_RESUME_INFO")
public class PersonJobResumeInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "RESUME_ID", length = 128)
	private String resumeId;
	
	/**
	 * 公司名称
	 */
    @Column(name = "RESUME_NAME", length = 60)
    private String resumeName;
    
    /**
	 * 公司电话
	 */
    @Column(name = "RESUME_PHONE", length = 20)
    private String resumePhone;
    
    /**
	 * 工作职位
	 */
    @Column(name = "RESUME_POSITION", length = 60)
    private String resumePosition;
    
    /**
	 * 所属部门
	 */
    @Column(name = "RESUME_DEPARTMENT", length = 60)
    private String resumeDepartment;
    
    /**
	 * 开始时间
	 */
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    
    /**
	 * 结束时间
	 */
    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    
    /**
   	 * 薪资
   	 */
    @Column(name = "RESUME_PAY", length = 20)
	private String resumePay;
   
    /**
  	 * 职责描述
  	 */
	@Column(name = "RESUME_DESCRIBE", length = 255)
	private String resumeDescribe;
  
	/**
	 * 删除(0、未删除，1、已删除)
	 */
	@Column(name = "DELETE_BASIC", length = 4)
	private Integer deleteBasic = 0;
  
	/**
	 * 关联个人基础信息
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_JOB_ID")
	private PersonJobInfo personJobInfo;
	
	/**
	 * 创建人
	 */
	@Column(name = "CREATE_USER", length = 40)
	private String createUser;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 修改人
	 */
	@Column(name = "UPDATE_USER", length = 40)
	private String updateUser;

	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public String getResumePhone() {
		return resumePhone;
	}

	public void setResumePhone(String resumePhone) {
		this.resumePhone = resumePhone;
	}

	public String getResumePosition() {
		return resumePosition;
	}

	public void setResumePosition(String resumePosition) {
		this.resumePosition = resumePosition;
	}

	public String getResumeDepartment() {
		return resumeDepartment;
	}

	public void setResumeDepartment(String resumeDepartment) {
		this.resumeDepartment = resumeDepartment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getResumePay() {
		return resumePay;
	}

	public void setResumePay(String resumePay) {
		this.resumePay = resumePay;
	}

	public String getResumeDescribe() {
		return resumeDescribe;
	}

	public void setResumeDescribe(String resumeDescribe) {
		this.resumeDescribe = resumeDescribe;
	}

	public Integer getDeleteBasic() {
		return deleteBasic;
	}

	public void setDeleteBasic(Integer deleteBasic) {
		this.deleteBasic = deleteBasic;
	}

	public PersonJobInfo getPersonJobInfo() {
		return personJobInfo;
	}

	public void setPersonJobInfo(PersonJobInfo personJobInfo) {
		this.personJobInfo = personJobInfo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
