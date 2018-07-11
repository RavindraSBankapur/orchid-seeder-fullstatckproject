package com.reviewandratings.controller;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.reviewandratings.dto.UserDTO;
import com.reviewandratings.dto.UserLoginJSON;
import com.reviewandratings.service.LoginService;
@RestController
@RequestMapping("/login")
public class LoginController {
	 
	@Autowired
	LoginService loginService;

	private static final String VERIFY_LOGIN = "/verify";
	
	/**
	 * login() controller to verify user login
	 * @param emailId
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = VERIFY_LOGIN, method = RequestMethod.POST,headers = { "checksum=ABC123XYZ=", "Accept=application/json;charset=utf-8", "Content-Type=application/json" })
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserLoginJSON userLoginJSON,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();
		UserDTO userDTO = null;
		if(userLoginJSON != null){
			 userDTO = loginService.login(userLoginJSON.getEmailId());// make call to login service
		}
			if(userDTO != null){
				//if user is valid
				responseObj.put("fName", userDTO.getfName());
				responseObj.put("lName", userDTO.getlName());
				responseObj.put("emailId", userDTO.getEmailId());
				responseObj.put("success", true);
				responseObj.put("message", "Login Successfull");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
			}else{
				//if there are no user found then should throw login failed
				responseObj.put("success", false);
				responseObj.put("message", "Login Failed");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
			}			
	}
	
}
