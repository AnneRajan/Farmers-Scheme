import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContactUs, MyserviceService } from '../myservce.Service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  feedbacks:ContactUs[];
  constructor(private myservice:MyserviceService,private router:Router) { }

  ngOnInit(): any {
    this.myservice.getFeedback().subscribe(
      response=>this.handleSuccessfulResponse(response),
  );
  }
  handleSuccessfulResponse(response) {
    this.feedbacks=response;
    
}
}
