import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, ContactUs } from '../myservce.Service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  message:string;
  constructor(private router:Router, public logoutservice:AuthenticationService, private myservice:MyserviceService) {}

 ngOnInit(): void {
 }
 
 logout(){
   this.logoutservice.logOut();
   this.router.navigate(['/index']);
 }
onSubmit(sendmessage:ContactUs){
  this.myservice.sendmessage(sendmessage).subscribe(data=>{
    this.message=data;
  });
}

}