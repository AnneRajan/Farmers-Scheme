import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BidProduct, Crop, MyserviceService } from '../myservce.Service';
import { AuthenticationService } from '../service/authentication.service';
import { BiddingService } from '../service/bidding.service';

@Component({
  selector: 'app-bidcrop',
  templateUrl: './bidcrop.component.html',
  styleUrls: ['./bidcrop.component.css']
})
export class BidcropComponent implements OnInit {
  bidderemail=sessionStorage.getItem('farmeremailid');
  obj1:any;
  message:string;
  cropdet:Crop[];
  constructor(private biddingService : BiddingService, private router: Router,private myservice:MyserviceService,private authservice:AuthenticationService) { 
    this.obj1=this.biddingService.getbidcropdetail();
  }

  ngOnInit(): void {
  }

  onSubmit(bid:BidProduct):any{
    this.myservice.bidproduct(bid).subscribe(data=>{
      this.message=data

      if(this.message=="Bid Amount entered successfully"){
        alert("Bid Amount entered successfully")
        this.router.navigate(['/bidderlandingpage'])
      }
    })
  }

}
