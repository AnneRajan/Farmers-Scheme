import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService } from '../myservce.Service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-farmerlandingpage',
  templateUrl: './farmerlandingpage.component.html',
  styleUrls: ['./farmerlandingpage.component.css']
})
export class FarmerlandingpageComponent implements OnInit {
  farmerdetail=sessionStorage.getItem('farmeremailid');
  message:string;
  constructor(private myservice:MyserviceService, private router:Router, public logoutservice:AuthenticationService) {
   }

  ngOnInit(): void {
    this.myservice.checkstatus(this.farmerdetail).subscribe(
      data=>{
        this.message=data;
        if(this.message==="Admin approval is still pending"){
          alert("Admin approval is still pending.... Check after Sometime")
          this.logoutservice.logOut();
          this.router.navigate(['/index']);
        }
      })
  }
  logout(){
    this.logoutservice.logOut();
    this.router.navigate(['/index']);
  }

}
