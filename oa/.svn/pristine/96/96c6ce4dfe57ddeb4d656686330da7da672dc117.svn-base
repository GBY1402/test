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

import com.lh.it.resource.common.entity.FunctionInfo;

/**
 * @version:
* @Description: 伯乐表
* @author: GBY
* @date: 2019年1月31日上午10:21:53
 */
@Entity
@Table(name = "PERSON_BOLE_INFO")
public class PersonBoleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "BOLE_ID", length = 128)
	private String boleId;
	
	/**
	 * 	伯乐昵称
	 */
    @Column(name = "BOLE_NAME", length = 60)
    private String boleName;
    
    /**
	 * 	伯乐头像路径
	 */
    @Column(name = "BOLE_IMAGE", length = 100)
    private String boleImage;
    
    /**
	 * 	伯乐等级
	 */
    @Column(name = "BOLE_GRADE", length = 60)
    private Integer boleGrade = 1;
    /**
   	 * 	伯乐经验
   	 */
    @Column(name = "BOLE_EXPERIENCE", length = 60)
    private Integer boleExperience = 0;
    
    /**
	 * 	伯乐二位码图片路径
	 */
    @Column(name = "BOLE_QR_IMAGE", length = 100)
    private String boleQRImage;
    
    /**
	 * 	伯乐评分
	 */
    @Column(name = "BOLE_SCORE", length = 100)
    private double boleScore = 0;
    
    /**
	 * 	行业
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOLE_INDUSTRY")
	private FunctionInfo boleIndustry;
	
	/**
	 * 	伯乐推介人数
	 */
    @Column(name = "BOLE_RECOM_NUM", length = 20)
    private Integer boleRecomNum = 0;
    
    /**
	 * 	伯乐免费推介卡0、是，1、否
	 */
    @Column(name = "BOLE_RECOM_CARD", length = 4)
    private Integer boleRecomCard;
    
    /**
	 * 	伯乐点赞数
	 */
    @Column(name = "BOLE_FABULOUS", length = 20)
    private Integer boleFabulous = 0;
    
    /**
	 * 删除(0、未删除，1、已删除)
	 */
    @Column(name = "DELETE_BOLE", length = 4)
    private Integer deleteBole = 0;
    
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
	 * 关联个人基础信息
	 */
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "HUMAN_ID")
    private HumanBasicInfo humanBasicInfo;

	public String getBoleId() {
		return boleId;
	}

	public void setBoleId(String boleId) {
		this.boleId = boleId;
	}

	public String getBoleName() {
		return boleName;
	}

	public void setBoleName(String boleName) {
		this.boleName = boleName;
	}

	public String getBoleImage() {
		return boleImage;
	}

	public void setBoleImage(String boleImage) {
		this.boleImage = boleImage;
	}

	public Integer getBoleGrade() {
		return boleGrade;
	}

	public void setBoleGrade(Integer boleGrade) {
		this.boleGrade = boleGrade;
	}

	public Integer getBoleExperience() {
		return boleExperience;
	}

	public void setBoleExperience(Integer boleExperience) {
		this.boleExperience = boleExperience;
	}

	public String getBoleQRImage() {
		return boleQRImage;
	}

	public void setBoleQRImage(String boleQRImage) {
		this.boleQRImage = boleQRImage;
	}

	public double getBoleScore() {
		return boleScore;
	}

	public void setBoleScore(double boleScore) {
		this.boleScore = boleScore;
	}

	public FunctionInfo getBoleIndustry() {
		return boleIndustry;
	}

	public void setBoleIndustry(FunctionInfo boleIndustry) {
		this.boleIndustry = boleIndustry;
	}

	public Integer getBoleRecomNum() {
		return boleRecomNum;
	}

	public void setBoleRecomNum(Integer boleRecomNum) {
		this.boleRecomNum = boleRecomNum;
	}

	public Integer getBoleRecomCard() {
		return boleRecomCard;
	}

	public void setBoleRecomCard(Integer boleRecomCard) {
		this.boleRecomCard = boleRecomCard;
	}

	public Integer getBoleFabulous() {
		return boleFabulous;
	}

	public void setBoleFabulous(Integer boleFabulous) {
		this.boleFabulous = boleFabulous;
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

	public Integer getDeleteBole() {
		return deleteBole;
	}

	public void setDeleteBole(Integer deleteBole) {
		this.deleteBole = deleteBole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boleId == null) ? 0 : boleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonBoleInfo other = (PersonBoleInfo) obj;
		if (boleId == null) {
			if (other.boleId != null)
				return false;
		} else if (!boleId.equals(other.boleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonBoleInfo [boleId=" + boleId + ", boleName=" + boleName + ", boleImage=" + boleImage
				+ ", boleGrade=" + boleGrade + ", boleExperience=" + boleExperience + ", boleQRImage=" + boleQRImage
				+ ", boleScore=" + boleScore + ", boleIndustry=" + boleIndustry + ", boleRecomNum=" + boleRecomNum
				+ ", boleRecomCard=" + boleRecomCard + ", boleFabulous=" + boleFabulous + ", deleteBole=" + deleteBole
				+ ", createUser=" + createUser + ", createTime=" + createTime + ", updateUser=" + updateUser
				+ ", updateTime=" + updateTime + ", humanBasicInfo=" + humanBasicInfo + "]";
	}
	
}
