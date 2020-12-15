import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bidder, Crop, MyserviceService } from '../myservce.Service';
import { AuthenticationService } from '../service/authentication.service';
import { BiddingService } from '../service/bidding.service';

@Component({
  selector: 'app-bidder-landingpage',
  templateUrl: './bidder-landingpage.component.html',
  styleUrls: ['./bidder-landingpage.component.css']
})
export class BidderLandingpageComponent implements OnInit {
  biddings : Bidder[];
  message:string;
  bidderdetail=sessionStorage.getItem('farmeremailid');
  constructor(private biddingService : BiddingService, private router: Router,private myservice:MyserviceService,public authservice:AuthenticationService) { }

  ngOnInit(): void {
    this.myservice.checkstatus(this.bidderdetail).subscribe(
      data=>{
        this.message=data;
        if(this.message==="Admin approval is still pending"){
          alert("Admin approval is still pending.... Check after Sometime")
          this.authservice.logOut();
          this.router.navigate(['/index']);
        }
      })
 this.getCrops();
  }
  private getCrops(){
    this.biddingService.getCropList().subscribe(data =>{
      this.biddings=data;
    });
  }
  getbidcrop(bidderbid:Crop){
    this.biddingService.getbidcrop(bidderbid);
    this.router.navigate(['/bidcrop'])
  }

  viewCropDetails(cropid:number){
    this.router.navigate(['crop-details',cropid]);
  }
  logout(){
    this.authservice.logOut();
    this.router.navigate(['/index']);
  }

}
