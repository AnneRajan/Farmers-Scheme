import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup,Validators } from '@angular/forms';
import { Admin } from '../model/admin.model';
import { AdminDataService} from 'src/app/service/AdminData.service';
import { AdminGetService } from '../service/AdminGetService';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent  {
  public admin : Admin[];
  error:boolean;
 public check: boolean = false;
 public invalid: boolean = false;
  AdminLoginForm: FormGroup;
  nameControl: FormControl;
  passwordControl: FormControl;

  constructor(public dataService : AdminDataService,public dt:AdminGetService,formBuilder : FormBuilder){
    //create control
   // this.nameControl=new FormControl("",Validators.required);
   this.nameControl=new FormControl("",Validators.compose([Validators.required]));
    this.passwordControl=new FormControl("",Validators.required);
   // this.costControl=new FormControl("500",Validators.required);
  
    this.error=false;
    //build the form
    this.AdminLoginForm=formBuilder.group({
        //each from controls needs and ID 
        "admin_uname" :this.nameControl,
        "admin_pwd" :this.passwordControl
        
    });
}

submitDetails() {
  this.error=false;
  this.check=false;
  this.invalid=false;
                    //check validity
                    if(!this.AdminLoginForm.valid){
                    //show error msg
                        this.error=true;
                        return;

                    }
  let admin_uname : string = this.nameControl.value;
  let admin_pwd : string = this.passwordControl.value;
  
    
        //create product object
        let admin1 : Admin = new Admin(admin_uname, admin_pwd);

        this.dataService.admin.push(admin1);
        // this.dt.getAdminData().subscribe(data =>{
        //   this.admin = data;
        // });
        if(admin_uname=="admin" && admin_pwd=="admin123"){
          this.check=true;
          
        }
        else{
          if(admin_uname!="admin" || admin_pwd!="admin123"){
            this.error=true;
            return;
          }
        }
        // if(this.invali==true){
        //   return;
        // }
console.log(admin1);
        //reset values for new entry
       this.AdminLoginForm.reset();
}

}
