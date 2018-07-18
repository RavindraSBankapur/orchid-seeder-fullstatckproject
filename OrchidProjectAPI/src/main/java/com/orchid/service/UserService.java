package com.orchid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orchid.dto.UserDTO;
import com.orchid.model.UserEntity;

/**
 * @author Ravindra S B Service class provides all required services for
 *         controller to perform CRUD operations via DAO
 * @param
 * @createdDate 11-July-2018
 * @updatedDate
 */
@Service
public interface UserService {

	public UserDTO registerService(UserDTO userDTO);

	public UserDTO logoutService(UserDTO userDTO);

	public UserDTO loginService(String emailId, long mobileNumber, String password);

	public List<UserEntity> getAllUsers();

	public UserDTO getUserById(int userId);
<<<<<<< HEAD

	public UserDTO getUserByEmailID(String emailId);

	public void updateUser(UserDTO userDTO);

	public void updatePassword(UserDTO userDTO);
=======
	public UserDTO getUserByEmailID(String emailId);
>>>>>>> 114317501f74e8f82b2c2a74660478e8743ed290
}
