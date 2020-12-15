import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { FarmerRegisteration, MyserviceService } from '../myservce.Service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message:string;
  invalidLogin:boolean;
  constructor(private myservice:MyserviceService, private router:Router,private loginservice: AuthenticationService) { }

  ngOnInit(): void {
    if(this.loginservice.isUserLoggedIn()){
      this.router.navigate(['/index']);
    }
  }
  checkLogin(loginfarmer:FarmerRegisteration): any{
    this.loginservice.authenticate(loginfarmer).subscribe(data=>{
      this.message=data;
      if(this.message=="Farmer Loggedin successfully"){
        this.myservice.getfarmer(loginfarmer);
        this.router.navigate(['/farmerlandingpage']);
        this.invalidLogin=false
      }
      else if(this.message=="Bidder Loggedin successfully"){
        this.router.navigate(['/bidderlandingpage']);
        this.invalidLogin=false
      }
      else{
        this.invalidLogin=true;
      }
    });
  }
    
}