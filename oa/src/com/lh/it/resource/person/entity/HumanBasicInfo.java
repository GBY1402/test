package com.lh.it.resource.person.entity;
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

import com.lh.it.resource.common.entity.BasicsDataInfo;
import com.lh.it.resource.common.entity.RegionAllInfo;
import com.lh.it.resource.common.entity.UserAddInfo;
import com.lh.it.resource.company.entity.EnterPersonInfo;

/**
 * @version:
* @Description: 人基础信息表
* @author: GBY
* @date: 2018年12月14日下午1:53:11
 */
@Entity
@Table(name = "HUMAN_BASIC_INFO")
public class HumanBasicInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * 	ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "HUMAN_ID", length = 128)
	private String humanId;
	
	/**
	 * 	头像路径
	 */
    @Column(name = "HUMAN_IMAGE", length = 100)
    private String humanImage;
    
    /**
	 * 	姓名
	 */
    @Column(name = "HUMAN_NAME", length = 20)
    private String humanName;
    
    /**
	 * 	身份证
	 */
    @Column(name = "HUMAN_CARD", length = 20)
    private String humanCard;
    
    /**
     * 	实名是否认证（0未认证，1已认证）
     */
    @Column(name = "NAME_AUTHENT", length = 4)
	private Integer nameAuthent = 0;
    
    /**
	 * 	性别(0、男，1、女)
	 */
    @Column(name = "HUMAN_SEX", length = 4)
    private Integer humanSex;
    
    /**
	 *	 身份（0、莘莘学子，1、蒸蒸日上）
	 */
    @Column(name = "HUMAN_IDENTITY", length = 4)
    private Integer humanIdentity;
    
    /**
	 * 	学历
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HUMAN_DIPLOMA")
    private BasicsDataInfo humanDiploma;
    
    /**
     * 	 出生日期
     */
    @Column(name = "HUMAN_BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date humanBirthday; //出生年月yyyy-MM-dd
    
    /**
	 * 	手机号
	 */
    @Column(name = "HUMAN_PHONE", length = 20)
    private String humanPhone;
    
    /**
	 * 	微信
	 */
    @Column(name = "HUMAN_WECHAT", length = 20)
    private String humanWechat;
    
    /**
	 * 	QQ
	 */
    @Column(name = "HUMAN_QQ", length = 20)
    private String humanQQ;
    
    /**
	 * 	邮箱
	 */
    @Column(name = "HUMAN_EMAIL", length = 50)
    private String humanEmail;
    
    /**
	 * 	现居住地
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HUMAN_RESIDENCE")
    private RegionAllInfo humanResidence;
    
    /**
     * 	详细地址
     */
    @Column(name = "HUMAN_DETAILED", length = 60)
    private String humanDetailed;
    
    /**
   	 * 	老家
   	 */
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "HUMAN_HOMETOWN")
    private RegionAllInfo humanHometown;
    
    /**
	 * 	身高
	 */
    @Column(name = "HUMAN_HEIGHT", length = 10)
    private String humanHeight;
    
    /**
	 * 	体重
	 */
    @Column(name = "HUMAN_WEIGHT", length = 10)
    private String humanWeight;
    
    /**
   	 * 	自我描述
   	 */
	@Column(name = "HUMAN_DESCRIPTION", length = 255)
	private String humanDescription;
    
	/**
	 * 	删除(0、未删除，1、已删除)
	 */
    @Column(name = "DELETE_BASIC", length = 4)
    private Integer deleteBasic = 0;
	/**
	 * 	创建人
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
	 * 	修改人
	 */
	@Column(name = "UPDATE_USER", length = 40)
	private String updateUser;

	/**
	 *	 修改时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/**
	 * * 对应的账号
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserAddInfo userAddInfo;
    
    /**
	 * 	级联企业HR基础信息
	 */
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL }, mappedBy = "humanBasicInfo")
	private EnterPersonInfo enterPersonInfo;
	
	/**
	 * 	级联个人钱包基础信息
	 */
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL }, mappedBy = "humanBasicInfo")
	private WalletInfo walletInfo;
	
	/**
	 * 	级联个人求职基础信息
	 */
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL }, mappedBy = "humanBasicInfo")
	private PersonJobInfo personJobInfo;

	public String getHumanId() {
		return humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	public String getHumanImage() {
		return humanImage;
	}

	public void setHumanImage(String humanImage) {
		this.humanImage = humanImage;
	}

	public String getHumanName() {
		return humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getHumanCard() {
		return humanCard;
	}

	public void setHumanCard(String humanCard) {
		this.humanCard = humanCard;
	}

	public Integer getNameAuthent() {
		return nameAuthent;
	}

	public void setNameAuthent(Integer nameAuthent) {
		this.nameAuthent = nameAuthent;
	}

	public Integer getHumanSex() {
		return humanSex;
	}

	public void setHumanSex(Integer humanSex) {
		this.humanSex = humanSex;
	}

	public Integer getHumanIdentity() {
		return humanIdentity;
	}

	public void setHumanIdentity(Integer humanIdentity) {
		this.humanIdentity = humanIdentity;
	}

	public BasicsDataInfo getHumanDiploma() {
		return humanDiploma;
	}

	public void setHumanDiploma(BasicsDataInfo humanDiploma) {
		this.humanDiploma = humanDiploma;
	}

	public Date getHumanBirthday() {
		return humanBirthday;
	}

	public void setHumanBirthday(Date humanBirthday) {
		this.humanBirthday = humanBirthday;
	}

	public String getHumanPhone() {
		return humanPhone;
	}

	public void setHumanPhone(String humanPhone) {
		this.humanPhone = humanPhone;
	}

	public String getHumanWechat() {
		return humanWechat;
	}

	public void setHumanWechat(String humanWechat) {
		this.humanWechat = humanWechat;
	}

	public String getHumanQQ() {
		return humanQQ;
	}

	public void setHumanQQ(String humanQQ) {
		this.humanQQ = humanQQ;
	}

	public String getHumanEmail() {
		return humanEmail;
	}

	public void setHumanEmail(String humanEmail) {
		this.humanEmail = humanEmail;
	}

	public RegionAllInfo getHumanResidence() {
		return humanResidence;
	}

	public void setHumanResidence(RegionAllInfo humanResidence) {
		this.humanResidence = humanResidence;
	}

	public String getHumanDetailed() {
		return humanDetailed;
	}

	public void setHumanDetailed(String humanDetailed) {
		this.humanDetailed = humanDetailed;
	}

	public RegionAllInfo getHumanHometown() {
		return humanHometown;
	}

	public void setHumanHometown(RegionAllInfo humanHometown) {
		this.humanHometown = humanHometown;
	}

	public String getHumanHeight() {
		return humanHeight;
	}

	public void setHumanHeight(String humanHeight) {
		this.humanHeight = humanHeight;
	}

	public String getHumanWeight() {
		return humanWeight;
	}

	public void setHumanWeight(String humanWeight) {
		this.humanWeight = humanWeight;
	}

	public String getHumanDescription() {
		return humanDescription;
	}

	public void setHumanDescription(String humanDescription) {
		this.humanDescription = humanDescription;
	}

	public Integer getDeleteBasic() {
		return deleteBasic;
	}

	public void setDeleteBasic(Integer deleteBasic) {
		this.deleteBasic = deleteBasic;
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

	public UserAddInfo getUserAddInfo() {
		return userAddInfo;
	}

	public void setUserAddInfo(UserAddInfo userAddInfo) {
		this.userAddInfo = userAddInfo;
	}

	public EnterPersonInfo getEnterPersonInfo() {
		return enterPersonInfo;
	}

	public void setEnterPersonInfo(EnterPersonInfo enterPersonInfo) {
		this.enterPersonInfo = enterPersonInfo;
	}

	public PersonJobInfo getPersonJobInfo() {
		return personJobInfo;
	}

	public void setPersonJobInfo(PersonJobInfo personJobInfo) {
		this.personJobInfo = personJobInfo;
	}

	public WalletInfo getWalletInfo() {
		return walletInfo;
	}

	public void setWalletInfo(WalletInfo walletInfo) {
		this.walletInfo = walletInfo;
	}
     
}
