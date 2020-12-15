import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Crop, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-placesellrequest',
  templateUrl: './placesellrequest.component.html',
  styleUrls: ['./placesellrequest.component.css']
})
export class PlacesellrequestComponent implements OnInit {
  farmeremail=sessionStorage.getItem('farmeremailid');
  message:string;
  constructor(private myservice:MyserviceService, private routes:Router) {
    
   }

  ngOnInit(): void {
  }

  onSubmit(addcrop:Crop):any{
    this.myservice.addcrop(addcrop).subscribe(data=>{
      this.message=data;
      if(this.message=="Crop details added successfully"){
        alert("Crop details added successfully");
        this.routes.navigate(['/farmerlandingpage'])
      }
    })
  }

}
