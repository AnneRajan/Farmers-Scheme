import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bidder, Crop } from '../myservce.Service';



@Injectable({
  providedIn: 'root'
})
export class BiddingService {
  bidderbid:Crop;
  private baseURL = "http://localhost:2023/farmer/getcrop";


  constructor(private httpClient : HttpClient) { }
  getCropList() : Observable<Bidder[]>{
    return this.httpClient.get<Bidder[]>(`${this.baseURL}`);
  }
  public getbidcrop(bidderbid:Crop){
    this.bidderbid=bidderbid;
  }
  public getbidcropdetail(){
    return this.bidderbid;
  }
  getCropById(cropid: number): Observable<Bidder>{
    return this.httpClient.get<Bidder>(`${this.baseURL}/${cropid}`);
  }

}
