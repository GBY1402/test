package com.lh.it.resource.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @version:
* @Description: 伯乐中心基础数据设置
* @author: GBY
* @date: 2018年12月13日下午5:28:58
 */
@Entity
@Table(name="BOLE_GRADE_DATA_INFO")
public class BoleGradeDataInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "BOLE_DATA_ID", length = 128)
	private String boleDataId;

	/**
	 * 	伯乐等级
	 */
	@Column(name = "BOLE_GRADE", length = 4)
	private Integer boleGrade;
	
	/**
   	 * 	伯乐等级对应的经验
   	 */
    @Column(name = "BOLE_EXPERIENCE", length = 10)
    private Integer boleExperience = 0;
	
	/**
	 * 	伯乐等级对应的名称
	 */
    @Column(name = "GRADE_NAME", length = 60)
    private String gradeName;
    
    /**
   	 * 	伯乐等级对应的佣金限制
   	 */
    @Column(name = "BOLE_MONEY")
    private BigDecimal boleMoney = new BigDecimal(0.00);
    
    /**
	 * 删除(0、未删除，1、已删除)
	 */
    @Column(name = "DELETE_DATA", length = 4)
    private Integer deleteData = 0;
    
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

	public String getBoleDataId() {
		return boleDataId;
	}

	public void setBoleDataId(String boleDataId) {
		this.boleDataId = boleDataId;
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

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public BigDecimal getBoleMoney() {
		return boleMoney;
	}

	public void setBoleMoney(BigDecimal boleMoney) {
		this.boleMoney = boleMoney;
	}

	public Integer getDeleteData() {
		return deleteData;
	}

	public void setDeleteData(Integer deleteData) {
		this.deleteData = deleteData;
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
