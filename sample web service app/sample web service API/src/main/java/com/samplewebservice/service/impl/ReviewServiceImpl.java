package com.reviewandratings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewandratings.dao.LikeAndDislikeDAO;
import com.reviewandratings.dao.LoginDAO;
import com.reviewandratings.dao.ReviewDAO;
import com.reviewandratings.dto.RatingDTO;
import com.reviewandratings.dto.ReviewDTO;
import com.reviewandratings.model.LikeAndDislikeEntity;
import com.reviewandratings.model.ReviewEntity;
import com.reviewandratings.model.UserEntity;
import com.reviewandratings.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	LikeAndDislikeDAO likeAndDislikeDAO;

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
	public List<ReviewDTO> getReviews(int userId){
		List<ReviewEntity> reviewList = reviewDAO.getReviews();
		List<ReviewDTO> reviewDTOList =  new ArrayList<>();
		if(!reviewList.isEmpty()){
			for(ReviewEntity reviewEntity:reviewList){
				ReviewDTO reviewDTO = new ReviewDTO();
				UserEntity userEntity = loginDAO.getUserDetailsById(reviewEntity.getUserId());
				if(userEntity != null){
					reviewDTO.setUserId(userEntity.getUserId());
					reviewDTO.setUserName(userEntity.getUserName());
					reviewDTO.setUserProfilePic(userEntity.getProfilePicURL() != null ? userEntity.getProfilePicURL():"");
				}
				reviewDTO.setReviewId(reviewEntity.getReviewId());
				reviewDTO.setPostedDate(reviewEntity.getCreatedTimestamp());
				reviewDTO.setRatings(reviewEntity.getRatings());
				reviewDTO.setReviewText(reviewEntity.getReviewText());
				reviewDTO.setLikeCount(likeAndDislikeDAO.getTotalLikesCount(reviewEntity.getReviewId()));
				reviewDTO.setDislikeCount(likeAndDislikeDAO.getTotalDislikesCount(reviewEntity.getReviewId()));
				LikeAndDislikeEntity likeAndDislikeEntity = likeAndDislikeDAO.getLikeAndDislikeDeatils(reviewEntity.getReviewId(), userId);
				if(likeAndDislikeEntity != null){
					if(likeAndDislikeEntity.getLikeOrDislikeStatus() == 1){
						reviewDTO.setLikedByUser(true);
					}else{
						reviewDTO.setDislikedByUser(true);
					}
				}else{
					reviewDTO.setLikedByUser(false);
					reviewDTO.setDislikedByUser(false);
				}
				reviewDTOList.add(reviewDTO);
			}
		}
		return reviewDTOList;
	}
	
	
	@Override
	public RatingDTO getOverallRatings(String moduleToken){
		List<Object[]> ratingObjectList= reviewDAO.getRatings(moduleToken);
		if(ratingObjectList.isEmpty()){
			return null;
		}
		RatingDTO ratingDTO = new RatingDTO();
		int totalNumberOfRatings = 0;
		for(Object[] ratingObject:ratingObjectList){
			if(ratingObject[0] != null){
				if(Integer.parseInt(ratingObject[0].toString()) == 5){
					ratingDTO.setFiveStarRatingsCount(Integer.parseInt(ratingObject[1].toString()));
				}else if(Integer.parseInt(ratingObject[0].toString()) == 4){
					ratingDTO.setFourStarRatingsCount(Integer.parseInt(ratingObject[1].toString()));
				}else if(Integer.parseInt(ratingObject[0].toString()) == 3){
					ratingDTO.setThreeStarRatingsCount(Integer.parseInt(ratingObject[1].toString()));
				}else if(Integer.parseInt(ratingObject[0].toString()) == 2){
					ratingDTO.setTwoStarRatingsCount(Integer.parseInt(ratingObject[1].toString()));
				}else if(Integer.parseInt(ratingObject[0].toString()) == 1){
					ratingDTO.setSingleStarRatingsCount(Integer.parseInt(ratingObject[1].toString()));
				}
			}
			
		}
		totalNumberOfRatings = ratingDTO.getFiveStarRatingsCount()+ratingDTO.getFourStarRatingsCount()+ratingDTO.getThreeStarRatingsCount()+ratingDTO.getTwoStarRatingsCount()+ratingDTO.getSingleStarRatingsCount();
		int overallRating = ((ratingDTO.getFiveStarRatingsCount()*5)+(ratingDTO.getFourStarRatingsCount()*4)+(ratingDTO.getThreeStarRatingsCount()*3)+(ratingDTO.getTwoStarRatingsCount()*2)+ratingDTO.getSingleStarRatingsCount())/totalNumberOfRatings;
		ratingDTO.setTotalNumberOfRatings(totalNumberOfRatings);
		ratingDTO.setAverageRating(overallRating);
		return ratingDTO;
	}
	
	@Override
	public int getTotalReviewsCount(String moduleToken){
		return reviewDAO.getTotalReviewsCount(moduleToken);
	}
}
