package com.orchid.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchid.dao.UserDAO;
import com.orchid.dto.UserDTO;
import com.orchid.mapper.UserLoginMapper;
import com.orchid.mapper.UserMapper;
import com.orchid.model.UserEntity;
import com.orchid.service.UserService;
@Service

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	public UserServiceImpl() {
		System.out.println("User Service Created..");
	}

	@Override
	@Transactional
	public UserDTO registerService(UserDTO userDTO){
		
		UserEntity userEntity = UserMapper.dtoToEntityMapper(userDTO);
		
		int userID  = userDAO.registerUser(userEntity);
		
		return userDTO;
	}

	@Override
	public UserDTO logoutService(UserDTO userDTO) {

		return null;
	}

	@Override
	@Transactional
	public UserDTO loginService(String emailId, long mobileNumber, String password) {
		
		UserEntity userEntity = userDAO.getUserDetails(emailId,mobileNumber,password);
		if(userEntity != null && userEntity.getPassword().equals(password)){
			UserDTO userDTO = UserMapper.entityToDtoMapper(userEntity);
			return userDTO;
		}
		return null;
	}

	@Override
	@Transactional
	public List<UserEntity> getAllUsers() {
		
		List<UserEntity> userList = userDAO.getAllUsers();
		
		return userList;
	}

	@Override
	@Transactional
	public UserDTO getUserById(int userId) {

		UserEntity userEntity = userDAO.getUserById(userId);
		
		UserDTO userDTO = UserMapper.entityToDtoMapper(userEntity);
		
		return userDTO;
	}
}