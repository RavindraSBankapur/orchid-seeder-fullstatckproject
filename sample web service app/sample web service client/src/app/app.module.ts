import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ToastrModule} from 'ngx-toastr';
import{FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import {WebClientService} from './Service/web-client.service'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {Login} from './Models/login.model';
import {AddReview} from './Models/add-review.model';
import { RatingComponent } from './rating/rating.component'
import { RouterModule, Routes } from '@angular/router';
import {NgxPaginationModule} from 'ngx-pagination';
import {TimeAgoPipe} from 'time-ago-pipe';
import { ReviewListComponent } from './review-list/review-list.component';
import { AverageRatingComponent } from './average-rating/average-rating.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {LikeAndDislike} from './Models/like-and-dislike.model';
const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'rating', component: RatingComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RatingComponent,
    TimeAgoPipe,
    ReviewListComponent,
    AverageRatingComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    NgxPaginationModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    ),
    BrowserModule,
    FormsModule,
    HttpModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [WebClientService,Login,AddReview,LikeAndDislike],
  bootstrap: [AppComponent]
})
export class AppModule { }
