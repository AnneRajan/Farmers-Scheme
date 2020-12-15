import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-collective-dashboard',
  templateUrl: './collective-dashboard.component.html',
  styleUrls: ['./collective-dashboard.component.css']
})
export class CollectiveDashboardComponent implements OnInit {
farmercount: number;
farmer_approve_count: number;
biddercount: number;
bidder_approve_count: number;
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getFarmerRegisteredCount().subscribe(
      response=>this.handleSuccessfulResponse1(response),
  );
  this.myservice.getFarmerApprovedCount().subscribe(
    response=>this.handleSuccessfulResponse2(response),
);

this.myservice.getBidderRegisteredCount().subscribe(
  response=>this.handleSuccessfulResponse3(response),
);

this.myservice.getBidderApprovedCount().subscribe(
  response=>this.handleSuccessfulResponse4(response),
);

  }
  handleSuccessfulResponse1(response) {
    this.farmercount=response;
    
}

handleSuccessfulResponse2(response) {
  this.farmer_approve_count=response;
}

handleSuccessfulResponse3(response) {
  this.biddercount=response;
}

handleSuccessfulResponse4(response) {
  this.bidder_approve_count=response;
}

}
