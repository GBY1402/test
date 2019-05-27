package com.lh.it.resource.utils.wechat;

public class WeChatConfig {
	//请求接口
	public static final String  POST_URL ="https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	public static final String  CHARSET = "UTF-8";//编码格式
	//证书存放目录
//	public static final String  CA_LICENSE = "D:/winxin/person/apiclient_cert.p12";
	
	public static final String  CA_LICENSE = "D:/apiclient_cert.p12";
	
	//注意商户平台需要与微信公众号有关联。通常申请流程是从公众号->微信支付，进入申请
	//商户apikey
	//32位，，登录商户平台（账号格式为：129******@129******，密码通常六位）-》账户设置-》API安全-》设置API密钥
	public static final String  API_KEY = "RlmhnhW6b0sGjeTBFcrUdLtsoCiqBwxE";//1
	public static final String  COMPANY_KEY = "RJH8u5p3Pa0IlRE8AlFdCcLXzui62Qhe";//2
	//商户平台：https://pay.weixin.qq.com/index.php/home/login
	//商户平台号
	public static final String  MCHID = "1508632871";//1
	public static final String  CPMPANY_MCHID = "1508619761";//2
	
	//微信公众平台appid
	public static final String  MCH_APPID = "wx917cd669ecda2888";//1
	public static final String  CPMPANY_APPID = "wx5232bc0bf446635e";//2
	//公众号网址：https://mp.weixin.qq.com/wx917cd669ecda2888
	
}
