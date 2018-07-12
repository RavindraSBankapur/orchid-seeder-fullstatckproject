package com.reviewandratings.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewandratings.dao.LoginDAO;
import com.reviewandratings.dto.UserDTO;
import com.reviewandratings.model.UserEntity;
import com.reviewandratings.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	@Transactional
	public UserDTO login(String emailId, String password) {
		
		UserEntity userEntity = loginDAO.getUserDetails(emailId);
		if(userEntity != null && userEntity.getPassword().equals(password)){
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(userEntity.getUserId());
			userDTO.setfName(userEntity.getUserName());
			userDTO.setlName(userEntity.getUserName());
			userDTO.setEmailId(userEntity.getEmailId());
			return userDTO;
		}
		return null;
	}


	

		
}
