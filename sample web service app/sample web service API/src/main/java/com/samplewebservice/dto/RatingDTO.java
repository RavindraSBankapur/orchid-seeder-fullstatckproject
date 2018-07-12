package com.reviewandratings.dto;

public class RatingDTO {
	private int totalNumberOfRatings;
	private int fiveStarRatingsCount;
	private int fourStarRatingsCount;
	private int threeStarRatingsCount;
	private int twoStarRatingsCount;
	private int singleStarRatingsCount;
	private int averageRating;
	
	public int getTotalNumberOfRatings() {
		return totalNumberOfRatings;
	}
	public void setTotalNumberOfRatings(int totalNumberOfRatings) {
		this.totalNumberOfRatings = totalNumberOfRatings;
	}
	public int getFiveStarRatingsCount() {
		return fiveStarRatingsCount;
	}
	public void setFiveStarRatingsCount(int fiveStarRatingsCount) {
		this.fiveStarRatingsCount = fiveStarRatingsCount;
	}
	public int getFourStarRatingsCount() {
		return fourStarRatingsCount;
	}
	public void setFourStarRatingsCount(int fourStarRatingsCount) {
		this.fourStarRatingsCount = fourStarRatingsCount;
	}
	public int getThreeStarRatingsCount() {
		return threeStarRatingsCount;
	}
	public void setThreeStarRatingsCount(int threeStarRatingsCount) {
		this.threeStarRatingsCount = threeStarRatingsCount;
	}
	public int getTwoStarRatingsCount() {
		return twoStarRatingsCount;
	}
	public void setTwoStarRatingsCount(int twoStarRatingsCount) {
		this.twoStarRatingsCount = twoStarRatingsCount;
	}
	public int getSingleStarRatingsCount() {
		return singleStarRatingsCount;
	}
	public void setSingleStarRatingsCount(int singleStarRatingsCount) {
		this.singleStarRatingsCount = singleStarRatingsCount;
	}
	public int getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}
}
