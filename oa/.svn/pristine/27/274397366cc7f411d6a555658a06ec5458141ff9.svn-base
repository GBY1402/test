package com.lh.it.resource.utils.wechat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;



public class WeCahtPayController  {
	

	/**
	 * 批量转账
	 * @throws Exception 
	 */
	public static String transfers(TreeMap<String, String> parms ) throws Exception{
//		String uiid 	   = null;//用户ID
//		Map<String, String> map = null;
//		List<Map<String, String>> list =  new ArrayList<Map<String, String>>();
			parms.put("sign", SignTools.buildRequestMysign(parms));//签名
			
			String resultXML = HttpClientCustomSSL.httpClientResult(parms);//转账
//			Map<String, Object> resultMap =  XMLUtil.doXMLParse(resultXML);
            return resultXML;
		}
	
}
