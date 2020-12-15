import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService, FarmerRegisteration } from '../myservce.Service';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
  message:string;
  constructor(private myservice:MyserviceService, private router:Router) {
    
  }
  ngOnInit(): void {
    
  }
  

 submitDetails(farmer:FarmerRegisteration):any{

  this.myservice.resetpassword(farmer).subscribe(data=>{
    this.message=data;
    if(this.message==="Password Updated successfully"){
      alert("password reset successfully")
      this.router.navigate(['/login'])
    }
  });

}

  
 
 
}