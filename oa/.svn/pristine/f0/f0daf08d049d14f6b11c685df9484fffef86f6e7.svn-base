package com.lh.it.resource.core;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lh.it.resource.utils.spring.SpringUtils;

public final class Constants {

	private static final Logger LOG = LoggerFactory.getLogger(Constants.class);

	/** HttpServletContext 中菜单令牌Key */
	public static final String HTTPSERVLETCONTEXT_MUSE_TOKEN_KEY = "httpServletContext_Muse_Token_key";

	/** HttpSession 中菜单令牌 */
	public static final String HTTPSESSION_MUSE_TOKEN_KEY = "HttpSession_Muse_Token_Key";

	public static File UPLOAD_FILE_DIR;//

	public static File ROOM_FILE_DIR;//

	private static String DIR_NAME = "upload";//

	/** 附件目录的名称 */
	public static final String ATTACH_FILE_DIR = "WEB-INF/atta_file";
	
	public static final String DOC_FILE_DIR = "WEB-INF/doc_file";

	public static final String CURRENT_USER = "user";//

	public static final String RESUME_FILE_USER = "WEB-INF/user_info_image";

	/**
	 * 获得附件存储目录位置
	 * 
	 * @return 返回附件目录位置
	 */
	public static File getAttachFileDir() {

		if (null == UPLOAD_FILE_DIR) {
			ServletContext sc = SpringUtils.getBean(ServletContext.class);
			UPLOAD_FILE_DIR = new File(sc.getContextPath(), DIR_NAME);
		}

		return UPLOAD_FILE_DIR;
	}

	/**
	 * 获得项目的根目录对象。
	 * 
	 * @return 返回项目运行觉得目录
	 */
	public static File getWebRootFile() {
		if (null == ROOM_FILE_DIR) {
			try {
				ServletContext sc = SpringUtils.getBean(ServletContext.class);
				ROOM_FILE_DIR = new File(sc.getRealPath("/"));
			} catch (RuntimeException e) {
				LOG.error("get room file dir path is error ", e);
			}
		}
		return ROOM_FILE_DIR;
	}

}
