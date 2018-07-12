package com.reviewandratings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewandratings.dao.LikeAndDislikeDAO;
import com.reviewandratings.model.LikeAndDislikeEntity;
import com.reviewandratings.service.LikeAndDislikeService;

@Service
public class LikeAndDislikeServiceImpl implements LikeAndDislikeService{
	
	@Autowired
	LikeAndDislikeDAO likeAndDislikeDAO;
	@Override
	public int addLikeOrDislike(int reviewId, int userId, int isLikedByUser) {
		LikeAndDislikeEntity likeAndDislikeEntity = likeAndDislikeDAO.getLikeAndDislikeDeatils(reviewId, userId);
		if(likeAndDislikeEntity != null){
			return likeAndDislikeDAO.updateLikeOrDislike(likeAndDislikeEntity.getLikeOrDislikeId(), isLikedByUser);
		}else{
			likeAndDislikeEntity = new LikeAndDislikeEntity();
			likeAndDislikeEntity.setReviewId(reviewId);
			likeAndDislikeEntity.setLikedOrDislikedBy(userId);
			likeAndDislikeEntity.setLikeOrDislikeStatus(isLikedByUser);
			return likeAndDislikeDAO.addLikeOrDislike(likeAndDislikeEntity);
		}		
	}
}
