package com.lh.it.resource.core.entity;

/**
 * 
 * @author hejie
 * 
 */
public enum RecruitmentChannelType {

	/**
	 * 0.网络招聘
	 */

	NET("网络招聘"), 
	/**
	 * SCHOOL("校园招聘")
	 */
	SCHOOL("校园招聘"), 
	/**
	 * INNER("内部推荐")
	 */
	INNER("内部推荐"), 
	/**
	 * Header("猎头推荐")
	 */
	Header("猎头推荐"), 
	/**
	 * Other("其他");
	 */
	Other("其他");

	private final String info;//

	private RecruitmentChannelType(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

}
