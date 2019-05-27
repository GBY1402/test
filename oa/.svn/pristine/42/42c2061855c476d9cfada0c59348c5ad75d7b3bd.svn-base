package com.lh.it.resource.utils.wechat.com.weichat.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.lh.it.resource.company.entity.HRDetailedInfo;
import com.lh.it.resource.person.entity.PersonDetailedInfo;
import com.lh.it.resource.utils.wechat.WeCahtPayController;
import com.lh.it.resource.utils.wechat.WeChatConfig;
import com.lh.it.resource.utils.wechat.WeChatUtil;
import com.lh.it.resource.utils.wechat.XMLUtil;
import com.lh.it.resource.utils.wechat.com.weichat.domain.UniteOrderResult;
import com.lh.it.resource.utils.wechat.com.weichat.domain.UntilOrder;
import com.lh.it.resource.utils.wechat.com.weichat.domain.WechatPay;
import com.lijing.wechatpay.conn.PaymentTools;
import com.lijing.wechatpay.impl.PayImpl;
import com.lijing.wechatpay.util.PayMD5;

public class WeiXinPayController {
   //微信统一下单接口
   private static String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
   
   public static void main(String[] args) {
	   UntilOrder UntilOrder=  getOrderurl("1");
	   String reqXML = PayImpl.generateXML(UntilOrder, "RlmhnhW6b0sGjeTBFcrUdLtsoCiqBwxE");
	   String respXML = PayImpl.requestWechat(ORDER_URL, reqXML);
	  System.out.println( respXML);
   }
   
   /**
	 * 微信授权后的回调地址的方法
	 * @param code
	 * @param response
	 */
   public static String authorize(String bigDecimal) {
		String code = "test";
		String access_token_uri = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		String appid = "wx917cd669ecda2888";
		String secret = "10c1ba397aa6cc91425fb00653beb478 ";
		access_token_uri = access_token_uri.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
		System.out.println(access_token_uri);
		UntilOrder order = getOrderurl(bigDecimal);
		String reqXML = PayImpl.generateXML(order, "RlmhnhW6b0sGjeTBFcrUdLtsoCiqBwxE");
		String respXML = PayImpl.requestWechat(ORDER_URL, reqXML);
		UniteOrderResult result = (UniteOrderResult) PayImpl.turnObject(UniteOrderResult.class, respXML);
		return result.getCode_url();
//		getWechatPay(result);
   }
   
