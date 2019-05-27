package com.lh.it.resource.common.entity;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @version:
* @Description: 省市县乡所有数据封装类
* @author: GBY
* @date: 2018年12月12日下午5:14:15
 */
@Entity
@Table(name = "REGION")
public class RegionAllInfo implements Serializable {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8024572922126416886L;
	public static final Long ROOT_NODE_ID = 1L;
	/**
	 * 主键（区域编号）
	 */
	@Id
	@Column(name = "REGION_ID")
	private Long regionId;
	/**
	 * 区域名称
	 */
	@Column(name = "REGION_NAME", length = 100)
	private String regionName;
	/**
	 * 自关联（树形数据存储方式）（上一级区域编号）
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARENT_ID")
	private RegionAllInfo parentId;
	/**
	 * 短名称
	 */
	@Column(name = "SHORT_NAME", length = 50)
	private String shortName;
	/**
	 * 邮政编码
	 */
	@Column(name = "ZIPCODE", length = 10)
	private int zipcode;
	/**
	 * 区域拼音
	 */
	@Column(name = "PINYIN", length = 100)
	private String pinyin;
	/**
	 * 长
	 */
	@Column(name = "LNG", length = 20)
	private String lng;
	/**
	 * 短
	 */
	@Column(name = "LAT", length = 20)
	private String lat;
	/**
	 * 等级
	 */
	@Column(name = "LEVEL", length = 20)
	private int level;
	/**
	 * 父类字符串全称（例：北京市、市辖区、东城区：tr_0 tr_110000 tr_110100）
	 */
	@Column(name = "POSITION", length = 255)
	private String position;
	/**
	 * 创建时间（用int表示）
	 */
	@Column(name = "CREATE_TIME", length = 255)
	private int createTime;
	/**
	 * 修改时间（用int表示）
	 */
	@Column(name = "UPDATE_TIME", length = 255)
	private int updateTime;
	
	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public RegionAllInfo getParentId() {
		return parentId;
	}

	public void setParentId(RegionAllInfo parentId) {
		this.parentId = parentId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "RegionAllInfo [regionId=" + regionId + ", regionName="
				+ regionName + ", parentId=" + parentId + ", shortName="
				+ shortName + ", zipcode=" + zipcode + ", pinyin=" + pinyin
				+ ", lng=" + lng + ", lat=" + lat + ", level=" + level
				+ ", position=" + position + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

	public static String toJsonStr(Iterator<RegionAllInfo> iter) {
		StringBuffer val = new StringBuffer("[");
		while (iter.hasNext()) {
			RegionAllInfo fun = iter.next();
			val.append("{\"id\":");
			val.append(fun.getRegionId());
			val.append(",\"pid\":");
			val.append(fun.getParentId() == null ? 0 : fun.getParentId().getRegionId());
			val.append(",\"name\":\"");
			val.append(fun.getRegionName());
			val.append("\",\"isParent\":");
			val.append(fun.getLevel()==5?"false":"true");
			val.append("},");
		}
		int start = val.lastIndexOf(",") < 1 ? val.length() : val
				.lastIndexOf(",");
		val.replace(start, val.length(), "]");
		return val.toString();
	}
}
