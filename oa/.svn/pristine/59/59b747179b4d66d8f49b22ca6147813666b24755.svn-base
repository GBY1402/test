package com.lh.it.resource.person.entity;

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
 * 个人钱包实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "WALLET_INFO")
public class WalletInfo implements Serializable{

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
	@Column(name = "WALLET_ID", length = 128)
	private String walletId;
	
	/**
     * 余额
     */
    @Column(name = "BALANCE", length = 5)
	private BigDecimal balance = new BigDecimal(0.00);

    /**
     * 账户状态0：正常 1：冻结  2：结算中
     */
    @Column(name = "STATE", length = 4)
    private String state;
    
    /**
     * 账户状态0：未绑定任何 1：微信已绑定  2：支付宝已绑定 3：支付宝/微信都绑定
     */
    @Column(name = "BINDING", length = 4)
    private String binding;
    
    /**
   	 * 	微信名称
   	 */
   	@Column(name = "WECHAT_NAME", length = 128)
   	private String weChatName;
   	
    /**
   	 * 	微信
   	 */
   	@Column(name = "WECHAT", length = 128)
   	private String weChat;
   	
   	/**
   	 * 	支付宝
   	 */
   	@Column(name = "ALIPAY", length = 50)
   	private String aliPay;
   	
   	/**
   	 * 	微信头像
   	 */
   	@Column(name = "HEADIMGURL", length = 500)
   	private String headimgurl;

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
   @JoinColumn(name = "HUMAN_ID")
   private HumanBasicInfo humanBasicInfo;

	public String getWalletId() {
		return walletId;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public Integer getWalletDelete() {
		return walletDelete;
	}

	public void setWalletDelete(Integer walletDelete) {
		this.walletDelete = walletDelete;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getWeChatName() {
		return weChatName;
	}

	public void setWeChatName(String weChatName) {
		this.weChatName = weChatName;
	}

	public String getAliPay() {
		return aliPay;
	}

	public void setAliPay(String aliPay) {
		this.aliPay = aliPay;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((walletId == null) ? 0 : walletId.hashCode());
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
		WalletInfo other = (WalletInfo) obj;
		if (walletId == null) {
			if (other.walletId != null)
				return false;
		} else if (!walletId.equals(other.walletId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WalletInfo [walletId=" + walletId + ", balance=" + balance + ", state=" + state + ", binding=" + binding
				+ ", weChatName=" + weChatName + ", weChat=" + weChat + ", aliPay=" + aliPay + ", headimgurl="
				+ headimgurl + ", walletDelete=" + walletDelete + ", createUser=" + createUser + ", createTime="
				+ createTime + ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", humanBasicInfo="
				+ humanBasicInfo + "]";
	}
	
}
