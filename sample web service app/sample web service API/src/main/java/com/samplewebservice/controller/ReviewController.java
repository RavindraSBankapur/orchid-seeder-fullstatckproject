package com.reviewandratings.controller;

import java.util.LinkedHashMap;
import java.util.List;
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

import com.reviewandratings.dto.AddReviewJSON;
import com.reviewandratings.dto.ReviewDTO;
import com.reviewandratings.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewService reviewService;

	private static final String ADD_REVIEW = "/addreview";
	
	private static final String GET_REVIEWS = "/getreviews";
	
	@RequestMapping(value = ADD_REVIEW, method = RequestMethod.POST,headers = { "checksum=ABC123XYZ=", "Accept=application/json;charset=utf-8", "Content-Type=application/json" })
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody AddReviewJSON addReviewJSON,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();

		if(addReviewJSON != null){
			if(reviewService.addReview(addReviewJSON.getModuleToken(), addReviewJSON.getUserId(), addReviewJSON.getRatings(), addReviewJSON.getComments(), addReviewJSON.getRatingType())> 0){
				
				responseObj.put("success", true);
				responseObj.put("message", "Review and Ratigs added successfully");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
			}
		}
		responseObj.put("success", false);
		responseObj.put("message", "Error occured while adding Review and Ratigs");
		return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
	} 
	
	@RequestMapping(value = GET_REVIEWS, method = RequestMethod.GET,headers = { "checksum=ABC123XYZ=", "Accept=application/json" })
	public ResponseEntity<Map<String, Object>> login(@RequestParam("userId") int userId, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();
			List<ReviewDTO> reviewList = reviewService.getReviews(userId);// make call to login service
			if(reviewList != null){
				//if user is valid
				responseObj.put("reviewList", reviewList);
				responseObj.put("success", true);
				responseObj.put("message", "Fetched List Successfully");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
			}else{
				//if there are no user found then should throw login failed
				responseObj.put("success", false);
				responseObj.put("message", "Error Occured While Fetching List");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
			}			
	}
}
