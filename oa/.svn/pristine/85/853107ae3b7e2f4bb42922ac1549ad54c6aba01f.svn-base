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

import com.lh.it.resource.common.entity.BasicsDataInfo;

/**
 * @version:
* @Description: 教育经历表
* @author: GBY
* @date: 2018年12月18日下午6:04:08
 */
@Entity
@Table(name = "PERSON_JOB_TRAIN_INFO")
public class PersonJobTrainInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * ID
	 */
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "TRAIN_ID", length = 128)
	private String trainId;
	
	/**
	 *  学校名称
	 */
    @Column(name = "TRAIN_NAME", length = 60)
    private String trainName;
    
//    /**
//	 * 	学历
//	 */
//    @ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "HUMAN_DIPLOMA")
//    private BasicsDataInfo humanDiploma;
    
    /**
	 *  专业名称
	 */
    @Column(name = "TRAIN_MAJOR", length = 60)
    private String trainMajor;
    
    /**
	 *  开始时间
	 */
	@Column(name = "TRAIN_START")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date trainStart;
	
	/**
	 *  结束时间
	 */
	@Column(name = "TRAIN_END")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date trainEnd;
	
	/**
	 *  在校经历
	 */
    @Column(name = "TRAIN_EXPER", length = 255)
    private String trainExper;
    
    /**
   	 * 删除(0、未删除，1、已删除)
   	 */
    @Column(name = "TRAIN_DELETE", length = 4)
	private Integer trainDelete = 0;

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

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainMajor() {
		return trainMajor;
	}

	public void setTrainMajor(String trainMajor) {
		this.trainMajor = trainMajor;
	}

	public Date getTrainStart() {
		return trainStart;
	}

	public void setTrainStart(Date trainStart) {
		this.trainStart = trainStart;
	}

	public Date getTrainEnd() {
		return trainEnd;
	}

	public void setTrainEnd(Date trainEnd) {
		this.trainEnd = trainEnd;
	}

	public String getTrainExper() {
		return trainExper;
	}

	public void setTrainExper(String trainExper) {
		this.trainExper = trainExper;
	}

	public Integer getTrainDelete() {
		return trainDelete;
	}

	public void setTrainDelete(Integer trainDelete) {
		this.trainDelete = trainDelete;
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

//	public BasicsDataInfo getHumanDiploma() {
//		return humanDiploma;
//	}
//
//	public void setHumanDiploma(BasicsDataInfo humanDiploma) {
//		this.humanDiploma = humanDiploma;
//	}
   	
}
