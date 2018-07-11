package com.reviewandratings.service;

import java.util.List;

import com.reviewandratings.model.ReviewEntity;

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

	List<ReviewEntity> getReviews();
}
