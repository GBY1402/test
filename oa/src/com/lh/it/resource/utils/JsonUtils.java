package com.lh.it.resource.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

/**
 * 
 * @Description: 实体转换json
 * @author wangxiaolong
 * @date 2017年11月13日 上午10:24:42
 */
public class JsonUtils {

	public static JsonConfig jsonConfig = new JsonConfig();
	public static JSONArray jsonArray;

	/**
	 * 返回json
	 * 
	 * @param jSONObject
	 * @param appMessage
	 * @param object
	 * @return
	 */
	public static JSONObject AppMessageToJsons(Object appMessage) {
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value) {
				if (value == null || "".equals(value)) {
					return true;
				}
				return false;
			}
		});
		JSONObject JSONObjectnew = JSONObject
				.fromObject(appMessage, jsonConfig);
		return JSONObjectnew;
	}

	/**
	 * 消息转换json
	 * 
	 * @param jSONObject
	 * @param appMessage
	 * @param object
	 * @return
	 */
	public static String newsPush(NewsPush newsPush) {
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value) {
				if (value == null || "".equals(value)) {
					return true;
				}
				return false;
			}
		});
		JSONObject JSONObjectnew = JSONObject
				.fromObject(newsPush, jsonConfig);
		return JSONObjectnew.toString();
	}

	/**
	 * 将Date格式转换String
	 * 
	 * @param date
	 * @return String 日期字符串（yyyy-mm-dd）
	 */
	public static String DateToString(Date date) {
		String dateString = null;
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dateString = sdf.format(date);
		}
		return dateString;
	}

//	public static String List(List<AppRepresentativeInfoVO> obect) {
//		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
//
//			@Override
//			public boolean apply(Object source, String name, Object value) {
//				if (value == null || "".equals(value)) {
//					return true;
//				}
//				return false;
//			}
//		});
//		JSONObject JSONObjectnew = JSONObject
//				.fromObject(obect, jsonConfig);
//		return JSONObjectnew.toString();
//	}
    public static int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  
}
