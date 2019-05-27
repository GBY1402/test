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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import com.google.common.collect.Lists;
import com.lh.it.resource.common.entity.BasicsDataInfo;
import com.lh.it.resource.common.entity.FunctionInfo;
import com.lh.it.resource.common.entity.RegionAllInfo;
/**
 * @version:
* @Description: 个人求职基础数据表
* @author: GBY
* @date: 2018年12月18日下午1:32:39
 */
@Entity
@Table(name = "PERSON_JOB_INFO")
public class PersonJobInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "PERSON_JOB_ID", length = 128)
	private String personJobId;
	
	/**
	 * 求职类型0、全职，1、兼职
	 */
//	@Column(name = "PERSON_JOB_TYPE", length = 4)
//	private Integer personJobType;
	
	/**
	 * 职称
	 */
    @Column(name = "PERSON_JOB_NAME", length = 60)
    private String personJobName;
    
    /**
	 * 区域选择
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_WORK_ARDESS")
    private RegionAllInfo personWorkArdess;
    
    /**
	 * 	区域X轴
	 */
	@Column(name = "WORK_ARDESS_X", length = 20)
	private String workArdessX;
	
	/**
	 * 	区域Y轴
	 */
	@Column(name = "WORK_ARDESS_Y", length = 20)
	private String workArdessY;
    
    /**
	 * 全职薪资起
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "PERSON_PAY_START")
    private BasicsDataInfo personPayStart;
    
    /**
	 * 全职薪资结
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "PERSON_PAY_END")
    private BasicsDataInfo personPayEnd;
    
    /**
	 * 行业
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_INDUSTRY")
	private FunctionInfo personIndustry;
	
	/**
	 * 职能
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_FUNCTION")
	private FunctionInfo personFunction;
	
	/**
	 * 开始工作时间
	 */
	@Column(name = "PERSON_JOB_WORK")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date personJobWork;
	
	/**
	 * 	工作年数
	 */
	@Column(name = "JOB_WORK_YEAR", length = 4)
	private Integer jobWorkYear = 0;
	
	/**
	 * (全职)工作种类0、全职，1、实习，
	 */
	@Column(name = "PERSON_WORK_TYPE", length = 4)
	private Integer personWorkType;
	
	/**
	 * (全职)到岗开始时间
	 */
	@Column(name = "WORK_REPORT_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reportStart;
	
	/**
	 * (全职)到岗结束时间
	 */
	@Column(name = "WORK_REPORT_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reportEnd;
	
	/**
	 * (兼职)工作种类0、长期兼职， 1、短期兼职、2、兼职实习
	 */
	@Column(name = "PERSON_PART_TYPE", length = 4)
	private Integer personPartType;
	
	/**
	 * 	求职状态0、开，1、关
	 */
	@Column(name = "PERSON_TOGGLE", length = 4)
	private Integer personToggle = 0;
	
	/**
	 * 兼职薪资
	 */
    @Column(name = "PERSON_JOB_PAY", length = 10)
    private String personJobPay;
    
    /**
	 * 兼职薪资单位
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "PERSON_PART_PAY")
    private BasicsDataInfo personPartPay;
    
    /**
	 * 空闲时间（兼职）
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "WORK_METHOD_PERSON")
    private BasicsDataInfo workMethodPerson;
    
    /**
	 * 工作开始时间（兼职）
	 */
	@Column(name = "WORK_SHIFT_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workShiftStart;
	
	/**
	 * 工作结束时间（兼职）
	 */
	@Column(name = "WORK_SHIFT_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workShiftEnd;
	
	 /**
	 * 删除(0、未删除，1、已删除)
	 */
    @Column(name = "PERSON_DELETE_Status", length = 4)
    private Integer personDeleteStatus = 0;

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
	 * 关联个人基础信息
	 */
	@ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "HUMAN_ID")
    private HumanBasicInfo humanBasicInfo;
	
	/**
     * 	工作经历列表
     */
    @OneToMany(mappedBy = "personJobInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<PersonJobResumeInfo> resumeList = Lists.newArrayList();
    
    /**
     * 	项目经历列表
     */
    @OneToMany(mappedBy = "personJobInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<PersonJobProjectInfo> projectList = Lists.newArrayList();
    
    /**
     * 	教育经历列表
     */
    @OneToMany(mappedBy = "personJobInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<PersonJobTrainInfo> trainList = Lists.newArrayList();
    
    /**
     * 	求职技能列表
     */
    @OneToMany(mappedBy = "personJobInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<PersonJobSkillInfo> skillList = Lists.newArrayList();

	public String getPersonJobId() {
		return personJobId;
	}

	public void setPersonJobId(String personJobId) {
		this.personJobId = personJobId;
	}

	public String getPersonJobName() {
		return personJobName;
	}

	public void setPersonJobName(String personJobName) {
		this.personJobName = personJobName;
	}

	public RegionAllInfo getPersonWorkArdess() {
		return personWorkArdess;
	}

	public void setPersonWorkArdess(RegionAllInfo personWorkArdess) {
		this.personWorkArdess = personWorkArdess;
	}

	public BasicsDataInfo getPersonPayStart() {
		return personPayStart;
	}

	public void setPersonPayStart(BasicsDataInfo personPayStart) {
		this.personPayStart = personPayStart;
	}

	public BasicsDataInfo getPersonPayEnd() {
		return personPayEnd;
	}

	public void setPersonPayEnd(BasicsDataInfo personPayEnd) {
		this.personPayEnd = personPayEnd;
	}

	public FunctionInfo getPersonIndustry() {
		return personIndustry;
	}

	public void setPersonIndustry(FunctionInfo personIndustry) {
		this.personIndustry = personIndustry;
	}

	public FunctionInfo getPersonFunction() {
		return personFunction;
	}

	public void setPersonFunction(FunctionInfo personFunction) {
		this.personFunction = personFunction;
	}

	public Date getPersonJobWork() {
		return personJobWork;
	}

	public void setPersonJobWork(Date personJobWork) {
		this.personJobWork = personJobWork;
	}

	public Integer getPersonWorkType() {
		return personWorkType;
	}

	public void setPersonWorkType(Integer personWorkType) {
		this.personWorkType = personWorkType;
	}

	public Integer getPersonToggle() {
		return personToggle;
	}

	public void setPersonToggle(Integer personToggle) {
		this.personToggle = personToggle;
	}

	public String getPersonJobPay() {
		return personJobPay;
	}

	public void setPersonJobPay(String personJobPay) {
		this.personJobPay = personJobPay;
	}

	public BasicsDataInfo getPersonPartPay() {
		return personPartPay;
	}

	public void setPersonPartPay(BasicsDataInfo personPartPay) {
		this.personPartPay = personPartPay;
	}

	public BasicsDataInfo getWorkMethodPerson() {
		return workMethodPerson;
	}

	public void setWorkMethodPerson(BasicsDataInfo workMethodPerson) {
		this.workMethodPerson = workMethodPerson;
	}

	public Date getWorkShiftStart() {
		return workShiftStart;
	}

	public void setWorkShiftStart(Date workShiftStart) {
		this.workShiftStart = workShiftStart;
	}

	public Date getWorkShiftEnd() {
		return workShiftEnd;
	}

	public void setWorkShiftEnd(Date workShiftEnd) {
		this.workShiftEnd = workShiftEnd;
	}

	public Integer getPersonDeleteStatus() {
		return personDeleteStatus;
	}

	public void setPersonDeleteStatus(Integer personDeleteStatus) {
		this.personDeleteStatus = personDeleteStatus;
	}

	public HumanBasicInfo getHumanBasicInfo() {
		return humanBasicInfo;
	}

	public void setHumanBasicInfo(HumanBasicInfo humanBasicInfo) {
		this.humanBasicInfo = humanBasicInfo;
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

	public List<PersonJobResumeInfo> getResumeList() {
		return resumeList;
	}

	public void setResumeList(List<PersonJobResumeInfo> resumeList) {
		this.resumeList = resumeList;
	}

	public List<PersonJobProjectInfo> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<PersonJobProjectInfo> projectList) {
		this.projectList = projectList;
	}

	public List<PersonJobTrainInfo> getTrainList() {
		return trainList;
	}

	public void setTrainList(List<PersonJobTrainInfo> trainList) {
		this.trainList = trainList;
	}

	public List<PersonJobSkillInfo> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<PersonJobSkillInfo> skillList) {
		this.skillList = skillList;
	}

	public Integer getPersonPartType() {
		return personPartType;
	}

	public void setPersonPartType(Integer personPartType) {
		this.personPartType = personPartType;
	}

	public Integer getJobWorkYear() {
		return jobWorkYear;
	}

	public void setJobWorkYear(Integer jobWorkYear) {
		this.jobWorkYear = jobWorkYear;
	}

	public Date getReportStart() {
		return reportStart;
	}

	public void setReportStart(Date reportStart) {
		this.reportStart = reportStart;
	}

	public Date getReportEnd() {
		return reportEnd;
	}

	public void setReportEnd(Date reportEnd) {
		this.reportEnd = reportEnd;
	}

	public String getWorkArdessX() {
		return workArdessX;
	}

	public void setWorkArdessX(String workArdessX) {
		this.workArdessX = workArdessX;
	}

	public String getWorkArdessY() {
		return workArdessY;
	}

	public void setWorkArdessY(String workArdessY) {
		this.workArdessY = workArdessY;
	}
}
