package com.reviewandratings.dto;

public class AddReviewJSON {
	private String moduleToken;
	private int userId;
	private int ratings;
	private String comments;
	private String ratingType;
	public String getModuleToken() {
		return moduleToken;
	}
	public void setModuleToken(String moduleToken) {
		this.moduleToken = moduleToken;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRatingType() {
		return ratingType;
	}
	public void setRatingType(String ratingType) {
		this.ratingType = ratingType;
	}
}
