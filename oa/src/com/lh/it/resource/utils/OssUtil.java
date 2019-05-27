package com.lh.it.resource.utils;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.lang3.StringUtils;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import sun.misc.BASE64Decoder;

public class OssUtil {
	public OssUtil() {
	}

	public static final OSSClient getOSSClient() {
		return new OSSClient("https://oss-cn-beijing.aliyuncs.com",
				"LTAIxgs77tZeCCip", "gQZ6hxVD0xK8oFu1jqeGWT0N9Q85bq");
	}

	public static final String uploadStuAvatar(String fileStr,
			String oldFileUrl, String pathName, String name) {
		OSSClient client;
		String resultUrl;
		client = getOSSClient();
		resultUrl = "";
		try {
			String fileName = name;
			String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
			fileName = (new StringBuilder("image.")).append(prefix).toString();
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setCacheControl("no-cache");
			metadata.setHeader("Pragma", "no-cache");
			metadata.setContentEncoding("utf-8");
			metadata.setContentType(fileName);
			Calendar cal = Calendar.getInstance();
			int year = cal.get(1);
			int month = cal.get(2) + 1;
			String diskName = (new StringBuilder(String.valueOf(year)))
					.append("/").append(month).append("/").append(pathName)
					.append("/").toString();
			if (StringUtils.isNotBlank(oldFileUrl)) {
				oldFileUrl = oldFileUrl
						.substring("https://airiappimage.oss-cn-beijing.aliyuncs.com/"
								.length());
				client.deleteObject("airiappimage", oldFileUrl);
			}
			Random random = new Random();
			int randomName = random.nextInt(9000);
			resultUrl = (new StringBuilder(
					"https://airiappimage.oss-cn-beijing.aliyuncs.com/"))
					.append(diskName).append(randomName).append(".")
					.append(prefix).toString();
			if (resultUrl.equals(oldFileUrl)) {
				randomName = random.nextInt(9000);
				resultUrl = (new StringBuilder(
						"https://airiappimage.oss-cn-beijing.aliyuncs.com/"))
						.append(diskName).append(randomName).append(".")
						.append(prefix).toString();
			}
			SerialBlob serialBlob = decodeToImage(fileStr);
			InputStream binaryStream = serialBlob.getBinaryStream();
			client.putObject(
					"airiappimage",
					(new StringBuilder(String.valueOf(diskName)))
							.append(randomName).append(".").append(prefix)
							.toString(), binaryStream, metadata);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.shutdown();
		}
		return resultUrl;
	}

	public static SerialBlob decodeToImage(String imageString) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] imageByte = decoder.decodeBuffer(imageString);
		return new SerialBlob(imageByte);
	}

}
