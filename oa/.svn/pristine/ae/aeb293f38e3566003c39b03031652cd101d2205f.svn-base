/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ketayao.ketacustom.log.LogAdapter.java
 * Class:			LogTemplateAdapter
 * Date:			2013-5-3
 * Author:			<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version          2.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.lh.it.resource.security.log.impl;

import java.util.Map;

import com.google.common.collect.Maps;
import com.lh.it.resource.security.log.LogAPI;
import com.lh.it.resource.security.log.LogLevel;

/** 
 * 	
 * @author 	<a href="mailto:ketayao@gmail.com">ketayao</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:21:07 
 */

public class LogAdapter implements LogAPI {

	/**   
	 * @param message
	 * @param logLevel  
	 * @see com.lh.it.resource.security.log.LogAPI#log(java.lang.String, com.lh.it.resource.security.log.LogLevel)  
	 */
	@Override
	public void log(String message, LogLevel logLevel) {
		log(message, null, logLevel);
	}

	/**   
	 * @param message
	 * @param objects
	 * @param logLevel  
	 * @see com.lh.it.resource.security.log.LogAPI#log(java.lang.String, java.lang.Object[], com.lh.it.resource.security.log.LogLevel)  
	 */
	@Override
	public void log(String message, Object[] objects, LogLevel logLevel) {
		
	}
	
	/**   
	 * @return  
	 * @see com.lh.it.resource.security.log.LogAPI#getRootLogLevel()  
	 */
	@Override
	public LogLevel getRootLogLevel() {
		return LogLevel.ERROR;
	}

	/**   
	 * @return  
	 * @see com.lh.it.resource.security.log.LogAPI#getCustomLogLevel()  
	 */
	@Override
	public Map<String, LogLevel> getCustomLogLevel() {
		return Maps.newHashMap();
	}
}
