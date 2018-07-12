package com.reviewandratings.service;

import java.util.List;

import com.reviewandratings.dto.RatingDTO;
import com.reviewandratings.dto.ReviewDTO;

public interface ReviewService {
	
	/**
	 * 
	 * @param moduleToken
	 * @param userId
	 * @param ratings
	 * @param comments
	 * @param ratingType
	 * @return
	 */

	long addReview(String moduleToken, int userId, int ratings, String comments, String ratingType);

	/**
	 * to get review list
	 * @return
	 */
	List<ReviewDTO> getReviews(int userId);

	/**
	 * to get overall ratings
	 * @param moduleId
	 * @return
	 */
	RatingDTO getOverallRatings(String moduleId);

	/**
	 * to get toatla reviews count
	 * @param moduleToken
	 * @return
	 */
	int getTotalReviewsCount(String moduleToken);

}
