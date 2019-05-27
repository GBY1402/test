package com.lh.it.resource.common.entity;

import java.io.Serializable;
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
 * @Description: 急聘猎聘佣金基础数据设置
 * @author: GBY
 * @date: 2018年12月13日下午5:28:58
 */
@Entity
@Table(name = "HUNTING_WORRY_DATA_INFO")
public class HuntingWorryDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "HUN_WOR_ID", length = 128)
	private String hunWorId;

	/**
	 * 职位类型0、普通，1、急聘，2、猎聘
	 */
	@Column(name = "HUN_WOR_ATTR", length = 4)
	private Integer hunWorAttr;

	/**
	 * 首笔支付天数
	 */
	@Column(name = "START_DAY", length = 4)
	private Integer startDay = 0;

	/**
	 * 首笔支付百分比
	 */
	@Column(name = "START_PAY", length = 10)
	private double startPay = 0;

	/**
	 * 首笔支付天数
	 */
	@Column(name = "END_DAY", length = 4)
	private Integer endDay = 0;

	/**
	 * 首笔支付百分比
	 */
	@Column(name = "END_PAY", length = 10)
	private double endPay = 0;

	/**
	 * 删除(0、未删除，1、已删除)
	 */
	@Column(name = "DELETE_DATA", length = 4)
	private Integer deleteData = 0;

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

	public String getHunWorId() {
		return hunWorId;
	}

	public void setHunWorId(String hunWorId) {
		this.hunWorId = hunWorId;
	}

	public Integer getHunWorAttr() {
		return hunWorAttr;
	}

	public void setHunWorAttr(Integer hunWorAttr) {
		this.hunWorAttr = hunWorAttr;
	}

	public Integer getStartDay() {
		return startDay;
	}

	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}

	public double getStartPay() {
		return startPay;
	}

	public void setStartPay(double startPay) {
		this.startPay = startPay;
	}

	public Integer getEndDay() {
		return endDay;
	}

	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}

	public double getEndPay() {
		return endPay;
	}

	public void setEndPay(double endPay) {
		this.endPay = endPay;
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

}
