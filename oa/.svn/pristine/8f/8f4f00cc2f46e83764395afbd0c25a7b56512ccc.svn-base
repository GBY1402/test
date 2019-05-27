package com.lh.it.resource.company.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.lh.it.resource.person.entity.HumanBasicInfo;
/**
 * @version:
* @Description: 企业人事HR
* @author: GBY
* @date: 2018年12月14日下午12:02:54
 */
@Entity
@Table(name = "Enter_Person_info")
public class EnterPersonInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "ENTER_PER_ID", length = 128)
	private String enterPerId;
	
	/**
   	 * 职位
   	 */
    @Column(name = "ENTER_POSITION", length = 40)
    private String enterPosition;
    
    /**
   	 * 部门
   	 */
    @Column(name = "ENTER_DEPARTMENT", length = 40)
    private String enterDepartment;
    
    /**
   	 * 删除(0、未删除，1、已删除)
   	 */
    @Column(name = "ENTER_DELETE", length = 4)
    private Integer enterDelete = 0;
    
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
	
	/**
	 * 关联个人基础信息
	 */
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "HUMAN_ID")
    private HumanBasicInfo humanBasicInfo;
	
	/**
	 * 级联企业与人事基础信息
	 */
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL }, mappedBy = "enterPersonInfo")
	private PersonAndbasicInfo personAndbasicInfo;

	public String getEnterPerId() {
		return enterPerId;
	}

	public void setEnterPerId(String enterPerId) {
		this.enterPerId = enterPerId;
	}

	public String getEnterPosition() {
		return enterPosition;
	}

	public void setEnterPosition(String enterPosition) {
		this.enterPosition = enterPosition;
	}

	public String getEnterDepartment() {
		return enterDepartment;
	}

	public void setEnterDepartment(String enterDepartment) {
		this.enterDepartment = enterDepartment;
	}

	public Integer getEnterDelete() {
		return enterDelete;
	}

	public void setEnterDelete(Integer enterDelete) {
		this.enterDelete = enterDelete;
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

	public HumanBasicInfo getHumanBasicInfo() {
		return humanBasicInfo;
	}

	public void setHumanBasicInfo(HumanBasicInfo humanBasicInfo) {
		this.humanBasicInfo = humanBasicInfo;
	}

	public PersonAndbasicInfo getPersonAndbasicInfo() {
		return personAndbasicInfo;
	}

	public void setPersonAndbasicInfo(PersonAndbasicInfo personAndbasicInfo) {
		this.personAndbasicInfo = personAndbasicInfo;
	}
	
}
