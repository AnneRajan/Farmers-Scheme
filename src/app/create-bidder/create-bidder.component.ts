import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bidder, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-create-bidder',
  templateUrl: './create-bidder.component.html',
  styleUrls: ['./create-bidder.component.css']
})
export class CreateBidderComponent implements OnInit {


  message:string;
  selectedFile: File;
  constructor(private myservice:MyserviceService, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(addbidder:Bidder):any{
    this.myservice.addbidder(addbidder).subscribe(data=>{
      this.message=data;
      if(this.message=="Registrated successfully"){
        localStorage.setItem("email_id",addbidder.email_id);
        localStorage.setItem("getrole","bidder");
        this.router.navigate(['/uploaddocuments']);
      }

    })
  }

}
