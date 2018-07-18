package com.orchid.mapper;

import com.orchid.dto.UserDTO;
import com.orchid.model.UserEntity;

/**
 * @author ravindra
 * @param UserDTO,
 *            UserEntity
 * @description : The class converts the UserEntity to UserDTO and vice versa,
 *              the method is used while mapping to DB and while mapping from DB
 *              respectively.
 * @createdDate: 11-july-2018
 * @modifiedDate: 12-july-2018
 */
public class UserMapper {

	public static UserEntity dtoToEntityMapper(UserDTO userDTO) {

		UserEntity userEntity = new UserEntity();

		userEntity.setFirstName(userDTO.getFirstName());
		userEntity.setLastName(userDTO.getLastName());
		userEntity.setEmailId(userDTO.getEmailId());
		userEntity.setMobileNumber(userDTO.getMobileNumber());
		userEntity.setUserId(userDTO.getUserId());
		userEntity.setUserRole(userDTO.getUserRole());
		userEntity.setCreatedTimeStamp(userDTO.getCreatedTimeStamp());
		userEntity.setUpdatedTimeStamp(userDTO.getUpdatedTimeStamp());
		userEntity.setPassword(userDTO.getPassword());

		return userEntity;
	}

	public static UserDTO entityToDtoMapper(UserEntity userEntity) {

		UserDTO userDTO = new UserDTO();

		userDTO.setUserId(userEntity.getUserId());
		userDTO.setUserRole(userEntity.getUserRole());
		userDTO.setEmailId(userEntity.getEmailId());
		userDTO.setFirstName(userEntity.getFirstName());
		userDTO.setLastName(userEntity.getLastName());
		userDTO.setMobileNumber(userEntity.getMobileNumber());
		userDTO.setCreatedTimeStamp(userEntity.getCreatedTimeStamp());
		userDTO.setUpdatedTimeStamp(userEntity.getUpdatedTimeStamp());
		userDTO.setPassword(userEntity.getPassword());
		return userDTO;
	}

}
