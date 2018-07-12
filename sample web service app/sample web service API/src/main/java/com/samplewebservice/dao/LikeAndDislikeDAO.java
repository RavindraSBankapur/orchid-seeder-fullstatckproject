package com.reviewandratings.dao;

import com.reviewandratings.model.LikeAndDislikeEntity;

public interface LikeAndDislikeDAO {

	/**
	 * addLikeOrDislike
	 * @param likeAndDislikeEntity
	 * @return
	 */
	int addLikeOrDislike(LikeAndDislikeEntity likeAndDislikeEntity);

	/**
	 * getLikeAndDislikeDeatils
	 * @param reviewId
	 * @param userId
	 * @return
	 */
	LikeAndDislikeEntity getLikeAndDislikeDeatils(int reviewId, int userId);

	/**
	 * updateLikeOrDislike
	 * @param likeOrDislikeId
	 * @param isLikedByUser
	 * @return
	 */

	int updateLikeOrDislike(int likeOrDislikeId, int isLikedByUser);

	/**
	 * 
	 * @param reviewId
	 * @return
	 */
	int getTotalLikesCount(int reviewId);

	/**
	 * 
	 * @param reviewId
	 * @return
	 */
	int getTotalDislikesCount(int reviewId);


}
