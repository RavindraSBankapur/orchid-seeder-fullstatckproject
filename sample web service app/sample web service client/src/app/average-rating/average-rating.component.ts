import { Component, OnInit } from '@angular/core';
import {WebClientService} from '../Service/web-client.service'
@Component({
  selector: 'app-average-rating',
  templateUrl: './average-rating.component.html',
  styleUrls: ['./average-rating.component.css']
})
export class AverageRatingComponent implements OnInit {
  reviewCount:number;
  selectedThumsUp : number;
  greatest:number=0;
  constructor(private webClientService : WebClientService) { 
    this.reviewCount=49;
  } 

  ngOnInit() {
  
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
        /*this.webClientService.overallRating.fiveStarPercentage =Math.round((this.webClientService.overallRating.fiveStarRatingsCount/this.webClientService.overallRating.totalNumberOfRatings) * 100);  */      
    });
    
  }

}
