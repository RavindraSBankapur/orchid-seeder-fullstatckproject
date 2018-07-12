import { Injectable } from '@angular/core';
import { Http,Response,Headers, RequestOptions, RequestMethod,URLSearchParams } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { Login } from '../Models/login.model';
import { LoginResponse } from '../Models/login-response.model';
import {ReviewsList} from '../Models/reviews-list.model';
import{AddReview} from '../Models/add-review.model';
import{OverallRating} from '../Models/overall-rating.module';
import{LikeAndDislike} from '../Models/like-and-dislike.model';

@Injectable()

export class WebClientService {
  public data:any=[]
  submitReview : AddReview;
  likeAndDislike:LikeAndDislike;
  reviewCollection: ReviewsList[];
  overallRating: OverallRating;
  login : Login;
  loginResponseDetails : LoginResponse;
  url="http://175.100.151.226:5002/ReviewAndRatingsAPI-0.0.1-SNAPSHOT/";
constructor(private http : Http) { }
userLogin(login : Login)
{
  var body=JSON.stringify(login);
  let header = new Headers();
  header.append('checksum','ABC123XYZ=');
  header.append('Content-Type','application/json');
  let requestOptions = new RequestOptions({
  headers: header
  });
  return this.http.post(this.url + 'login/verify',body,requestOptions)
  .map((response: Response) => response.json()); 
}
postReview(submitReview: AddReview)
{
  var body=JSON.stringify(submitReview);
  let header = new Headers();
  header.append('checksum','ABC123XYZ=');
  header.append('Content-Type','application/json');
  let requestOptions = new RequestOptions({
  headers: header
  });
  return this.http.post(this.url + 'review/addreview/',body,requestOptions).map(x =>x.json())
}

SubmitLikeAndDesike(submitLikeAndDislike: LikeAndDislike)
{
  var body=JSON.stringify(submitLikeAndDislike);
  let header = new Headers();
  header.append('checksum','ABC123XYZ=');
  header.append('Content-Type','application/json');

  let requestOptions = new RequestOptions({
  headers: header
  });
  return this.http.post(this.url + 'likeanddislike/addlikeordislike',body,requestOptions).map(x =>x.json())
}

getReviewList()
{
  let header = new Headers();
  header.append('checksum','ABC123XYZ=');
  header.append('Content-Type','application/json');
  let requestOptions = new RequestOptions({
  headers: header
  });
  return this.http.get(this.url + 'review/getreviews?userId='+localStorage.getItem('userId'),requestOptions)
  .map((response: Response) => response.json()); 
}
getOverallRatings()
{
  let header = new Headers();
  header.append('checksum','ABC123XYZ=');
  header.append('Content-Type','application/json');
  let requestOptions = new RequestOptions({
  headers: header
  });
  return this.http.get(this.url + 'rating/getoverallratings/?moduleToken='+localStorage.getItem('emailId'),requestOptions)
  .map((response: Response) => response.json()); 
}
}

