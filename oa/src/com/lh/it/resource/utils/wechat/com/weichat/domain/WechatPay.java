package com.lh.it.resource.utils.wechat.com.weichat.domain;

public class WechatPay {
	/**
	 * 公众号id：企业号corpid即为此appId
	 */
	private String appId ;
	
	/**
	 * 时间戳：当前时间10位随机数
	 */
	private String timeStamp ;
	
	/**
	 * 随机字符串：32位
	 */
	private String nonceStr ;
	
	/**
	 * 订单详情扩展字符串：统一下单接口返回的prepay_id参数值，提交格式如：prepay_id=***
	 */
	private String prepay_id ;
	
	/**
	 *  签名方式：MD5
	 */
	private String signType ;
	
	/**
	 * 签名
	 */
	private String paySign ;

	public WechatPay(java.lang.String appId, java.lang.String timeStamp,
			java.lang.String nonceStr, java.lang.String prepay_id,
			java.lang.String signType, java.lang.String paySign) {
		super();
		this.appId = appId;
		this.timeStamp = timeStamp;
		this.nonceStr = nonceStr;
		this.prepay_id = prepay_id;
		this.signType = signType;
		this.paySign = paySign;
	}

	public WechatPay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

	@Override
	public String toString() {
		return "WechatPay [appId=" + appId + ", timeStamp=" + timeStamp
				+ ", nonceStr=" + nonceStr + ", prepay_id=" + prepay_id
				+ ", signType=" + signType + ", paySign=" + paySign + "]";
	}
	
	
}
