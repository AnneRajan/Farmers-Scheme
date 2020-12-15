import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Policy } from './policy';

@Injectable({
  providedIn: 'root'
})
export class PolicyService {
  private baseURL = "http://localhost:2023/farmer/claiminsurance";

  constructor(private httpClient: HttpClient) { }

  createPolicy(policy: Policy): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, policy);
}
}