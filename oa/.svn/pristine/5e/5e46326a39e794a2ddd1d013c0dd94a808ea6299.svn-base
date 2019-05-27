package com.lh.it.resource.person.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import com.google.common.collect.Lists;
import com.lh.it.resource.company.entity.JobWanfedInfo;

/**
 * @version:
* @Description: 职位简历中间表
* @author: GBY
* @date: 2018年12月21日下午4:43:03
 */
@Entity
@Table(name = "JOBPER_CENTRE_INFO")
public class JobperCentreInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "CENTRE_ID", length = 128)
	private String centreId;
	
	/**
	 *	求职基础数据表
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_JOB_ID")
    private PersonJobInfo personJobInfo;
    
    /**
	 *	职位基础数据表
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_WANFED_ID")
    private JobWanfedInfo jobWanfedInfo;
    
    /**
   	 * 	删除(0、未删除，1、已删除) 后台
   	 */
	@Column(name = "DELETE_CENTRE", length = 4)
	private Integer deleteCentre = 0;
	
	/**
   	 * 	删除(0、未删除，1、已删除) 个人
   	 */
	@Column(name = "DELETE_PERSON", length = 4)
	private Integer deletePerson = 0;
	
	/**
   	 * 	删除(0、未删除，1、已删除) 公司
   	 */
	@Column(name = "DELETE_ENTER", length = 4)
	private Integer deleteEnter = 0;
	
	/**
	 * 	中间属性名称
	 */
	@Column(name = "TYPE_NAME", length = 20)
	private String typeName;
	
	/**
   	 * 	属性0、已投递，1、已查看，2、邀请面试，3、同意面试，4、拒绝面试，5、不合适，6、已成功
   	 */
	@Column(name = "CENTER_AUDITION", length = 4)
	private Integer centerAudition;
	
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
	 * 	修改时间
	 */
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/**
     * 消息列表
     */
    @OneToMany(mappedBy = "jobperCentreInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<JobperNewsInfo> jobperNewsList = Lists.newArrayList();

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public PersonJobInfo getPersonJobInfo() {
		return personJobInfo;
	}

	public void setPersonJobInfo(PersonJobInfo personJobInfo) {
		this.personJobInfo = personJobInfo;
	}

	public JobWanfedInfo getJobWanfedInfo() {
		return jobWanfedInfo;
	}

	public void setJobWanfedInfo(JobWanfedInfo jobWanfedInfo) {
		this.jobWanfedInfo = jobWanfedInfo;
	}

	public Integer getDeleteCentre() {
		return deleteCentre;
	}

	public void setDeleteCentre(Integer deleteCentre) {
		this.deleteCentre = deleteCentre;
	}

	public Integer getDeletePerson() {
		return deletePerson;
	}

	public void setDeletePerson(Integer deletePerson) {
		this.deletePerson = deletePerson;
	}

	public Integer getDeleteEnter() {
		return deleteEnter;
	}

	public void setDeleteEnter(Integer deleteEnter) {
		this.deleteEnter = deleteEnter;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getCenterAudition() {
		return centerAudition;
	}

	public void setCenterAudition(Integer centerAudition) {
		this.centerAudition = centerAudition;
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

	public List<JobperNewsInfo> getJobperNewsList() {
		return jobperNewsList;
	}

	public void setJobperNewsList(List<JobperNewsInfo> jobperNewsList) {
		this.jobperNewsList = jobperNewsList;
	}
	
}
