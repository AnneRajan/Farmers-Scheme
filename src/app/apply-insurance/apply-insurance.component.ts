import { Component, OnInit } from '@angular/core';

import { InsuranceService } from '../insurance.service';
import { Router } from '@angular/router';
import { Insurance, MyserviceService } from '../myservce.Service';


@Component({
  selector: 'app-apply-insurance',
  templateUrl: './apply-insurance.component.html',
  styleUrls: ['./apply-insurance.component.css']
})
export class ApplyInsuranceComponent implements OnInit {
message:string;
farmer_email_id=sessionStorage.getItem('farmeremailid');
  constructor(private router: Router,private myservice:MyserviceService) { }

  ngOnInit(): void {
  }
  

  onSubmit(insurance: Insurance){
    this.myservice.applyInsurance(insurance).subscribe(data=> {this.message=data
    if(this.message=="Insurance created successfully"){

      alert("Wait for admin approval");
      this.router.navigate(['/farmerlandingpage']);
      
    }
    });
  }
}
