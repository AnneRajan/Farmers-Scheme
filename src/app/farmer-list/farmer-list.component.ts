import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FarmerRegisteration, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-farmer-list',
  templateUrl: './farmer-list.component.html',
  styleUrls: ['./farmer-list.component.css']
})
export class FarmerListComponent implements OnInit {
  farmerlist:FarmerRegisteration[];
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getFarmerList().subscribe(
      response=>this.handleSuccessfulResponse(response),
  );
  }
  handleSuccessfulResponse(response) {
    this.farmerlist=response;
    
}

}
