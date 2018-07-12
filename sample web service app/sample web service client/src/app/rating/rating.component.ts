import { Component, OnInit,NgZone } from '@angular/core';

import { DecimalPipe } from '@angular/common';
import {WebClientService} from '../Service/web-client.service'
import { NgForm } from '@angular/forms';
import {ToastrService} from 'ngx-toastr'
import {Observable} from 'rxjs/Observable';
import{AddReview} from '../Models/add-review.model'
import { Router, Route } from '@angular/router';
import { $ } from 'protractor';
import { Subject } from 'rxjs/Subject';

@Component({
selector: 'app-rating',
templateUrl: './rating.component.html',
styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {
  greatest:number=0;
constructor(private zone:NgZone,private _router: Router,private addReview : AddReview,private webClientService : WebClientService,private toastr : ToastrService) {
  this._router.routeReuseStrategy.shouldReuseRoute = function(){
  return false;
} 
}
ngOnInit() 
  {
    if(localStorage.getItem('emailId') != null && localStorage.getItem('emailId') != "")
    this.resetForm();
    else
    this._router.navigate(['']);
  }
resetForm(form? : NgForm)
{
  if(form != null)
  form.reset();
  this.addReview = {
  userId : 0,
  ratings : 0,
  ratingType : 0,
  comments : '',
  moduleToken : ''
}
} 
onSubmit(form : NgForm)
{
  form.value.ratingType="5";
  form.value.moduleToken=localStorage.getItem('emailId');
  form.value.userId=localStorage.getItem('userId');
  form.value.ratings=this.addReview.ratings;
  if (form.value.comments.replace(/\s/g, '').length && form.value.ratings > 0) {
  this.webClientService.postReview(form.value)
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
  this.webClientService.overallRating.fiveStarwidth = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.fiveStarRatingsCount);
  this.webClientService.overallRating.fourStarwidth = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.fourStarRatingsCount);
  this.webClientService.overallRating.threeStarwidth = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.threeStarRatingsCount);
  this.webClientService.overallRating.twoStarwidth = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.twoStarRatingsCount);
  this.webClientService.overallRating.oneStarwidth = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.singleStarRatingsCount);

  this.webClientService.overallRating.fiveStarPercentage = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.fiveStarRatingsCount);
        this.webClientService.overallRating.fourStarPercentage = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.fourStarRatingsCount);
        this.webClientService.overallRating.threeStarPercentage = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.threeStarRatingsCount);
        this.webClientService.overallRating.twoStarPercentage = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.twoStarRatingsCount);
        this.webClientService.overallRating.oneStarPercentage = (100/this.webClientService.overallRating.totalNumberOfRatings) * (this.webClientService.overallRating.singleStarRatingsCount);
  });
  this._router.navigated = false;
  this._router.navigate([this._router.url]);
  this.resetForm();
  this.toastr.success('Review submitted Successfully','Thank you for your feedack');
  });
} 
else
{
  if(form.value.ratings < 1)
  this.toastr.error('Please Give Rating','Validation Message');
  else
  this.toastr.error('Please Add Review','Validation Message');
}
}
updateRating(selectedVal : number)
{
  if(selectedVal == 1)
  this.addReview.ratings = 1;
  else if(selectedVal == 2)
  this.addReview.ratings = 2;
  else if(selectedVal == 3)
  this.addReview.ratings = 3;
  else if(selectedVal == 4)
  this.addReview.ratings = 4;
  else
  this.addReview.ratings = 5;

}

}
