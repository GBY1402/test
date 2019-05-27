package com.lh.it.resource.common.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.lh.it.resource.person.entity.HumanBasicInfo;
/**
 * @version:
* @Description: 账号实体类
* @author: GBY
* @date: 2018年12月11日上午11:49:51
 */
@Entity
@Table(name = "USER_RECEPTION_INFO")
public class UserAddInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 注册ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "USER_ID", length = 128)
	private String userId;
	/**
	 * 用户名
	 */
	@Column(name = "USER_NAME", length = 40)
	private String userName;

	@Transient
	private String plainPassword;
	
	/**
	 * 密码1
	 */
	@Column(name = "USER_PASSWORD", length = 64)
	private String userPassword;

	/**
	 * 密码2
	 */
	@Column(name = "USER_SALT", length = 32)
	private String userSalt;
	
	/**
	 * 属性个人账号1是 0否
	 */
	@Column(name = "USER_PERSON", length = 4)
	private Integer userPerson = 0; 
	
	/**
	 * 属性企业账号1是0 否
	 */
	@Column(name = "USER_COMPANY", length = 4)
	private Integer userCompany = 0;
	
	/**
	 * 状态 1 是可用、2 是不可用、3是个人不可用、4、企业不可用
	 */
	@Column(name = "USER_STATE", length = 4)
	private Integer userState = 1;
	
	/**
	 * 状态 0未删除、1已删除
	 */
	@Column(name = "USER_DELETE", length = 4)
	private Integer userDelete = 0;
	
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

	/**
	 * 修改人
	 */
	@Column(name = "UPDATE_USER", length = 60)
	private String updateUser;

	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/**
	 * 级联基础信息
	 */
	@OneToOne(fetch = FetchType.LAZY,cascade = { CascadeType.ALL }, mappedBy = "userAddInfo")
	private HumanBasicInfo humanBasicInfo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public Integer getUserPerson() {
		return userPerson;
	}

	public void setUserPerson(Integer userPerson) {
		this.userPerson = userPerson;
	}

	public Integer getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(Integer userCompany) {
		this.userCompany = userCompany;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Integer getUserDelete() {
		return userDelete;
	}

	public void setUserDelete(Integer userDelete) {
		this.userDelete = userDelete;
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
	public String toString() {
		return "UserAddInfo [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userSalt=" + userSalt + ", userPerson=" + userPerson + ", userCompany=" + userCompany
				+ ", userState=" + userState + ", userDelete=" + userDelete + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", updateUser=" + updateUser + ", updateTime=" + updateTime + "]";
	}
}
