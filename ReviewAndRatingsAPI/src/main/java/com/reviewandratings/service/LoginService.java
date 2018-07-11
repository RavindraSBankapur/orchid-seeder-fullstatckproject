package com.reviewandratings.service;

import com.reviewandratings.dto.UserDTO;

public interface LoginService {
	/**
	 * to verify login
	 * @param emailId
	 * @return
	 */
	UserDTO login(String emailId);
}
