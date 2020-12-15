import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Admin } from '../model/admin.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminGetService {
  //updateemployee: Admin;
  private baseUrl ="http://localhost:2023/api/GetAdminData";
  constructor(private httpService: HttpClient) { }
  public getAdminData(): Observable<Admin[]> {
    //console.log("ins service get ");
    const headers =new HttpHeaders().set('Content_Type', 'text/plain ;charset=utf-8');
    return this.httpService.get<Admin[]>(`${this.baseUrl}`);
  }
} 
