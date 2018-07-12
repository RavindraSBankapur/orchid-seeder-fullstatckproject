import { Component, OnInit } from '@angular/core';
import {ReviewsList} from '../Models/reviews-list.model';
import { DecimalPipe, getLocaleDateTimeFormat } from '@angular/common';
import {WebClientService} from '../Service/web-client.service';
import{LikeAndDislike} from '../Models/like-and-dislike.model';
@Component({
selector: 'app-review-list',
templateUrl: './review-list.component.html',
styleUrls: ['./review-list.component.css']
})
export class ReviewListComponent implements OnInit {
  data: any;
  greatest:number=0;
  selectedElement:number=1;
  filterOptions:any[]=[
    {id:1,Name:'By Date'},
    {id:2,Name:'By Rating'},
    {id:3,Name:'By Most Liked'}
  ];
constructor(private webClientService : WebClientService,private likeAndDislike : LikeAndDislike) { }
getStar(rating: number,starPosition:number)/* to change star color in the list based on rating given by the user*/
{
  if(rating>=starPosition)
  return "btn btn-warning btn-xs";
  else
  return "btn btn-default btn-grey btn-xs";
}
DisLikeClicked(reviewid,disLiked) 
{
  if(!disLiked)
  this.AddLikeAndDisLike(reviewid,0);
  else
  this.AddLikeAndDisLike(reviewid,2);
}
LikeClicked(reviewid,isLiked)
{
  if(!isLiked)
  this.AddLikeAndDisLike(reviewid,1);
  else
  this.AddLikeAndDisLike(reviewid,2);
}
ngOnInit() {
this.webClientService.getReviewList().subscribe((response) => {
this.webClientService.reviewCollection = response.reviewList;
});
}
AddLikeAndDisLike(ReviewId,isLikedByUser)
{
  this.likeAndDislike.userId =parseInt(localStorage.getItem('userId'));
  this.likeAndDislike.reviewId = ReviewId;
  this.likeAndDislike.isLikedByUser=isLikedByUser;
  this.webClientService.SubmitLikeAndDesike(this.likeAndDislike)
  .subscribe(data => {
  this.webClientService.getReviewList().subscribe((response) => {
  this.webClientService.reviewCollection = response.reviewList;
  });    
  this.webClientService.getOverallRatings().subscribe((response) => {
  this.webClientService.overallRating = response.overallRatings;
  let ratingList = [this.webClientService.overallRating.fiveStarRatingsCount,
  this.webClientService.overallRating.fourStarRatingsCount,
  this.webClientService.overallRating.threeStarRatingsCount,
  this.webClientService.overallRating.twoStarRatingsCount,
  this.webClientService.overallRating.singleStarRatingsCount,
  ]
  for (let i = 0; i < ratingList.length; i++) {
  if (ratingList[i] > this.greatest) {
  this.greatest = ratingList[i];
  }
  } 
  this.webClientService.overallRating.fiveStarwidth = (100/this.greatest) * (this.webClientService.overallRating.fiveStarRatingsCount);
  this.webClientService.overallRating.fourStarwidth = (100/this.greatest) * (this.webClientService.overallRating.fourStarRatingsCount);
  this.webClientService.overallRating.threeStarwidth = (100/this.greatest) * (this.webClientService.overallRating.threeStarRatingsCount);
  this.webClientService.overallRating.twoStarwidth = (100/this.greatest) * (this.webClientService.overallRating.twoStarRatingsCount);
  this.webClientService.overallRating.oneStarwidth = (100/this.greatest) * (this.webClientService.overallRating.singleStarRatingsCount);
  });
  }); 
  this.selectedElement = 1;
}
filterApplied(filterVal: any) 
{
  if(filterVal == "2")
  {
  this.webClientService.reviewCollection =  this.webClientService.reviewCollection.sort(
  function(a, b) {
  return b.ratings - a.ratings;
  }
  );
  }
  else if(filterVal == "3")
  {
  this.webClientService.reviewCollection =  this.webClientService.reviewCollection.sort(
  function(a, b) {
  return b.likeCount - a.likeCount;
  }
  );
  }
  else
  {
  this.webClientService.reviewCollection =  this.webClientService.reviewCollection.sort(
  function(a, b) {
  if (a.postedDate > b.postedDate) return -1;
  if (a.postedDate < b.postedDate) return 1;
  return 0;
  }
  );
}
}
}