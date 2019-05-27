package com.lh.it.resource.common.entity;

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
* @Description: APP反馈图片路径
* @author: GBY
* @date: 2019年1月22日下午2:38:00
 */
@Entity
@Table(name="MOBILE_PICTURE_INFO")
public class MobilePictureInfo implements Serializable{

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
	@Column(name = "PICTURE_ID", length = 128)
	private String pictureId;
	
	/**
	 * 关联反馈意见表
	 */
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "MOBILE_ID")
    private MobileProposalInfo mobileProposalInfo;
	
	/**
	* 	路径path
	*/
    @Column(name = "PICTURE_PATH", length = 128)
    private String picturePath;
    
    /**
   	 * 	时间
   	 */
    @Column(name = "PICTURE_TIME")
   	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pictureTime;

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public MobileProposalInfo getMobileProposalInfo() {
		return mobileProposalInfo;
	}

	public void setMobileProposalInfo(MobileProposalInfo mobileProposalInfo) {
		this.mobileProposalInfo = mobileProposalInfo;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Date getPictureTime() {
		return pictureTime;
	}

	public void setPictureTime(Date pictureTime) {
		this.pictureTime = pictureTime;
	}
    
}
