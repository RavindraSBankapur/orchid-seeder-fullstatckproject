package com.reviewandratings.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewandratings.dao.ReviewDAO;
import com.reviewandratings.model.ReviewEntity;
import com.reviewandratings.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewDAO reviewDAO;

	@Override
	public long addReview(String moduleToken, int userId, int ratings, String comments, String ratingType) {
		ReviewEntity reviewEntity = new ReviewEntity();
		reviewEntity.setRatings(ratings);
		reviewEntity.setReviewText(comments);
		reviewEntity.setUserId(userId);
		reviewEntity.setModuleToken(moduleToken);
		reviewEntity.setRatingId(1);
		return reviewDAO.addReview(reviewEntity);
	}
	
	@Override
	public List<ReviewEntity> getReviews(){
		 return reviewDAO.getReviews();
	}

}
