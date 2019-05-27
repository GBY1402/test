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
/**
 * @version:
* @Description: 项目经验表
* @author: GBY
* @date: 2018年12月18日下午5:52:17
 */
@Entity
@Table(name = "PERSON_JOB_PROJECT_INFO")
public class PersonJobProjectInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "PROJECT_ID", length = 128)
	private String projectId;
	
	/**
	 *  项目名称
	 */
    @Column(name = "PROJECT_NAME", length = 60)
    private String projectName;

    /**
	 *  项目职务
	 */
    @Column(name = "PROJECT_POST", length = 60)
    private String projectPost;
    
    /**
	 *  开始时间
	 */
	@Column(name = "PROJECT_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date projectStart;
	
	/**
	 *  结束时间
	 */
	@Column(name = "PROJECT_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date projectEnd;
	
	/**
	 *  项目描述
	 */
    @Column(name = "PROJECT_DESCRIBE", length = 255)
    private String projectDescribe;
    
    /**
	 *  项目业绩
	 */
    @Column(name = "PROJECT_ACHIEVE", length = 255)
    private String projectAchieve;
    
    /**
   	 * 删除(0、未删除，1、已删除)
   	 */
    @Column(name = "PROJECT_DELETE", length = 4)
	private Integer projectDelete = 0;

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
  	@Column(name = "UPDATE_USER", length = 40)
  	private String updateUser;

  	/**
  	 * 修改时间
  	 */
  	@Column(name = "UPDATE_TIME")
  	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  	private Date updateTime;
      	
    /**
   	 * 关联个人求职基础信息
   	 */
   	@ManyToOne(fetch = FetchType.LAZY)
 	@JoinColumn(name = "PERSON_JOB_ID")
   	private PersonJobInfo personJobInfo;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectPost() {
		return projectPost;
	}

	public void setProjectPost(String projectPost) {
		this.projectPost = projectPost;
	}

	public Date getProjectStart() {
		return projectStart;
	}

	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}

	public Date getProjectEnd() {
		return projectEnd;
	}

	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}

	public String getProjectDescribe() {
		return projectDescribe;
	}

	public void setProjectDescribe(String projectDescribe) {
		this.projectDescribe = projectDescribe;
	}

	public String getProjectAchieve() {
		return projectAchieve;
	}

	public void setProjectAchieve(String projectAchieve) {
		this.projectAchieve = projectAchieve;
	}

	public Integer getProjectDelete() {
		return projectDelete;
	}

	public void setProjectDelete(Integer projectDelete) {
		this.projectDelete = projectDelete;
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

	public PersonJobInfo getPersonJobInfo() {
		return personJobInfo;
	}

	public void setPersonJobInfo(PersonJobInfo personJobInfo) {
		this.personJobInfo = personJobInfo;
	}
   	
}
