package com.reviewandratings.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reviewandratings.dto.RatingDTO;
import com.reviewandratings.service.ReviewService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	ReviewService reviewService;

	
	private static final String GET_OVERALL_RATINGS = "/getoverallratings";

	
	@RequestMapping(value = GET_OVERALL_RATINGS, method = RequestMethod.GET,headers = { "checksum=ABC123XYZ=", "Accept=application/json" })
	public ResponseEntity<Map<String, Object>> login(@RequestParam(value = "moduleToken") String moduleToken,HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseObj = new LinkedHashMap<String, Object>();
			RatingDTO ratingDTO = reviewService.getOverallRatings(moduleToken);// make call to login service
			if(ratingDTO != null){
				//if user is valid
				responseObj.put("overallRatings", ratingDTO);
				responseObj.put("success", true);
				responseObj.put("message", "Fetched Ovarall Ratings Successfully");
				responseObj.put("totalReviewsCount",reviewService.getTotalReviewsCount(moduleToken));
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.OK);
			}else{
				//if there are no user found then should throw login failed
				responseObj.put("success", false);
				responseObj.put("message", "Error Occured While Fetching Ovarall Ratings");
				return new ResponseEntity<Map<String, Object>>(responseObj, HttpStatus.BAD_REQUEST);
			}			
	}
}
