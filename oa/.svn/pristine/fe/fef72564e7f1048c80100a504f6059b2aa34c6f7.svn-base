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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.lh.it.resource.common.entity.RegionAllInfo;

/**
 * @version:
* @Description:  职位简历消息列表
* @author: GBY
* @date: 2018年12月21日下午5:15:45
 */
@Entity
@Table(name = "JOBPER_NEWS_INFO")
public class JobperNewsInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "NEWS_ID", length = 128)
	private String newsId;
	
	/**
	 *	简历职位中间数据表
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CENTRE_ID")
    private JobperCentreInfo jobperCentreInfo;
    
    /**
   	 * 	消息属性1、消息提示，2、邀请面试，3、面试结果
   	 */
	@Column(name = "NEWS_TYPE", length = 4)
	private Integer newsType;
	
	/**
   	 * 	消息字段0、已投递，1、已查看，2、邀请面试，3、面试结果
   	 */
	@Column(name = "NEWS_INVITE", length = 4)
	private Integer newsInvite;
	
	/**
   	 * 	消息字段（邀请面试）0、同意面试，1、拒绝面试，（面试结果）0、不合适，1、已成功
   	 */
	@Column(name = "NEWS_AUDITION", length = 4)
	private Integer newsAudition;
	
	/**
	 * 	投递时间
	 */
	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/**
	 * 	改变时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/**
   	 * 	描述
   	 */
	@Column(name = "NEWS_DESCRIBE", length = 225)
	private String newsDescribe;
	
	/**
	 * 	面试时间
	 */
	@Column(name = "AU_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auTime;
	
	 /**
	 * 	工作地址
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORK_ARDESS")
    private RegionAllInfo auAddress;
    
    /**
	 * 	详细地址
	 */
	@Column(name = "WORK_ARDESS_DE", length = 60)
	private String workArdessDe;
	
	/**
	 * 	面试地点X
	 */
	@Column(name = "AU_ADDRESS_X", length = 20)
	private String auAddressX;
	
	/**
	 * 	面试地点Y
	 */
	@Column(name = "AU_ADDRESS_Y", length = 20)
	private String auAddressY;
	
	/**
	 * 	面试联系人
	 */
	@Column(name = "AU_PEOPLE", length = 8)
	private String auPeople;
	
	/**
	 * 	联系电话
	 */
	@Column(name = "AU_PHONE", length = 20)
	private String auPhone;
	
	/**
	 * 	备注
	 */
	@Column(name = "AU_DESCRIBE", length = 225)
	private String auDescribe;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public JobperCentreInfo getJobperCentreInfo() {
		return jobperCentreInfo;
	}

	public void setJobperCentreInfo(JobperCentreInfo jobperCentreInfo) {
		this.jobperCentreInfo = jobperCentreInfo;
	}

	public Integer getNewsType() {
		return newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}

	public Integer getNewsInvite() {
		return newsInvite;
	}

	public void setNewsInvite(Integer newsInvite) {
		this.newsInvite = newsInvite;
	}

	public Integer getNewsAudition() {
		return newsAudition;
	}

	public void setNewsAudition(Integer newsAudition) {
		this.newsAudition = newsAudition;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getNewsDescribe() {
		return newsDescribe;
	}

	public void setNewsDescribe(String newsDescribe) {
		this.newsDescribe = newsDescribe;
	}

	public Date getAuTime() {
		return auTime;
	}

	public void setAuTime(Date auTime) {
		this.auTime = auTime;
	}

	public RegionAllInfo getAuAddress() {
		return auAddress;
	}

	public void setAuAddress(RegionAllInfo auAddress) {
		this.auAddress = auAddress;
	}

	public String getWorkArdessDe() {
		return workArdessDe;
	}

	public void setWorkArdessDe(String workArdessDe) {
		this.workArdessDe = workArdessDe;
	}

	public String getAuAddressX() {
		return auAddressX;
	}

	public void setAuAddressX(String auAddressX) {
		this.auAddressX = auAddressX;
	}

	public String getAuAddressY() {
		return auAddressY;
	}

	public void setAuAddressY(String auAddressY) {
		this.auAddressY = auAddressY;
	}

	public String getAuPeople() {
		return auPeople;
	}

	public void setAuPeople(String auPeople) {
		this.auPeople = auPeople;
	}

	public String getAuPhone() {
		return auPhone;
	}

	public void setAuPhone(String auPhone) {
		this.auPhone = auPhone;
	}

	public String getAuDescribe() {
		return auDescribe;
	}

	public void setAuDescribe(String auDescribe) {
		this.auDescribe = auDescribe;
	}

}
