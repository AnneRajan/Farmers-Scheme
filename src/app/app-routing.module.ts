import { componentFactoryName } from '@angular/compiler';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { ApplyInsuranceComponent } from './apply-insurance/apply-insurance.component';
import { BidcropComponent } from './bidcrop/bidcrop.component';
import { BidderLandingpageComponent } from './bidder-landingpage/bidder-landingpage.component';
import { BidderListComponent } from './bidder-list/bidder-list.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { CollectiveDashboardComponent } from './collective-dashboard/collective-dashboard.component';
import { CreateBidderComponent } from './create-bidder/create-bidder.component';
import { FarmerDashboardComponent } from './farmer-dashboard/farmer-dashboard.component';
import { FarmerListComponent } from './farmer-list/farmer-list.component';
import { FarmerlandingpageComponent } from './farmerlandingpage/farmerlandingpage.component';
import { FarmerregistrationComponent } from './farmerregistration/farmerregistration.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { IndexComponent } from './index/index.component';
import { InsuranceApprovalComponent } from './insurance-approval/insurance-approval.component';
import { LoginComponent } from './login/login.component';
import { MyInsuranceComponent } from './my-insurance/my-insurance.component';
import { PlacesellrequestComponent } from './placesellrequest/placesellrequest.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { TotalBiddersComponent } from './total-bidders/total-bidders.component';
import { UploadFilesComponent } from './upload-files/upload-files.component';
import { ViewmarketplaceComponent } from './viewmarketplace/viewmarketplace.component';
import { ViewsoldhistoryComponent } from './viewsoldhistory/viewsoldhistory.component';



const routes:Routes=[
    {path:'adminDashboard', component:AdminDashboardComponent,
    children: [
        {path: "totalfarmers", component: FarmerDashboardComponent},
        {path: "insuranceApproval", component: InsuranceApprovalComponent},
        {path:"totalBidders",component: TotalBiddersComponent},
        {path:"collectiveDashboard",component:CollectiveDashboardComponent,
        children:[
            {path:"farmerDetailsList",component:FarmerListComponent},
            {path:"bidderDetailsList",component:BidderListComponent}
        ]
    },
        {path:"feedback",component:FeedbackComponent},
        {path:'viewmarketplace',component:ViewmarketplaceComponent}
    ]

},
    {path:'AdminLogin',component:AdminLoginComponent},
    {path:'login',component:LoginComponent},
    {path:'index',component:IndexComponent},
    {path:'',component:IndexComponent },
    {path:'forgot',component:ResetpasswordComponent},
    {path:'farmer',component:FarmerregistrationComponent},
    {path:'farmerlandingpage',component:FarmerlandingpageComponent,canActivate:[AuthGaurdService]},
    {path:'placesellrequest',component:PlacesellrequestComponent,canActivate:[AuthGaurdService]},
    {path:'viewsoldcrophistory',component:ViewsoldhistoryComponent,canActivate:[AuthGaurdService]},
    {path:'bidder',component:CreateBidderComponent},
    {path:'uploaddocuments',component:UploadFilesComponent},
    {path:'bidderlandingpage',component:BidderLandingpageComponent,canActivate:[AuthGaurdService]},
    {path:'viewsoldhistory',component:ViewsoldhistoryComponent,canActivate:[AuthGaurdService]},
    {path:'bidcrop',component:BidcropComponent,canActivate:[AuthGaurdService]},
    {path:'viewmarketplace',component:ViewmarketplaceComponent,canActivate:[AuthGaurdService]},
    {path:'applyInsurance',component:ApplyInsuranceComponent,canActivate:[AuthGaurdService]},
    {path:'claimInsurance',component:ClaimInsuranceComponent,canActivate:[AuthGaurdService]},
    {path:'viewMyInsurance',component:MyInsuranceComponent,canActivate:[AuthGaurdService]}


];

@NgModule({

    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]



})
export class AppRoutingModule{}
export const routingComponents =[LoginComponent]

