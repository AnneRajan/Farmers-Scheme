import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadFilesService {

  private baseUrl = 'http://localhost:2023/farmer';
  constructor(private http: HttpClient) {
 
  
  }
  
  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('email_id',localStorage.getItem("email_id"));
    formData.append('getrole',localStorage.getItem('getrole'));
    formData.append('file', file);

    
    
    const req = new HttpRequest('POST', `${this.baseUrl}/upload`,formData, {
      reportProgress: true,
      responseType: 'text',
    }
    
    
    );


    return this.http.request(req);
    

  }
  
  getFiles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/files`);
  }


}
