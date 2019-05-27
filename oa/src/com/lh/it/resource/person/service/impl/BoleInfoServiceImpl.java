package com.lh.it.resource.person.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lh.it.resource.core.Constants;
import com.lh.it.resource.person.dao.BoleInfoDAO;
import com.lh.it.resource.person.entity.PersonBoleInfo;
import com.lh.it.resource.person.service.BoleInfoService;
import com.lh.it.resource.security.entity.main.User;
import com.lh.it.resource.utils.OssUtil;

import sun.misc.BASE64Encoder;
@Service
public class BoleInfoServiceImpl implements BoleInfoService{

	@Autowired
	private BoleInfoDAO boleInfoDAO;

	@Override
	public Page<PersonBoleInfo> findPage(Specification<PersonBoleInfo> spec, Pageable pageable) {
		return boleInfoDAO.findAll(spec, pageable);
	}

	@Override
	public void inseter(MultipartFile image, User loginUser, PersonBoleInfo personBoleInfo) {
		
		 try {
	        	BASE64Encoder encoder = new BASE64Encoder();
	        	if (image.getSize() > 0) {
					String imageStr = String.valueOf(encoder.encode(image
							.getBytes()));
					String BackimpagePathnew = OssUtil.uploadStuAvatar(imageStr,personBoleInfo.getBoleImage(),
							Constants.RESUME_FILE_USER,
							image.getOriginalFilename());
					personBoleInfo.setBoleImage(BackimpagePathnew);
				}
			} catch (Exception e) {
			}
		 personBoleInfo.setDeleteBole(0);
		 personBoleInfo.setCreateTime(new Date());
		 personBoleInfo.setCreateUser(loginUser.getUsername());
		 personBoleInfo.setUpdateTime(new Date());
		 personBoleInfo.setUpdateUser(loginUser.getUsername());
		boleInfoDAO.save(personBoleInfo);
	}

	@Override
	public PersonBoleInfo findOne(String boleId) {
		return boleInfoDAO.findOne(boleId);
	}
}
