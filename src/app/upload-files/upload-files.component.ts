import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UploadFilesService } from '../upload-files.service';

@Component({
  selector: 'app-upload-files',
  templateUrl: './upload-files.component.html',
  styleUrls: ['./upload-files.component.css']
})
export class UploadFilesComponent implements OnInit {

  selectedFiles: FileList;
  progressInfos=  [] ;
  message = '';
  headermessage:string;

  fileInfos: Observable<any>;

  constructor(private uploadService: UploadFilesService,private router:Router) { }

  ngOnInit() {
    if(localStorage.getItem("getrole")=="farmer"){
      this.headermessage="Upload Aadhar card ,Pan card and Land Certificate";
    }
    else if(localStorage.getItem("getrole")=="bidder"){
      this.headermessage="Upload Aadhar card,Pan card and Trader License";
    }
    else{
      alert("first register yourself")
      this.router.navigate(['/index']);
    }
    this.fileInfos = this.uploadService.getFiles();
  }

  selectFiles(event) {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  upload(idx: number, file: File) {
    this.progressInfos[idx] = { value: 0, fileName: file.name };

    this.uploadService.upload(file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.fileInfos = this.uploadService.getFiles();
        }
      },
      err => {
        this.progressInfos[idx].value = 0;
        this.message = 'Could not upload the file:' + file.name;
      });
  }

  uploadFiles() {
    this.message = 'Uploaded sucessfully';
    


    for (let i = 0; i < this.selectedFiles.length; i++) {
      this.upload(i, this.selectedFiles[i]);
    }
  }
  backtologin(){
    localStorage.removeItem("email_id");
    localStorage.removeItem("getrole");
    this.router.navigate(['/login'])
    
  }
}
