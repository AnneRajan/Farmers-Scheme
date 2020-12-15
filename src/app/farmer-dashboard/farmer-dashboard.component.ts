import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FarmerRegisteration, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-farmer-dashboard',
  templateUrl: './farmer-dashboard.component.html',
  styleUrls: ['./farmer-dashboard.component.css']
})
export class FarmerDashboardComponent implements OnInit {
  message:string;
  farmers:FarmerRegisteration[];
  admin:string;
  f_id:number;
  click: boolean=false;
  farm_id:number;
  constructor(private myservice:MyserviceService,private router:Router){ }
    ngOnInit():any{
        this.myservice.getAllFarmers().subscribe(
            response=>this.handleSuccessfulResponse(response),
        );
    }
    handleSuccessfulResponse(response) {
        this.farmers=response;
        this.admin=response.admin_approval;
    }
    
    approve(farmer_response:FarmerRegisteration):any{
     

      this.myservice.updateFarmer(farmer_response.farmer_id).subscribe(data => String(this.message));
      this.farm_id=farmer_response.farmer_id;
      var btn= document.getElementById(String(this.farm_id));
     btn.innerText="Approved";
     btn.setAttribute("disabled","disabled");
     //this.click=true;
    //   btn.addEventListener("click", handleclick);
    //   function handleclick(){
    //     btn.innerText="Approved";
    //     this.removeEventListener("click", handleclick);
    // }
      //btn.disabled=true;
      //  if(btn.innerText=="Approved"){
      //  this.click=true;
      // }
      //this.disable_btn();
    

   
    }
}
