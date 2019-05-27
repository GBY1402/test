package com.lh.it.resource.company.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
* @Description: 求职信息基础表
* @author: GBY
* @date: 2018年12月13日下午4:32:44
 */
@Entity
@Table(name = "JOB_WANFED_INFO")
public class JobWanfedInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "JOB_WANFED_ID", length = 128)
	private String jobWanfedId;
	
	/**
	 * 	职位类型0、普通，1、急聘，2、猎聘
	 */
	@Column(name = "JOB_ATTRIBUTE", length = 4)
	private Integer jobAttribute;
	
	/**
	 * 	普通招聘类型0、全职，1、兼职, 2、实习
	 */
	@Column(name = "JOB_TYPE", length = 4)
	private Integer jobType;
	
	/**
	 * 	职称 废弃字段
	 */
    @Column(name = "JOB_POSITION", length = 60)
    private String jobPosition;
    
    /**
	 * 	全职薪资起
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "FULL_PAY_START")
    private BasicsDataInfo fullPayStart;
    
    /**
	 * 	全职薪资结
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "FULL_PAY_END")
    private BasicsDataInfo fullPayEnd;
    
    /**
	 * 	兼职工作种类0，长期兼职 1、短期兼职、2、兼职实习
	 */
	@Column(name = "WORK_TYPE", length = 4)
	private Integer workType;
    
    /**
	 * 	兼职薪资
	 */
    @Column(name = "PART_JOB_PAY", length = 10)
    private String partJobPay;
    
    /**
	 * 	兼职薪资单位
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "PART_COM_PAY")
    private BasicsDataInfo partComPay;
    
    /**
	 * 	人数 (全职不写人数)
	 */
    @Column(name = "NUMBER_JOB", length = 10)
    private String numberJob;
    
    /**
	 * 	学历
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "EDUCATION_JOB")
    private BasicsDataInfo educationJob;
    
    /**
	 * 	年限要求
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "WORK_JOB_LIFE")
    private BasicsDataInfo workJobLife;
    
	/**
	 * 	急聘与猎聘佣金 (普通招聘没有)
	 */
	@Column(name = "COMMISSION")
	private BigDecimal commission = new BigDecimal(0.00);
	
	/**
	 * 	到岗开始时间 (只有急聘有)
	 */
	@Column(name = "WORK_ARRIVAL_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workArrivalStart;
	
	/**
	 * 	到岗结束时间 (只有急聘有)
	 */
	@Column(name = "WORK_ARRIVAL_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workArrivalEnd;
	
    /**
     * 	职位技能
     */
    @OneToMany(mappedBy = "jobWanfedInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<JobSkillInfo> jObSkillsList = Lists.newArrayList();
    
    /**
     * 	工作福利
     */
    @OneToMany(mappedBy = "jobWanfedInfo", fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.ALL })
	private List<JobWelfareInfo> jObWelfareList = Lists.newArrayList();
    
    /**
	 * 	工作地址
	 */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORK_ARDESS")
    private RegionAllInfo workArdess;
    
    /**
	 * 	详细地址
	 */
	@Column(name = "WORK_ARDESS_DE", length = 60)
	private String workArdessDe;
	
    /**
	 * 	工作地点X轴
	 */
	@Column(name = "WORK_ARDESS_X")
	private BigDecimal workArdessX = new BigDecimal(0.0000000);
	
	/**
	 * 	工作地点Y轴
	 */
	@Column(name = "WORK_ARDESS_Y")
	private BigDecimal workArdessY = new BigDecimal(0.0000000);
	
	/**
	 * 	行业
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORK_INDUSTRY")
	private FunctionInfo workIndustry;
	
	/**
	 * 	职能
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WORK_FUNCTION")
	private FunctionInfo workFunction;
    
	/**
	 * 	工作开始日期（兼职）
	 */
	@Column(name = "WORK_DATE_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDateStart;
	
	/**
	 * 	工作结束日期（兼职）
	 */
	@Column(name = "WORK_DATE_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDateEnd;
	//column8.ControlSource ="STR(HOUR(kt_dbf.实际上班),2)+':'+STR(MINUTE(kt_dbf.实际上班),2)"
	/**
	 * 	工作开始时间（兼职）
	 */
	@Column(name = "WORK_SHIFT_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workShiftStart;
	
	/**
	 * 	工作结束时间（兼职）
	 */
	@Column(name = "WORK_SHIFT_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date workShiftEnd;
	
	/**
	 * 	结算方式（兼职）
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "WORK_METHOD_SETTLE")
    private BasicsDataInfo workMethodSettle;
    
    /**
     *	性别要求（1、不限，2、只限女性，3、只限男性）（兼职）
     */
    @Column(name = "WORK_REQUIT_SEX", length = 4)
	private Integer workRequitSex = 1;
    
    /**
	 * 	时间要求（兼职）
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "WORK_REQUIT_DATA")
    private BasicsDataInfo workRequitData;
	
    /**
	 * 	年龄开始要求（兼职）
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "START_AGE_JOB")
    private BasicsDataInfo startAgeJob;
    /**
	 * 	年龄结束要求（兼职）
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "END_AGE_JOB")
    private BasicsDataInfo endAgeJob;
    
    /**
     * 	 职位描述(岗位职责)
     */
    @Column(name = "JOB_DESCRIBE", length = 255)
	private String jobDescribe;
    
    /**
     * 	 职位描述(任职要求) 废弃的字段
     */
    @Column(name = "JOB_REQUIRE", length = 255)
	private String jobRequire;
    
    /**
	 * 	求职状态 1 招聘中 0 停止招聘 2保存
	 */
	@Column(name = "JOB_CONDITION", length = 4)
	private Integer jobCondition = 1;
	
    /**
	 * 	删除(0、未删除，1、已删除)
	 */
    @Column(name = "JOB_DELETE", length = 4)
    private Integer jobDelete = 0;
    
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
	 * 	对应HR信息
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_PER_ID")
    private EnterPersonInfo enterPersonInfo;
    
    /**
	 * 	对应企业信息
	 */
    @ManyToOne(fetch = FetchType.LAZY)
  	@JoinColumn(name = "ENTER_ID")
    private EnterBasicInfo enterBasicInfo;

	public String getJobWanfedId() {
		return jobWanfedId;
	}

	public void setJobWanfedId(String jobWanfedId) {
		this.jobWanfedId = jobWanfedId;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public BasicsDataInfo getFullPayStart() {
		return fullPayStart;
	}

	public void setFullPayStart(BasicsDataInfo fullPayStart) {
		this.fullPayStart = fullPayStart;
	}

	public BasicsDataInfo getFullPayEnd() {
		return fullPayEnd;
	}

	public void setFullPayEnd(BasicsDataInfo fullPayEnd) {
		this.fullPayEnd = fullPayEnd;
	}

	public String getPartJobPay() {
		return partJobPay;
	}

	public void setPartJobPay(String partJobPay) {
		this.partJobPay = partJobPay;
	}

	public BasicsDataInfo getPartComPay() {
		return partComPay;
	}

	public void setPartComPay(BasicsDataInfo partComPay) {
		this.partComPay = partComPay;
	}

	public String getNumberJob() {
		return numberJob;
	}

	public void setNumberJob(String numberJob) {
		this.numberJob = numberJob;
	}

	public BasicsDataInfo getEducationJob() {
		return educationJob;
	}

	public void setEducationJob(BasicsDataInfo educationJob) {
		this.educationJob = educationJob;
	}

	public BasicsDataInfo getWorkJobLife() {
		return workJobLife;
	}

	public void setWorkJobLife(BasicsDataInfo workJobLife) {
		this.workJobLife = workJobLife;
	}

	public List<JobSkillInfo> getjObSkillsList() {
		return jObSkillsList;
	}

	public void setjObSkillsList(List<JobSkillInfo> jObSkillsList) {
		this.jObSkillsList = jObSkillsList;
	}

	public List<JobWelfareInfo> getjObWelfareList() {
		return jObWelfareList;
	}

	public void setjObWelfareList(List<JobWelfareInfo> jObWelfareList) {
		this.jObWelfareList = jObWelfareList;
	}

	public RegionAllInfo getWorkArdess() {
		return workArdess;
	}

	public void setWorkArdess(RegionAllInfo workArdess) {
		this.workArdess = workArdess;
	}

	public String getWorkArdessDe() {
		return workArdessDe;
	}

	public void setWorkArdessDe(String workArdessDe) {
		this.workArdessDe = workArdessDe;
	}

	public BigDecimal getWorkArdessX() {
		return workArdessX;
	}

	public void setWorkArdessX(BigDecimal workArdessX) {
		this.workArdessX = workArdessX;
	}

	public BigDecimal getWorkArdessY() {
		return workArdessY;
	}

	public void setWorkArdessY(BigDecimal workArdessY) {
		this.workArdessY = workArdessY;
	}

	public FunctionInfo getWorkIndustry() {
		return workIndustry;
	}

	public void setWorkIndustry(FunctionInfo workIndustry) {
		this.workIndustry = workIndustry;
	}

	public FunctionInfo getWorkFunction() {
		return workFunction;
	}

	public void setWorkFunction(FunctionInfo workFunction) {
		this.workFunction = workFunction;
	}

	public Date getWorkDateStart() {
		return workDateStart;
	}

	public void setWorkDateStart(Date workDateStart) {
		this.workDateStart = workDateStart;
	}

	public Date getWorkDateEnd() {
		return workDateEnd;
	}

	public void setWorkDateEnd(Date workDateEnd) {
		this.workDateEnd = workDateEnd;
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

	public BasicsDataInfo getWorkMethodSettle() {
		return workMethodSettle;
	}

	public void setWorkMethodSettle(BasicsDataInfo workMethodSettle) {
		this.workMethodSettle = workMethodSettle;
	}

	public Integer getWorkRequitSex() {
		return workRequitSex;
	}

	public void setWorkRequitSex(Integer workRequitSex) {
		this.workRequitSex = workRequitSex;
	}

	public BasicsDataInfo getWorkRequitData() {
		return workRequitData;
	}

	public void setWorkRequitData(BasicsDataInfo workRequitData) {
		this.workRequitData = workRequitData;
	}

	public BasicsDataInfo getStartAgeJob() {
		return startAgeJob;
	}

	public void setStartAgeJob(BasicsDataInfo startAgeJob) {
		this.startAgeJob = startAgeJob;
	}

	public BasicsDataInfo getEndAgeJob() {
		return endAgeJob;
	}

	public void setEndAgeJob(BasicsDataInfo endAgeJob) {
		this.endAgeJob = endAgeJob;
	}

	public String getJobDescribe() {
		return jobDescribe;
	}

	public void setJobDescribe(String jobDescribe) {
		this.jobDescribe = jobDescribe;
	}

	public Integer getJobDelete() {
		return jobDelete;
	}

	public void setJobDelete(Integer jobDelete) {
		this.jobDelete = jobDelete;
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

	public EnterPersonInfo getEnterPersonInfo() {
		return enterPersonInfo;
	}

	public void setEnterPersonInfo(EnterPersonInfo enterPersonInfo) {
		this.enterPersonInfo = enterPersonInfo;
	}

	public Integer getJobCondition() {
		return jobCondition;
	}

	public void setJobCondition(Integer jobCondition) {
		this.jobCondition = jobCondition;
	}

	public EnterBasicInfo getEnterBasicInfo() {
		return enterBasicInfo;
	}

	public void setEnterBasicInfo(EnterBasicInfo enterBasicInfo) {
		this.enterBasicInfo = enterBasicInfo;
	}

	public Integer getJobType() {
		return jobType;
	}

	public void setJobType(Integer jobType) {
		this.jobType = jobType;
	}

	public Integer getWorkType() {
		return workType;
	}

	public void setWorkType(Integer workType) {
		this.workType = workType;
	}

	public String getJobRequire() {
		return jobRequire;
	}

	public void setJobRequire(String jobRequire) {
		this.jobRequire = jobRequire;
	}

	public Integer getJobAttribute() {
		return jobAttribute;
	}

	public void setJobAttribute(Integer jobAttribute) {
		this.jobAttribute = jobAttribute;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public Date getWorkArrivalStart() {
		return workArrivalStart;
	}

	public void setWorkArrivalStart(Date workArrivalStart) {
		this.workArrivalStart = workArrivalStart;
	}

	public Date getWorkArrivalEnd() {
		return workArrivalEnd;
	}

	public void setWorkArrivalEnd(Date workArrivalEnd) {
		this.workArrivalEnd = workArrivalEnd;
	}
	
}
