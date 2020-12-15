import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, SoldHistory } from '../myservce.Service';

@Component({
  selector: 'app-viewsoldhistory',
  templateUrl: './viewsoldhistory.component.html',
  styleUrls: ['./viewsoldhistory.component.css']
})
export class ViewsoldhistoryComponent implements OnInit {
 sold:SoldHistory[]
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): void {
    this.myservice.soldhistory().subscribe(
    response=>this.handleSuccessfulResponse(response),
);
}
handleSuccessfulResponse(response) {
  this.sold=response;
}
}
