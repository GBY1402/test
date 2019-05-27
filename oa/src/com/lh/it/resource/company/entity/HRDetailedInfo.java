package com.lh.it.resource.company.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * HR钱包明细
 * @author Administrator
 *
 */
@Entity
@Table(name = "COMPANY_DETAILED_INFO")
public class HRDetailedInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7775391353786966434L;
	

	/**
	 * 	ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "DETAILED_ID", length = 128)
	private String detailedId;
	
	/**
	 * 状态0：收入 1：提现  2:支出
	 */
	@Column(name = "STATE", length =2)
	private Integer state=0;
	
	/**
	 * 类型 0：微信 1：支付宝 2：平台钱包
	 */
	@Column(name = "TYPE", length =2)
	private Integer type=0;
	
	/**
	 * 交易金额
	 */
	@Column(name = "MONEY", length =6)
	private BigDecimal money = new BigDecimal(0.00);
	
	
	/**
	 * 进度 0：结算成功 1：结算中 2：结算失败
	 */
	@Column(name = "PROGRESS", length =2)
	private Integer progress=0; 
	
	/**
	 * 订单号
	 */
	@Column(name = "ORDER_NUMBER", length = 128)
	private String orderNumber;
	
   	/**
   	 * 	删除(0、未删除，1、已删除)
   	 */
   @Column(name = "WALLET_DELETE", length = 4)
   private Integer walletDelete = 0;
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
   	 * 
   	 *  对应的账号
   	 */
   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "WALLET_ID")
   private EnterHRWalletInfo enterHRWalletInfo;

	public String getDetailedId() {
		return detailedId;
	}

	public void setDetailedId(String detailedId) {
		this.detailedId = detailedId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getProgress() {
		return progress;
	}

	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getWalletDelete() {
		return walletDelete;
	}

	public void setWalletDelete(Integer walletDelete) {
		this.walletDelete = walletDelete;
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

	public EnterHRWalletInfo getEnterHRWalletInfo() {
		return enterHRWalletInfo;
	}

	public void setEnterHRWalletInfo(EnterHRWalletInfo enterHRWalletInfo) {
		this.enterHRWalletInfo = enterHRWalletInfo;
	}

	@Override
	public String toString() {
		return "HRDetailedInfo [detailedId=" + detailedId + ", state=" + state + ", type=" + type + ", money=" + money
				+ ", progress=" + progress + ", orderNumber=" + orderNumber + ", walletDelete=" + walletDelete
				+ ", createUser=" + createUser + ", createTime=" + createTime + ", updateUser=" + updateUser
				+ ", updateTime=" + updateTime + ", enterHRWalletInfo=" + enterHRWalletInfo + "]";
	}
	
}
