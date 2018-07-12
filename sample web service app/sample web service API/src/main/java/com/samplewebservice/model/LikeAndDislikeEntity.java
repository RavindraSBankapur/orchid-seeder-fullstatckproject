package com.reviewandratings.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likesAndDislikes")
public class LikeAndDislikeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "likeOrDislikeId")
	private int likeOrDislikeId;
	private int reviewId;
	private int likeOrDislikeStatus;
	private int likedOrDislikedBy;
	private Timestamp createdTimestamp;
	private Timestamp updatedTimestamp;
	public int getLikeOrDislikeId() {
		return likeOrDislikeId;
	}
	public void setLikeOrDislikeId(int likeOrDislikeId) {
		this.likeOrDislikeId = likeOrDislikeId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getLikeOrDislikeStatus() {
		return likeOrDislikeStatus;
	}
	public void setLikeOrDislikeStatus(int likeOrDislikeStatus) {
		this.likeOrDislikeStatus = likeOrDislikeStatus;
	}
	public int getLikedOrDislikedBy() {
		return likedOrDislikedBy;
	}
	public void setLikedOrDislikedBy(int likedOrDislikedBy) {
		this.likedOrDislikedBy = likedOrDislikedBy;
	}
	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Timestamp getUpdatedTimestamp() {
		return updatedTimestamp;
	}
	public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
}
