import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Bidder, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-total-bidders',
  templateUrl: './total-bidders.component.html',
  styleUrls: ['./total-bidders.component.css']
})
export class TotalBiddersComponent implements OnInit {
  message:string;
  bidders:Bidder[];
  admin:string;
  b_id:number;
  click: boolean=false;
  bid_id:number;
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getAllBidders().subscribe(
      response=>this.handleSuccessfulResponse(response)
    );
  }
  handleSuccessfulResponse(response) {
    this.bidders=response;
    this.admin=response.admin_approval;
}

approve(bidder_response:Bidder):any{
     

  this.myservice.updateBidder(bidder_response.bidder_id).subscribe(data => String(this.message));
  this.bid_id=bidder_response.bidder_id;
  var btn= document.getElementById(String(this.bid_id));
 btn.innerText="Approved";
 btn.setAttribute("disabled","disabled");
 



}

}
