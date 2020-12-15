import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FarmerRegisteration } from '../myservce.Service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private httpservice:HttpClient) { }
  authenticate(loginFarmer:FarmerRegisteration){
    const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
    sessionStorage.setItem('farmeremailid',loginFarmer.email_id);
    return this.httpservice.post("http://localhost:2023/farmer/Login",loginFarmer,{ headers, responseType:'text'});
  
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('farmeremailid')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('farmeremailid')
    sessionStorage.removeItem('adminapproval')
  }

}
