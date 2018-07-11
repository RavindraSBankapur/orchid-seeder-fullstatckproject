package com.reviewandratings.dao;

import java.util.List;

import com.reviewandratings.model.ReviewEntity;

public interface ReviewDAO {
	
	/**
	 * this method is to save reviews
	 * @param reviewEntity
	 * @return
	 */
	int addReview(ReviewEntity reviewEntity);

	/**
	 * to get list of reviews
	 * @return
	 */
	List<ReviewEntity> getReviews();
	
}
