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

	/**
	 * to get ratings
	 * @param moduleId
	 * @return
	 */
	List<Object[]> getRatings(String moduleId);

	/**
	 * to get total review count
	 * @param moduleId
	 * @return
	 */
	int getTotalReviewsCount(String moduleId);
	
}
