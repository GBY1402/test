package com.lh.it.resource.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.google.common.collect.Lists;
/**
 * @version:
* @Description: APP反馈与建议
* @author: GBY
* @date: 2019年1月22日下午2:38:00
 */
@Entity
@Table(name="MOBILE_PROPOSAL_INFO")
public class MobileProposalInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 	ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "MOBILE_ID", length = 128)
	private String mobileId;
	
	/**
	 * 	名称
	 */
    @Column(name = "MOBILE_NAME", length = 20)
    private String mobileName;
    
	/**
	* 	APPID
	*/
    @Column(name = "APP_ID", length = 40)
    private String appId;
    
    /**
	 * 	APP版本号
	 */
    @Column(name = "APP_VERSION", length = 40)
    private String appVersion;
     
    /**
	 * 	时间
	 */
    @Column(name = "MOBILE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mobileTime;
    
    /**
   	 * 	反馈和意见
   	 */
    @Column(name = "MOBILE_DESCRIBE", length = 225)
    private String mobileDescribe;
    
    /**
     * 	图片反馈
     */
    @OneToMany(mappedBy = "mobileProposalInfo", fetch = FetchType.LAZY)
   	@Cascade(value = { CascadeType.ALL })
   	private List<MobilePictureInfo> pictureList = Lists.newArrayList();

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public Date getMobileTime() {
		return mobileTime;
	}

	public void setMobileTime(Date mobileTime) {
		this.mobileTime = mobileTime;
	}

	public String getMobileDescribe() {
		return mobileDescribe;
	}

	public void setMobileDescribe(String mobileDescribe) {
		this.mobileDescribe = mobileDescribe;
	}

	public List<MobilePictureInfo> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<MobilePictureInfo> pictureList) {
		this.pictureList = pictureList;
	}
    
}
