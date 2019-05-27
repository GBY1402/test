package com.lh.it.resource.apk.entity;

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
* @Description: 版本信息
* @author: GBY
* @date: 2019年1月30日下午5:46:03
 */
@Entity
@Table(name = "APK_VERSION")
public class ApkInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1916755086288476271L;
	
	@Id
	@GenericGenerator(name = "systemUUID", strategy = "uuid")
	@GeneratedValue(generator = "systemUUID")
	@Column(name = "ID", length = 128)
	private String apkId;// ID
	
	@Column(name = "APK_TYPE", length = 1)
	private String apkType;//类型0、个人安卓，1个人IOS，2、企业安卓，3企业IOS
	
	@Column(name = "STATE", length = 1)
	private String state;// 状态0、未发布，1、已发布
	
	@Column(name = "NAME", length = 128)
	private String name;//名称
	
	@Column(name = "VERSION", length = 20)
	private String version;// 版本号
	
	@Column(name = "PATH", length = 128)
	private String path;//路径
	
	@Column(name = "CREATE_NAME", length = 40)
	private String createName;// 创建人
	
	@Column(name = "CREATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime;// 创建时间
	
	@Column(name = "UPDATE_NAME", length = 40)
	private String updateName;// 修改人
	
	@Column(name = "UPDATE_TIME")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;// 修改时间

	public String getApkId() {
		return apkId;
	}

	public void setApkId(String apkId) {
		this.apkId = apkId;
	}

	public String getApkType() {
		return apkType;
	}

	public void setApkType(String apkType) {
		this.apkType = apkType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ApkInfo [apkId=" + apkId + ", apkType=" + apkType + ", state=" + state + ", name=" + name + ", version="
				+ version + ", path=" + path + ", createName=" + createName + ", createTime=" + createTime
				+ ", updateName=" + updateName + ", updateTime=" + updateTime + "]";
	}


}
