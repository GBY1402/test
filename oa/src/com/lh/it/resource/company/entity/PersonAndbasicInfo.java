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
/**
 * @version:
* @Description:人事和企业信息 
* @author: GBY
* @date: 2018年12月14日下午3:44:00
 */
@Entity
@Table(name = "PERSON_And_BASIC_info")
public class PersonAndbasicInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "PE_BA_ID", length = 128)
	private String peBaId;
	
	/**
	 * 对应HR信息
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_PER_ID")
    private EnterPersonInfo enterPersonInfo;
    
    /**
	 * 对应企业信息
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_ID")
    private EnterBasicInfo enterBasicInfo;
    
    /**
	 * 人事申请 0、已申请 ，1、同意，2、拒绝
	 */
	@Column(name = "PERSON_APPLY", length = 4)
	private Integer personApply = 0;
	
	/**
	 * 人事属性 0、普通招聘，1、猎聘，2、全部
	 */
	@Column(name = "PERSON_ATTR", length = 4)
	private Integer personAttr = 0;
	
    /**
	 * 删除(0、未删除，1、已删除)
	 */
    @Column(name = "MIDDLE_DELETE", length = 4)
    private Integer middleDelete = 0;
    
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

	public String getPeBaId() {
		return peBaId;
	}

	public void setPeBaId(String peBaId) {
		this.peBaId = peBaId;
	}

	public EnterPersonInfo getEnterPersonInfo() {
		return enterPersonInfo;
	}

	public void setEnterPersonInfo(EnterPersonInfo enterPersonInfo) {
		this.enterPersonInfo = enterPersonInfo;
	}

	public EnterBasicInfo getEnterBasicInfo() {
		return enterBasicInfo;
	}

	public void setEnterBasicInfo(EnterBasicInfo enterBasicInfo) {
		this.enterBasicInfo = enterBasicInfo;
	}

	public Integer getPersonApply() {
		return personApply;
	}

	public void setPersonApply(Integer personApply) {
		this.personApply = personApply;
	}

	public Integer getPersonAttr() {
		return personAttr;
	}

	public void setPersonAttr(Integer personAttr) {
		this.personAttr = personAttr;
	}

	public Integer getMiddleDelete() {
		return middleDelete;
	}

	public void setMiddleDelete(Integer middleDelete) {
		this.middleDelete = middleDelete;
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
