package com.reviewandratings.dto;

import java.sql.Timestamp;

public class ReviewDTO {
	private int reviewId;
	private int userId;
	private String userName;
	private String userProfilePic;
	private Timestamp PostedDate;
	private int ratings;
	private String reviewText;
	private int likeCount;
	private int dislikeCount;
	private boolean likedByUser;
	private boolean dislikedByUser;
	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getPostedDate() {
		return PostedDate;
	}
	public void setPostedDate(Timestamp postedDate) {
		PostedDate = postedDate;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public boolean isLikedByUser() {
		return likedByUser;
	}
	public void setLikedByUser(boolean likedByUser) {
		this.likedByUser = likedByUser;
	}
	public boolean isDislikedByUser() {
		return dislikedByUser;
	}
	public void setDislikedByUser(boolean dislikedByUser) {
		this.dislikedByUser = dislikedByUser;
	}
	public String getUserProfilePic() {
		return userProfilePic;
	}
	public void setUserProfilePic(String userProfilePic) {
		this.userProfilePic = userProfilePic;
	}
}
