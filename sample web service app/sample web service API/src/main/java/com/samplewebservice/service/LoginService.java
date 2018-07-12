package com.reviewandratings.service;

import com.reviewandratings.dto.UserDTO;

public interface LoginService {
	/**
	 * to verify login
	 * @param emailId
	 * @param password
	 * @return
	 */

	UserDTO login(String emailId, String password);
}
