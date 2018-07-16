package com.orchid.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.orchid.dto.UserDTO;
import com.orchid.dto.UserLoginDTO;
import com.orchid.messages.ErrorMessages;
import com.orchid.messages.SuccessMessages;
import com.orchid.model.UserEntity;
import com.orchid.service.UserService;

/**
 * @author Ravindra S B
 * @Controller class for User Data controller. it manages all the User Operations
 * @param
 * @createdDate 11-July-2018
 * @updatedDate
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final String REGISTER_USER = "/register";
	private static final String LOGIN_USER = "/login";
	private static final String LOGOUT_USER = "/logout";
	private static final String GET_USER = "/getAllUsers";
	private static final String GET_USER_BY_ID = "/getUser/{userId}";
	
	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("user controller created..");
	}

	@RequestMapping(value = REGISTER_USER, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> registerController(UserDTO userDTO, HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> responseObject = new LinkedHashMap<String,Object>();
		if(userDTO.getEmailId()!=null && userDTO.getMobileNumber()!=0 && userDTO.getPassword()!=null && userDTO.getFirstName()!=null && userDTO.getLastName()!=null){
			userDTO = userService.registerService(userDTO);
					if(userDTO!=null){	
								responseObject.put("message",true);
								responseObject.put("user", userDTO);
								responseObject.put("message",SuccessMessages.REGISTRATION_SUCCESS);
								return new ResponseEntity<>(responseObject,HttpStatus.OK);
					}
					else{
								responseObject.put("success", false);
								responseObject.put("message", ErrorMessages.REGISTRATION_ERROR);
								return new ResponseEntity<Map<String, Object>>(responseObject, HttpStatus.BAD_REQUEST);
							}
					}
		else{
			responseObject.put("message", ErrorMessages.NULL_NOT_ALLOWED);
			return new ResponseEntity<Map<String, Object>>(responseObject,HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value=LOGIN_USER,method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> loginController(UserLoginDTO userLoginDTO,HttpServletRequest request, HttpServletResponse response, HttpSession session){
				
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();
		UserDTO userDTO = null;
		if(userLoginDTO != null){
			userDTO = userService.loginService(userLoginDTO.getEmailId(),userLoginDTO.getMobileNumber(),userLoginDTO.getPassword());
		}
		if(userDTO != null){
				//if user is valid
				session = request.getSession();
				session.setAttribute("emailId", userDTO.getEmailId());
				responseObj.put("userDetails", userDTO);
				responseObj.put("success", true);
				responseObj.put("message", "Login Successfull");
				Cookie cookie = new Cookie("emailId", userDTO.getEmailId());
				cookie.setMaxAge(10000);
				response.addCookie(cookie);
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
		}else{
				//if there are no user found then should throw login failed
				responseObj.put("success", false);
				responseObj.put("message",ErrorMessages.ERROR_LOGIN);
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
		}	
	
	}
	
	@RequestMapping(value=LOGOUT_USER,headers = { "checksum=ABC123XYZ=", "Accept=application/json;charset=utf-8", "Content-Type=application/json" })
	public ResponseEntity<Map<String, Object>> logoutController(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> responseObject = new LinkedHashMap<String, Object>();
		HttpSession session = request.getSession(false);
		System.out.println("before invalidate "+session.getId());
		if(session==null){
			responseObject.put("message", "There is some problem in logging out from your account, Please Login again! and then Logout");
			return new ResponseEntity<Map<String,Object>>(responseObject,HttpStatus.BAD_REQUEST);
		}else{
			session.invalidate();
			session = null;
			responseObject.put("message", "You have been logged out from your account successfully...");
			return new ResponseEntity<Map<String,Object>>(responseObject,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = GET_USER, method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getAllUsers(UserDTO userDTO, HttpServletRequest request, HttpServletResponse response){
		Map<String , Object> responseObject = new LinkedHashMap<String, Object>();
		List<UserEntity> userList = userService.getAllUsers();
		if(userDTO!=null){
			responseObject.put("userDetails", userList);
			responseObject.put("success", true);
			return new ResponseEntity<Map<String,Object>>(responseObject,HttpStatus.OK);
		}
		responseObject.put("success", false);
	
		return new ResponseEntity<Map<String,Object>>(responseObject,HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value=GET_USER_BY_ID, method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getUserById(@PathVariable("userId") int userId,HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> responseObject = new LinkedHashMap<String, Object>();
		
		UserDTO userDTO = userService.getUserById(userId);
		if(userDTO != null){
			responseObject.put("user", userDTO);
			responseObject.put("success", true);
			return new ResponseEntity<Map<String,Object>>(responseObject, HttpStatus.OK);
		}
		responseObject.put("success", false);
		responseObject.put("message", "No User Assigned to the entered UserID");
		return new ResponseEntity<Map<String,Object>>(responseObject, HttpStatus.BAD_REQUEST);
	}
}
