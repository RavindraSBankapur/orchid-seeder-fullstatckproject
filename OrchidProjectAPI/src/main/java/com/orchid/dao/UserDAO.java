package com.orchid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.orchid.dto.UserDTO;
import com.orchid.model.UserEntity;


 /**
 * @author Ravindra S B
 *	Interface for User Data Access Layer, all the CRUD operations are done here.
 *	@param 
 * @createdDate 11-July-2018
 * @updatedDate 
 *
 */
@Repository public interface UserDAO{
	
	public int registerUser(UserEntity userEntity);
	public UserEntity logoutService(UserEntity userEntity);
	public UserEntity getUserDetails(String emailId, long mobileNumber, String password);
	public List<UserEntity> getAllUsers();
	public UserEntity getUserById(int userId);
}
