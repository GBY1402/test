package com.lh.it.resource.company.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
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

import com.lh.it.resource.common.entity.BasicsDataInfo;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.RegionAllInfo;

/**
 * @version:
* @Description: 企业基础信息表
* @author: GBY
* @date: 2018年12月14日上午9:58:22
 */
@Entity
@Table(name = "Enter_Basic_info")
public class EnterBasicInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "ENTER_ID", length = 128)
	private String enterId;
	
	/**
	 * 企业全称
	 */
    @Column(name = "ENTER_NAME", length = 60)
    private String enterName;
    
    /**
	 * 企业简称
	 */
    @Column(name = "ENTER_SHORT_NAME", length = 60)
    private String enterShortName;
    
    /**
	 * 企业性质
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_NATURE")
    private BasicsDataInfo enterNature;
    
    /**
	 * 企业融资轮数
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_FINANC")
    private BasicsDataInfo enterFinanc;
    
    /**
	 * 企业人数
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_NUMBER")
    private BasicsDataInfo enterNumber;
    
    /**
   	 * 法人代表
   	 */
    @Column(name = "ENTER_LEGAL_PERSON", length = 10)
    private String enterLegalPerson;
   
    /**
   	 * 企业邮箱
   	 */
    @Column(name = "ENTER_EMAIL", length = 20)
    private String enterEmail;
    
    /**
   	 * 企业电话
   	 */
    @Column(name = "ENTER_TELEPHONE", length = 20)
    private String enterTelephone;
    
    /**
	 * 行业
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTER_INDUSTRY")
	private FunctionInfo enterIndustry;
	
	/**
	 * 地区
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENTER_ARDESS")
    private RegionAllInfo enterArdess;
    
    /**
	 * 详细地址
	 */
	@Column(name = "ENTER_ARDESS_DE", length = 60)
	private String enterArdessDe;
	
	/**
	 * 工作地点X轴
	 */
	@Column(name = "ENTER_ARDESS_X", length = 20)
	private BigDecimal enterArdessX = new BigDecimal(0.0000000);
	
	/**
	 * 工作地点Y轴
	 */
	@Column(name = "ENTER_ARDESS_Y", length = 20)
	private BigDecimal enterArdessY = new BigDecimal(0.0000000);
	
    /**
   	 * 公司LOGO
   	 */
    @Column(name = "ENTER_LOGO", length = 180)
    private String enterLogo;
    
    /**
   	 * 营业执照
   	 */
    @Column(name = "ENTER_BUSIMES", length = 180)
    private String enterBusimes;
    
    /**
   	 * 	企业官网
   	 */
    @Column(name = "ENTER_URL", length = 80)
    private String enterUrl;
    
    /**
   	 * 	企业描述
   	 */
    @Column(name = "ENTER_DESCRIDE", length = 80)
    private String enterDescride;
    
    /**
	 * 	企业认证状态0认证中 1已认证 2认证未通过
	 */
  	@Column(name = "ENTER_CONDITION", length = 4)
    private Integer enterCondition = 0;
    
    /**
   	 * 	删除(0、未删除，1、已删除)
   	 */
    @Column(name = "ENTER_DELETE", length = 4)
    private Integer enterDelete = 0;
    
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

	public String getEnterId() {
		return enterId;
	}

	public void setEnterId(String enterId) {
		this.enterId = enterId;
	}

	public String getEnterName() {
		return enterName;
	}

	public void setEnterName(String enterName) {
		this.enterName = enterName;
	}

	public String getEnterShortName() {
		return enterShortName;
	}

	public void setEnterShortName(String enterShortName) {
		this.enterShortName = enterShortName;
	}

	public BasicsDataInfo getEnterNature() {
		return enterNature;
	}

	public void setEnterNature(BasicsDataInfo enterNature) {
		this.enterNature = enterNature;
	}

	public BasicsDataInfo getEnterFinanc() {
		return enterFinanc;
	}

	public void setEnterFinanc(BasicsDataInfo enterFinanc) {
		this.enterFinanc = enterFinanc;
	}

	public BasicsDataInfo getEnterNumber() {
		return enterNumber;
	}

	public void setEnterNumber(BasicsDataInfo enterNumber) {
		this.enterNumber = enterNumber;
	}

	public String getEnterLegalPerson() {
		return enterLegalPerson;
	}

	public void setEnterLegalPerson(String enterLegalPerson) {
		this.enterLegalPerson = enterLegalPerson;
	}

	public String getEnterEmail() {
		return enterEmail;
	}

	public void setEnterEmail(String enterEmail) {
		this.enterEmail = enterEmail;
	}

	public String getEnterTelephone() {
		return enterTelephone;
	}

	public void setEnterTelephone(String enterTelephone) {
		this.enterTelephone = enterTelephone;
	}

	public FunctionInfo getEnterIndustry() {
		return enterIndustry;
	}

	public void setEnterIndustry(FunctionInfo enterIndustry) {
		this.enterIndustry = enterIndustry;
	}

	public RegionAllInfo getEnterArdess() {
		return enterArdess;
	}

	public void setEnterArdess(RegionAllInfo enterArdess) {
		this.enterArdess = enterArdess;
	}

	public String getEnterArdessDe() {
		return enterArdessDe;
	}

	public void setEnterArdessDe(String enterArdessDe) {
		this.enterArdessDe = enterArdessDe;
	}

	public BigDecimal getEnterArdessX() {
		return enterArdessX;
	}

	public void setEnterArdessX(BigDecimal enterArdessX) {
		this.enterArdessX = enterArdessX;
	}

	public BigDecimal getEnterArdessY() {
		return enterArdessY;
	}

	public void setEnterArdessY(BigDecimal enterArdessY) {
		this.enterArdessY = enterArdessY;
	}

	public String getEnterLogo() {
		return enterLogo;
	}

	public void setEnterLogo(String enterLogo) {
		this.enterLogo = enterLogo;
	}

	public String getEnterBusimes() {
		return enterBusimes;
	}

	public void setEnterBusimes(String enterBusimes) {
		this.enterBusimes = enterBusimes;
	}

	public String getEnterUrl() {
		return enterUrl;
	}

	public void setEnterUrl(String enterUrl) {
		this.enterUrl = enterUrl;
	}

	public String getEnterDescride() {
		return enterDescride;
	}

	public void setEnterDescride(String enterDescride) {
		this.enterDescride = enterDescride;
	}

	public Integer getEnterCondition() {
		return enterCondition;
	}

	public void setEnterCondition(Integer enterCondition) {
		this.enterCondition = enterCondition;
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
	
}
