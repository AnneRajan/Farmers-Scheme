import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BidProduct, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-viewmarketplace',
  templateUrl: './viewmarketplace.component.html',
  styleUrls: ['./viewmarketplace.component.css']
})
export class ViewmarketplaceComponent implements OnInit {
  bidproduct:BidProduct[]
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): void {
    this.myservice.getallbidproduct().subscribe(
    response=>this.handleSuccessfulResponse(response),
);
}
handleSuccessfulResponse(response) {
  this.bidproduct=response;
}
}

