package com.lh.it.resource.apk.web.controller;

//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.lh.it.resource.common.entity.FunctionInfo;
//import com.lh.it.resource.common.service.IndustryService;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;



public class test {
	
//	@Autowired
//	private  IndustryService industryService;
	
//		public  FunctionInfo getHtml(String url){
//			List<FunctionInfo> beasinfo=new ArrayList<FunctionInfo>();
//////			List<FunctionInfo> zhinengone =new ArrayList<FunctionInfo>();
////			List<FunctionInfo> zhinengTow =new ArrayList<FunctionInfo>();
//			FunctionInfo beas=new FunctionInfo();
//			beas.setChildInSk(beasinfo);
//			beas.setLevel(0);
//			beas.setName("行业|职能|技能数据");
//			beas.setDescription("行业|职能|技能数据");
//			Document doc;
//			try {
//				doc = Jsoup.connect(url).get();
//				Elements title = doc.getElementsByClass("posCont");
//				//行业
//				Element left=title.get(0).getElementById("sidebar-left");
//				Elements hangyename=left.getElementsByTag("li");
//				//职能
//				Element right=title.get(0).getElementById("sidebar-right");
//				Elements zhinengname=right.getElementsByTag("ul");
//				
//				for(int f=0;f<hangyename.size();f++) {
//					FunctionInfo hangye=new FunctionInfo();
//					hangye.setName(hangyename.get(f).text());
//					hangye.setDescription(hangyename.get(f).text());
//					
//					hangye.setLevel(1);
//					hangye.setChildInSk(getZhiOne(zhinengname.get(f)));
//					beasinfo.add(hangye);
//				}
//				
//				return beas;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return beas;
//		}
//		
//		//职能一
//		public static List<FunctionInfo> getZhiOne(Element element){
//			Elements zhinengname=element.getElementsByTag("li");
//			List<FunctionInfo> list=new ArrayList<FunctionInfo>();
//			for(Element Elements:zhinengname) {
//				FunctionInfo FunctionInfo =new FunctionInfo();
//				Elements zhinengone=Elements.getElementsByTag("a");
//				FunctionInfo.setLevel(2);
//				FunctionInfo.setName(zhinengone.get(0).text());
//				FunctionInfo.setDescription(zhinengone.get(0).text());
//				FunctionInfo.setChildInSk(getZhiTow(Elements));
//				list.add(FunctionInfo);
//			}
//			return list;
//			
//		}
//		
//		//职能一
//		public static List<FunctionInfo> getZhiTow(Element element){
//			Elements zhinengname=element.getElementsByTag("a");
//			List<FunctionInfo> list=new ArrayList<FunctionInfo>();
//			for(int i=1;i<zhinengname.size();i++) {
//				FunctionInfo FunctionInfo =new FunctionInfo();
//				FunctionInfo.setLevel(3);
//				FunctionInfo.setDescription(zhinengname.get(i).text());
//				FunctionInfo.setName(zhinengname.get(i).text());
//				list.add(FunctionInfo);
//			}
//			return list;
//			
//		}

}
