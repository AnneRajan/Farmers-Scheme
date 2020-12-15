import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Insurance, MyserviceService } from '../myservce.Service';


@Component({
  selector: 'app-insurance-approval',
  templateUrl: './insurance-approval.component.html',
  styleUrls: ['./insurance-approval.component.css']
})
export class InsuranceApprovalComponent implements OnInit {
insuranceList:Insurance[];
admin:string;
message:string;
policy_no: number;
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getInsuranceList().subscribe(
      response=>this.handleSuccessfulResponse(response),
  );
  }
  handleSuccessfulResponse(response) {
    this.insuranceList=response;
    this.admin=response.admin_approval;
}

approve(ins:Insurance):any{
 

  this.myservice.updateInsuranceList(ins.policy_no).subscribe(data => String(this.message));
  this.policy_no=ins.policy_no;
  var btn= document.getElementById(String(this.policy_no));
 btn.innerText="Approved";
 btn.setAttribute("disabled","disabled");
 



}

 
  
  
}
