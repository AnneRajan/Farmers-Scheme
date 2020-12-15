import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Insurance, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-my-insurance',
  templateUrl: './my-insurance.component.html',
  styleUrls: ['./my-insurance.component.css']
})
export class MyInsuranceComponent implements OnInit {
myInsurance: Insurance[];
  constructor(private myservice:MyserviceService,private router:Router) { }
  farmer_email_id: string;
  ngOnInit(): any {
    this.farmer_email_id=sessionStorage.getItem("farmeremailid");
    console.log(this.farmer_email_id);
    this.myservice.viewMyInsurance(this.farmer_email_id).subscribe(
      response=>this.handleSuccessfulResponse(response),
  );
  }
  handleSuccessfulResponse(response) {
    this.myInsurance=response;
  }
}
