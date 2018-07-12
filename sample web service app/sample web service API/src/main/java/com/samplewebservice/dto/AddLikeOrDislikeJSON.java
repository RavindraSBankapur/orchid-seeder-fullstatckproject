package com.reviewandratings.dto;

public class AddLikeOrDislikeJSON {
	private int reviewId;
	private int userId;
	private int isLikedByUser;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsLikedByUser() {
		return isLikedByUser;
	}
	public void setIsLikedByUser(int isLikedByUser) {
		this.isLikedByUser = isLikedByUser;
	}
}
