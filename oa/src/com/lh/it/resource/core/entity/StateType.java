package com.lh.it.resource.core.entity;
/**
 * @author hejie
 */
public enum StateType {


	/**
	 * INJOB("在职"),
	 */
	INJOB("在职"), 
	/**
	 * OUTJOB("离职")
	 */
	OUTJOB("离职"), 
	/**
	 * LEAVEJOB("停薪留职")
	 */
	LEAVEJOB("停薪留职"), 
	/**
	 * OUTPAYJOB("停职留薪")
	 */
	OUTPAYJOB("停职留薪");
	
	

	private final String info;

	private StateType(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

}
