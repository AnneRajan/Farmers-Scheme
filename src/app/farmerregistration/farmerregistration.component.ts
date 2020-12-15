import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FarmerRegisteration, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-farmerregistration',
  templateUrl: './farmerregistration.component.html',
  styleUrls: ['./farmerregistration.component.css']
})
export class FarmerregistrationComponent implements OnInit {

  message:string;
  selectedFile: File;
  constructor(private myservice:MyserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(addfarmer:FarmerRegisteration):any{
    this.myservice.addFarmer(addfarmer).subscribe(data=>{
      this.message=data;
      if(this.message=="Registrated successfully"){
        localStorage.setItem("email_id",addfarmer.email_id);
        localStorage.setItem('getrole','farmer');
        this.router.navigate(['/uploaddocuments']);
      }

    })
  }

}
