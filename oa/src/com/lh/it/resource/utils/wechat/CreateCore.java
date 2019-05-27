package com.lh.it.resource.utils.wechat;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class CreateCore {
	
	 /** 
	  * 
	  * 生成二维码文件测试 
	  * @param filePath 文件路径 
	  * @param fileName 文件名 
	  * @param number 编号 
	  * @param phone 手机号 
	  * @see [类、类#方法、类#成员] 
	  */
	 public static void generatEncodeTest(String filePath, String fileName, String ss) 
	 { 
	    
	  int width = 200; // 图像宽度 
	  int height = 200; // 图像高度 
	  String format = "png";// 图像类型 
	    
	  JSONObject json = new JSONObject(); 
	  json.put("url",ss); 
	  String content = json.toJSONString();// 内容 
	    
	  Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>(); 
	  hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); 
	    
	  try
	  { 
	   BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵 
	   String path = FileSystems.getDefault().getPath(filePath, fileName).toString(); 
	   MultipartFile file = (MultipartFile) new File(path); 
//	   MatrixToImageWriter.writeToFile(bitMatrix, format, file);// 输出图像 
	   
	  } 
	  catch (WriterException e) 
	  { 
	   e.printStackTrace(); 
	   System.out.println("二维码输出异常"); 
	  } 
	 } 
}
