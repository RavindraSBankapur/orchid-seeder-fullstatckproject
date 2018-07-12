package com.reviewandratings.dao;

import com.reviewandratings.model.UserEntity;

public interface LoginDAO {

	/**
	 * This method is used to get user details from database
	 * @param emailId
	 * @return
	 */
	UserEntity getUserDetails(String emailId);

	/**
	 * This method is used to get user details from database
	 * @param userId
	 * @return
	 */
	UserEntity getUserDetailsById(int userId);

}
