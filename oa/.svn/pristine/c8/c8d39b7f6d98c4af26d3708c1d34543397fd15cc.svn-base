package com.lh.it.resource.utils.wechat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.URL;
import java.security.KeyStore;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import sun.text.normalizer.RangeValueIterator.Element;

/**
 * 微信转账，http带签名请求
 * @author ligp
 * @date 2015-12-28
 */
@SuppressWarnings("deprecation")
public class HttpClientCustomSSL {
	/**
	 * httpClient 带证书请求，该方法亲测使用，下面两种，一个是不同请求方式，另一个是不同参数封装方法，编码都有问题，没空测。
	 * @param parms
	 * @return  处理过的xml格式字符
	 * @throws Exception
	 */
	public static String httpClientResult(TreeMap<String, String> parms) throws Exception{
		StringBuffer reultBuffer = new StringBuffer();
	
		String requestXML = XMLUtil.getRequestXml(parms);// 封装好的请求XML
		SSLConnectionSocketFactory sslsf = ReadSSl.getInstance().readCustomSSL();//获取证书
		
		HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers");
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        StringEntity myEntity = new org.apache.http.entity.StringEntity(requestXML, WeChatConfig.CHARSET);
        myEntity.setContentType("text/xml;charset=UTF-8");
        myEntity.setContentEncoding(WeChatConfig.CHARSET);
        httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
        httpPost.setEntity(myEntity);
        
        CloseableHttpResponse response      = null;
        InputStream inputStream		        = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader       = null;
        try {
        	response = httpclient.execute(httpPost);
        	HttpEntity entity = response.getEntity();
			if (entity!=null){
				inputStream = entity.getContent();
				inputStreamReader = new InputStreamReader(inputStream, WeChatConfig.CHARSET);
				bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					reultBuffer.append(str);
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			// 释放资源
			httpclient.close();
			response.close();
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
		}
        System.out.println("httpclient结果:"+reultBuffer.toString());
        return reultBuffer.toString();
	}
	
	/**
	 * httpClient 带证书请求，该方法亲测使用，下面两种，一个是不同请求方式，另一个是不同参数封装方法，编码都有问题，没空测。
	 * @param parms
	 * @return  处理过的xml格式字符
	 * @throws Exception
	 */
	public static String POST(TreeMap<String, String> parms) throws Exception{
		StringBuffer reultBuffer = new StringBuffer();
	
		String requestXML = XMLUtil.getRequestXml(parms);// 封装好的请求XML
		SSLConnectionSocketFactory sslsf = ReadSSl.getInstance().readCustomSSL();//获取证书
		
		HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        StringEntity myEntity = new org.apache.http.entity.StringEntity(requestXML, WeChatConfig.CHARSET);
        myEntity.setContentType("text/xml;charset=UTF-8");
        myEntity.setContentEncoding(WeChatConfig.CHARSET);
        httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
        httpPost.setEntity(myEntity);
        
        CloseableHttpResponse response      = null;
        InputStream inputStream		        = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader       = null;
        try {
        	response = httpclient.execute(httpPost);
        	HttpEntity entity = response.getEntity();
			if (entity!=null){
				inputStream = entity.getContent();
				inputStreamReader = new InputStreamReader(inputStream, WeChatConfig.CHARSET);
				bufferedReader = new BufferedReader(inputStreamReader);
				String str = null;
				while ((str = bufferedReader.readLine()) != null) {
					reultBuffer.append(str);
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			// 释放资源
			httpclient.close();
			response.close();
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
		}
        return reultBuffer.toString();
	}
}
