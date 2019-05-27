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
* @Description: 企业子账号管理
* @author: GBY
* @date: 2018年12月14日上午9:58:22
 */
@Entity
@Table(name = "COMPANY_AGREEMENT")
public class CompanyAgreemenInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "AGREEMENT_ID", length = 128)
	private String agreementId;
	
	/**
	 * 签约状态(急聘) 0未签约/1签约中/2已签约
	 */
	@Column(name = "WANTED_AGREEMENT_STATE", length = 1)
	private Integer wantedState=0;
	
	/**
	 * 签约状态(猎聘) 0未签约/1签约中/2已签约
	 */
    @Column(name = "HUNTING_AGREEMENT_STATE", length = 1)
    private Integer huntingState=0;
    
    /**
	 * 急聘签约文件地址
	 */
    @Column(name = "WANTED_AGREEMENT_URL", length = 128)
    private String wantedURL;
    
    /**
	 * 文件编号
	 */
    @Column(name = "NUMBER", length = 20)
    private String number;
    
    /**
	 * 关联企业
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTER_ID")
	private EnterBasicInfo enterBasicInfo;
    
    /**
	 *	 创建人
	 */
	@Column(name = "CREATE_USER", length = 40)
	private String createUser;
	
	/**
	 * 	创建时间
	 */
	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 *	 修改人
	 */
	@Column(name = "UPDATE_USER", length = 40)
	private String updateUser;

	/**
	 * 	修改时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public String getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}

	public Integer getWantedState() {
		return wantedState;
	}

	public void setWantedState(Integer wantedState) {
		this.wantedState = wantedState;
	}

	public Integer getHuntingState() {
		return huntingState;
	}

	public void setHuntingState(Integer huntingState) {
		this.huntingState = huntingState;
	}

	public String getWantedURL() {
		return wantedURL;
	}

	public void setWantedURL(String wantedURL) {
		this.wantedURL = wantedURL;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public EnterBasicInfo getEnterBasicInfo() {
		return enterBasicInfo;
	}

	public void setEnterBasicInfo(EnterBasicInfo enterBasicInfo) {
		this.enterBasicInfo = enterBasicInfo;
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
