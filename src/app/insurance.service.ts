import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Insurance } from './myservce.Service';


@Injectable({
  providedIn: 'root'
})
export class InsuranceService {
  private baseURL = "http://localhost:2023/farmer/applyinsurance";

  
  constructor(private httpClient: HttpClient) {
    
   }

  createInsurance(insurance: Insurance): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, insurance);
  }
}
