package com.reviewandratings.service;

public interface LikeAndDislikeService {

	/**
	 * addLikeOrDislike
	 * @param reviewId
	 * @param userId
	 * @param isLikedByUser
	 * @return
	 */
	int addLikeOrDislike(int reviewId, int userId, int isLikedByUser);

}
