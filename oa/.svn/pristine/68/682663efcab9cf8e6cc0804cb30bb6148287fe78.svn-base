package com.lh.it.resource.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.lh.it.resource.security.entity.main.Organization;

/**
 * 员工信息
 * 
 * @author zhoushuai@189.cn
 * 
 */
@Entity
@Table(name = "CORE_EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 状态为有年假 */
	public static final int IS_YEAR_LEAVE = 1;

	/** 状态为无年假 */
	public static final int NOT_YEAR_LEAVE = 2;

	
	/**	已转正 */
	public static final int IS_ORREGULAR = 1;
	/** 未转正 */
	public static final int NOT_ORREGULAR = 2;
	
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	// name:属性生成器的名字. strategy:属性指定具体生成器的类名.
	@GeneratedValue(generator = "systemUUID")
	/**
	 * @Column(
		name = 可选，列名（默认值为属性名）。
		unique = 可选，是否在该列上设置唯一约束（默认false）。
		nullable = 可选，是否设置该列的值可以为空（默认true）。
		insertable = 可选，该列是否作为生成的insert语句中的一列（默认true）。
		updateable = 可选，该列是否作为生成的update语句中的一列（默认true）。
		length  = 可选，列长度（默认255）。
		precision = 可选，列十进制精度（默认0）。
		scale = 可选，如果列十进制数值范围可用，在此设置（默认0）。
		) 
	 */
	@Column(name = "pkid", length = 128)
	private String pkid;// 员工编号
	
	@ManyToOne
	@JoinColumn(name = "ORG_ID")
	private Organization organization;//外键

	@Column(name = "jobnum", length = 20, nullable = false)
	private String jobnum;// 员工工号

	@Column(name = "NAME", length = 20, nullable = false)
	private String name;// 员工姓名

	@Column(name = "SEX", length = 10, nullable = false)
	// private SexType sex = SexType.Unknown;// 员工性别 (枚举类型)
	private Integer sex;// 性别：1.男 2.女

	@Column(name = "AGE", nullable = false)
	private Integer age;// 年龄


	@Column(name = "CONTRACTID", length = 40)
	private String contractid;// 合同编号

	@Column(name = "PHONE", length = 20, nullable = false)
	private String phone;// 联系方式

	@Column(name = "CARDID", length = 18, nullable = false)
	private String cardid;// 身份证号

	@Column(name = "ENTRYTIME", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entrytime;// 入职时间 YYYY-mm-dd
	
	
	
	//离职时间
	@Column(name = "LENVEDATETIME")
	private Date lenveDateTime;

	@Column(name = "REGULARTIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regulartime;// 转正时间
	/**
	 * 1:已转正 2:未转正
	 */
	@Column(name = "ISORREGULAR", nullable = false)
	private Integer isorregular;// 是否转正

	@Column(name = "CONTRACTSTARTTIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractstarttime;// 合同开始时间

	@Column(name = "CONTRACTENDTIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractendtime;// 合同终止时间

	@Column(name = "JOB", length = 20, nullable = false)
	private String job;// 工作岗位

	@Column(name = "SKILL", length = 100, nullable = false)
	private String skill;// 技能

	@Column(name = "TOSCHOOL", length = 50)
	private String toschool;// 毕业院校

	@Column(name = "MAJOR", length = 30)
	private String major;// 专业

	@Column(name = "BIRTHDAY", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;// 出生年月 YYYY-mm-dd

	/**
	 * 1:未婚 2:已婚
	 */
	@Column(name = "MARITALSTATUS", nullable = false)
	private Integer maritalstatus;// 婚姻状况

	@Column(name = "DOMICILEPLACE", length = 100, nullable = false)
	private String domicileplace;// 户口所在地

	@Column(name = "HOMEADDRESS", length = 100, nullable = false)
	private String homeaddress;// 家庭住址

	@Column(name = "EMERGENCYCONTACT", length = 20)
	private String emergencyContact;// 紧急联络人

	@Column(name = "EMERGENCYCONTACTPHONE", length = 20)
	private String emergencyContactphone;// 紧急联络人电话

	/**
	 * 0:网络招聘、1:校园招聘、2:内部推荐、3:猎头推荐、4:其他）
	 */
	// @Column(name="recruitmentchannel")
	// private Integer recruitmentchannel;//招聘渠道
	@Column(name = "RECRUITMENTCHANNEL", nullable = false)
	private RecruitmentChannelType recruitmentChannel = RecruitmentChannelType.Other;

	/**
	 * 0.在职 1.离职 2.停薪留职 3停职留薪
	 */
	@Column(name = "STATETYPE", nullable = false)
	// private Integer state;
	private StateType stateType = StateType.INJOB;

	/**
	 * 1:有年假 2：没有年假
	 */
	@Column(name = "isyearleave")
	private Integer isyearleave;// 是否有年假

	/**
	 * 0.大专1.本科 2.硕士3.博士4.其他
	 */
	@Column(name = "EDUCATION", nullable = false)
	private EducationType educationColl = EducationType.Other;
	
	@Column(name = "CREATEDATETIME")
	private Date createDateTime;


	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	public String getJobnum() {
		return jobnum;
	}

	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getContractid() {
		return contractid;
	}

	public void setContractid(String contractid) {
		this.contractid = contractid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Date getRegulartime() {
		return regulartime;
	}

	public void setRegulartime(Date regulartime) {
		this.regulartime = regulartime;
	}

	public Date getContractstarttime() {
		return contractstarttime;
	}

	public void setContractstarttime(Date contractstarttime) {
		this.contractstarttime = contractstarttime;
	}

	public Date getContractendtime() {
		return contractendtime;
	}

	public void setContractendtime(Date contractendtime) {
		this.contractendtime = contractendtime;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getToschool() {
		return toschool;
	}

	public void setToschool(String toschool) {
		this.toschool = toschool;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(Integer maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getDomicileplace() {
		return domicileplace;
	}

	public void setDomicileplace(String domicileplace) {
		this.domicileplace = domicileplace;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactphone() {
		return emergencyContactphone;
	}

	public void setEmergencyContactphone(String emergencyContactphone) {
		this.emergencyContactphone = emergencyContactphone;
	}

	public RecruitmentChannelType getRecruitmentChannel() {
		return recruitmentChannel;
	}

	public void setRecruitmentChannel(RecruitmentChannelType recruitmentChannel) {
		this.recruitmentChannel = recruitmentChannel;
	}

	public Integer getIsorregular() {
		return isorregular;
	}

	public void setIsorregular(Integer isorregular) {
		this.isorregular = isorregular;
	}

	public Integer getIsyearleave() {
		return isyearleave;
	}

	public void setIsyearleave(Integer isyearleave) {
		this.isyearleave = isyearleave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StateType getStateType() {
		return stateType;
	}

	public void setStateType(StateType stateType) {
		this.stateType = stateType;
	}


	public EducationType getEducationColl() {
		return educationColl;
	}

	public void setEducationColl(EducationType educationColl) {
		this.educationColl = educationColl;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Date getLenveDateTime() {
		return lenveDateTime;
	}

	public void setLenveDateTime(Date lenveDateTime) {
		this.lenveDateTime = lenveDateTime;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}


}
