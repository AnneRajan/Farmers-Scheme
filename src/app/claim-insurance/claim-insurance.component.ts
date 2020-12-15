import { Component, OnInit } from '@angular/core';
import { Policy } from '../policy';
import { PolicyService } from '../policy.service';
import { Router } from '@angular/router';
import { MyserviceService, Insurance, ClaimInsurance, CheckPolicy } from '../myservce.Service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-claim-insurance',
  templateUrl: './claim-insurance.component.html',
  styleUrls: ['./claim-insurance.component.css']
})
export class ClaimInsuranceComponent implements OnInit {
  message:string;
  checkstatus=false;
  policy:number;

farmer_email_id=sessionStorage.getItem('farmeremailid');
  constructor(private router: Router,private myservice:MyserviceService) { }

  ngOnInit(): void {
  }

  checkPolicy(policy_no:CheckPolicy){
    console.log(policy_no.policy_no);
    this.myservice.checkPolicy(policy_no.policy_no).subscribe(data=>{this.message=data 
      if(this.message=="Claim Successful"){
        this.checkstatus=true;
        this.policy=policy_no.policy_no;
      }
      else{
        
        alert("Your policy is not approved by admin");
        
        this.router.navigate(['/farmerlandingpage']);
      }
    
    });
 
    
    
    
  }
  

  onSubmit(insurance: ClaimInsurance){
    this.myservice.claimInsurance(insurance).subscribe(data=> {this.message=data
    if(this.message=="Insurance claimed successfully"){
      alert("Your claim is submitted");
      this.router.navigate(['/farmerlandingpage']);
    }
    else{
      alert("Your claim is not submitted");
      this.router.navigate(['/farmerlandingpage']);
    }
    });
    
  }

}
