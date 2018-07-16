package com.orchid.mapper;

import com.orchid.dto.UserLoginDTO;
import com.orchid.model.UserEntity;

public class UserLoginMapper {

	public static UserEntity userLoginDtoToUserEntity(UserLoginDTO userLoginDTO){
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setEmailId(userLoginDTO.getEmailId());
		userEntity.setPassword(userLoginDTO.getPassword());
		userEntity.setMobileNumber(userLoginDTO.getMobileNumber());
		
		return userEntity;
	}
	public static UserLoginDTO userEntityToUserLoginDTO(UserEntity userEntity){
		
		UserLoginDTO userLoginDTO = new UserLoginDTO();
		
		userLoginDTO.setEmailId(userEntity.getEmailId());
		userLoginDTO.setMobileNumber(userEntity.getMobileNumber());
		userLoginDTO.setPassword(userEntity.getPassword());
		
		return userLoginDTO;
	}	
}
