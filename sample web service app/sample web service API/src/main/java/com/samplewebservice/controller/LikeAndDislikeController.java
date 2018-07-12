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
import org.springframework.web.bind.annotation.RestController;

import com.reviewandratings.dto.AddLikeOrDislikeJSON;
import com.reviewandratings.service.LikeAndDislikeService;

@RestController
@RequestMapping("/likeanddislike")
public class LikeAndDislikeController {
	
	@Autowired
	LikeAndDislikeService likeAndDislikeService;
	
	private static final String LIKE_OR_DISLIKE = "/addlikeordislike";

	@RequestMapping(value = LIKE_OR_DISLIKE, method = RequestMethod.POST,headers = { "checksum=ABC123XYZ=", "Accept=application/json;charset=utf-8", "Content-Type=application/json" })
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody AddLikeOrDislikeJSON addLikeOrDislikeJSON,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();

		if(addLikeOrDislikeJSON != null){
			if(likeAndDislikeService.addLikeOrDislike(addLikeOrDislikeJSON.getReviewId(), addLikeOrDislikeJSON.getUserId(), addLikeOrDislikeJSON.getIsLikedByUser())> 0){
				responseObj.put("success", true);
				responseObj.put("message", "Like or Dislike added successfully");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
			}
		}
		responseObj.put("success", false);
		responseObj.put("message", "Error occured while adding Like or Dislike");
		return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
	} 
}
