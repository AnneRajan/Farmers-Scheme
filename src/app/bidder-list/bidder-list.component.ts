import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bidder, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-bidder-list',
  templateUrl: './bidder-list.component.html',
  styleUrls: ['./bidder-list.component.css']
})
export class BidderListComponent implements OnInit {
  bidderlist:Bidder[];
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getBidderList().subscribe(
      response=>this.handleSuccessfulResponse(response),
  );
  }
  handleSuccessfulResponse(response) {
    this.bidderlist=response;
    
}
}
