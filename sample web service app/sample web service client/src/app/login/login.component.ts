import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import{ WebClientService } from '../Service/web-client.service';
import {ToastrService} from 'ngx-toastr';
import {Observable} from 'rxjs/Observable';
import {Login} from '../Models/login.model';
import { Router, Route } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public edited = true;
  constructor(private _router: Router,private webclientService : WebClientService,private toastr : ToastrService,private login:Login) { 
  }
  
  ngOnInit() {
    localStorage.removeItem('emailId');
    localStorage.removeItem('userId');
  }
  userLogin(form : NgForm)
  {
    this.webclientService.userLogin(form.value).subscribe((response) => {
        if(response.userDetails != null)
        {
        localStorage.setItem('emailId', response.userDetails.emailId);
        localStorage.setItem('userId', '1');
        this.webclientService.loginResponseDetails = response.userDetails;
        this.edited = true;
        this._router.navigate(['/rating']);
        }
        else
        {
          this.edited = false;
          this._router.navigate(['']);
        }
    });
  /*  this.toastr.success('User Name: ' + form.value.userName + ' Password: ' + form.value.Password,'User Login');*/
  }
}
