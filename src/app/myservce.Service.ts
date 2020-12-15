import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class MyserviceService{
    
    updatefarmer:FarmerRegisteration

    httpClient: any;
    constructor(private httpservice:HttpClient){ }

    public addFarmer(addfarmer:FarmerRegisteration){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/showfarmerregistration",addfarmer,{ headers, responseType:'text'});
    }

    public getAllFarmers(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getallfarmer");
    }

    public getAllBidders(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getallbidder");
    }

    
    public loginFarmer(loginFarmer:FarmerRegisteration){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/Login",loginFarmer,{ headers, responseType:'text'});
    }
    public addbidder(addbidder:Bidder){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/showbidderregistration",addbidder,{ headers, responseType:'text'});
    }

    public updateFarmer(updated:number){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.put("http://localhost:2023/farmer/updateFarmer/"+updated,{ headers, responseType:'text'});
    }

    public updateBidder(updated:number){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.put("http://localhost:2023/farmer/updateBidder/"+updated,{ headers, responseType:'text'});
    }

    public getFarmerRegisteredCount(){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getFarmerRegisteredCount");
    }

    public getFarmerApprovedCount(){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getFarmerApprovedCount");
    }

    public getBidderRegisteredCount(){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getBidderRegisteredCount");
    }

    public getBidderApprovedCount(){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getBidderApprovedCount");
    }

    public getFeedback(){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getallvisitormessage");
    }

    public sendmessage(send:ContactUs){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/sendvisitormessage",send,{headers,responseType:'text'})
    }

    public checkstatus(check:string){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/checkadminapproval/"+check,{headers,responseType:'text'});
    }

    public addcrop(crop:Crop){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/placesellrequest",crop,{headers,responseType:'text'})
    }

    public getfarmer(updatefarmer:FarmerRegisteration){
        return this.updatefarmer=updatefarmer;
    }
    public getfarmerdetail(){
        return this.updatefarmer;
    }

    public getFarmerList(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getFarmerList");
    }

    public getBidderList(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getBidderList");
    }

    public resetpassword(farmer:FarmerRegisteration){

        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/resetpassword/",farmer,{headers,responseType:'text'});
    }

    public soldhistory(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/gethistory");
    }

    public bidproduct(bid:BidProduct){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/bidforproduct",bid,{ headers, responseType:'text'});
    }

    public getallbidproduct(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getallbidproduct");
    }

    public applyInsurance(insurance:Insurance){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/applyInsurance",insurance,{ headers, responseType:'text'});
    }

    public getInsuranceList(){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/getInsuranceList");
    }

    public updateInsuranceList(updated:number){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.put("http://localhost:2023/farmer/updateInsuranceList/"+updated,{ headers, responseType:'text'});
    }

    public claimInsurance(insurance: ClaimInsurance){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.post("http://localhost:2023/farmer/claiminsurance",insurance,{ headers, responseType:'text'});
    }

    public viewMyInsurance(updated:string){
        const headers=new HttpHeaders().set('Content_Type','text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/viewMyInsurance/"+updated);
    }

    public checkPolicy(updated: number){
        const headers=new HttpHeaders().set('Content_Type' ,'text/plain ;charset=utf-8');
        return this.httpservice.get("http://localhost:2023/farmer/checkPolicy/"+updated,{ headers, responseType:'text'});
    }

    


}
export class FarmerRegisteration{
    farmer_id:number;
    full_name:string;
    contact_no:number;
    email_id:string;
    address_details:string;
    city:string;
    state:string;
    pincode:number;
    land_area:string;
    land_address:string;
    land_pincode:number;
    account_no:number;
    ifsc_code:string;
    aadhar_card:any;
    pan_card:any;
    certificate:any;
    password:string;
    admin_approval:string;
}
export class Bidder{

    bidder_id:number;
    full_name: string;
    contact_no:number;
    email_id:string;
    address_details: string;
    state:string;
    city:string;
    pincode:number;
    account_no:number;
    ifsc_code:string;
    aadhar_card:string;
    pan_card:string;
    trader_license:string;
    password:string;
}

export class ContactUs{
    visitorid:number;
    visitorname:string;
    visitoremail:string;
    visitorsubject:string;
    visitormessage:string;
}
export class Crop{
    cropid:number;
    croptype:string;
    cropname:string;
    fertilizertype:string;
    quantity:string;
    baseprice:number;
    soilphcertificate:any;
    farmer_email_id:string;
}
export class SoldHistory{
    soldid:number;
    solddate:string;
    cropname:string;
    quantity:String;
    msp:number;
    soldprice:number;
    totalprice:number;
}
export class BidProduct{
    bidproductid:number;
    cropname:string;
    croptype:string;
    baseprice:number;
    quantity:string;
    bidamount:number;
    bidder_email_id:string;
}

export class Insurance{
policy_no: number;
crop_type:string;
area: number;
policy_for:string;
state:string;
district :string;
insurance_company:string;
premiumamt: number;
sum_insured:number;
farmer_email_id:String;
}

export class ClaimInsurance{
    policy_no: number;
    insurance_company:string;
    sum_insured:number;
    date_of_loss: Date;
    causeofloss: string;
    farmer_email_id: string;
    admin_approval:string;
}
export class CheckPolicy{
    policy_no:number;
}