   /**
	 * 对回调地址进行encode
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source){
       String result = source;
       try {
               result = java.net.URLEncoder.encode(source,"utf-8");
               System.out.println("result=  "+result);
       } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
       }
       return result;
	}
   //生成订单
   public static UntilOrder getOrderurl(String bigDecimal){
	   UntilOrder untilOrder = new UntilOrder();
	   untilOrder.setAppid("wx917cd669ecda2888");
	   untilOrder.setMch_id("1508632871"); //商户号
	   untilOrder.setDevice_info("WEB");
	   untilOrder.setNonce_str(PayMD5.GetMD5nonce_str());     //随机字符串
	   untilOrder.setBody("为提现充值：");
	   untilOrder.setDetail("充值"+"0.1"+"元");
	   untilOrder.setOut_trade_no(PaymentTools.businessOrderNumber());    //商户订单号
	   untilOrder.setFee_type("CNY");
	   untilOrder.setTotal_fee("1");
	   untilOrder.setSpbill_create_ip(PaymentTools.getServerIP());    //终端id
	   untilOrder.setNotify_url("https://www.baidu.com");
	   untilOrder.setTrade_type("NATIVE");
	   return untilOrder ;
   }
   
	public static WechatPay getWechatPay(UniteOrderResult result){
		UntilOrder untilOrder=getOrderurl("3");
		WechatPay wechatPay = new WechatPay();
		wechatPay.setAppId(untilOrder.getAppid());
		wechatPay.setNonceStr(PayMD5.GetMD5nonce_str());
		wechatPay.setSignType("MD5");
		wechatPay.setPrepay_id("prepay_id="+untilOrder.getMch_id());
		wechatPay.setTimeStamp(PaymentTools.getTimeStamp());
		String sign = PayImpl.paySign(wechatPay, "RlmhnhW6b0sGjeTBFcrUdLtsoCiqBwxE");
		wechatPay.setPaySign(sign);
		wechatPay.setPaySign(sign);
		return wechatPay ;
	}
	/**
	 * 个人提现
	 * @param personDetailedInfo
	 * @return
	 */
	public static Map<String, Object> payment(PersonDetailedInfo personDetailedInfo) {
//		PersonWallectDetailedInfo personWallectDetailedInfo=personWallectDetailedInfoService.findOne(id);
		TreeMap<String, String> parms=new TreeMap<String, String>();
		parms.put("mch_appid", WeChatConfig.MCH_APPID); // 微信分配的公众账号ID（企业号corpid即为此appId）
		parms.put("mchid", WeChatConfig.MCHID);// 微信支付分配的商户号
		parms.put("nonce_str", WeChatUtil.getNonceStr()); // 随机字符串，不长于32位
		parms.put("partner_trade_no", WeChatUtil.getPartnerTradeNo("5454545")); // 商户订单号，需保持唯一性
		parms.put("openid", personDetailedInfo.getWalletInfo().getWeChat()); // 商户appid下，某用户的openid 
		parms.put("check_name", "NO_CHECK"); // NO_CHECK：不校验真实姓名
//		// FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
//		// OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
		BigDecimal amount  =new BigDecimal(1);
		parms.put("amount", WeChatUtil.bigDecimalToPoint(amount)); // 企业付款金额，单位为分
		parms.put("desc", "用户体现"); // 企业付款操作说明信息。必填。
		parms.put("spbill_create_ip", PaymentTools.getServerIP()); // 调用接口的机器Dip地址 
		try {
			String result=WeCahtPayController.transfers(parms);	
			Map<String, Object> resultMaps =  XMLUtil.doXMLParse(result);
			String err_code_des=(String) resultMaps.get("err_code_des");
			String return_msg=(String) resultMaps.get("return_msg");
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("err_code_des", err_code_des);
			map.put("return_msg", return_msg);
		return map;
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * HR提现
	 * @param personDetailedInfo
	 * @return
	 */
	public static Map<String, Object> payment(HRDetailedInfo hrDetailedInfo) {
//		PersonWallectDetailedInfo personWallectDetailedInfo=personWallectDetailedInfoService.findOne(id);
		TreeMap<String, String> parms=new TreeMap<String, String>();
		parms.put("mch_appid", WeChatConfig.MCH_APPID); // 微信分配的公众账号ID（企业号corpid即为此appId）
		parms.put("mchid", WeChatConfig.MCHID);// 微信支付分配的商户号
		parms.put("nonce_str", WeChatUtil.getNonceStr()); // 随机字符串，不长于32位
		parms.put("partner_trade_no", WeChatUtil.getPartnerTradeNo("5454545")); // 商户订单号，需保持唯一性
		parms.put("openid", hrDetailedInfo.getEnterHRWalletInfo().getWeChat()); // 商户appid下，某用户的openid 
		parms.put("check_name", "NO_CHECK"); // NO_CHECK：不校验真实姓名
//		// FORCE_CHECK：强校验真实姓名（未实名认证的用户会校验失败，无法转账）
//		// OPTION_CHECK：针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
		BigDecimal amount  =new BigDecimal(1);
		parms.put("amount", WeChatUtil.bigDecimalToPoint(amount)); // 企业付款金额，单位为分
		parms.put("desc", "用户体现"); // 企业付款操作说明信息。必填。
		parms.put("spbill_create_ip", PaymentTools.getServerIP()); // 调用接口的机器Dip地址 
		try {
			String result=WeCahtPayController.transfers(parms);	
			Map<String, Object> resultMaps =  XMLUtil.doXMLParse(result);
			String err_code_des=(String) resultMaps.get("err_code_des");
			String return_msg=(String) resultMaps.get("return_msg");
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("err_code_des", err_code_des);
			map.put("return_msg", return_msg);
		return map;
		} catch (Exception e) {
		}
		return null;
	}
	
}
