import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule, routingComponents } from './app-routing.module'; 
import { AppComponent} from './app.component';
import { IndexComponent } from './index/index.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { FarmerregistrationComponent } from './farmerregistration/farmerregistration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FarmerlandingpageComponent } from './farmerlandingpage/farmerlandingpage.component';
import { PlacesellrequestComponent } from './placesellrequest/placesellrequest.component';
import { ViewsoldhistoryComponent } from './viewsoldhistory/viewsoldhistory.component';
import { CreateBidderComponent } from './create-bidder/create-bidder.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { FarmerDashboardComponent } from './farmer-dashboard/farmer-dashboard.component';
import { InsuranceApprovalComponent } from './insurance-approval/insurance-approval.component';
import { TotalBiddersComponent } from './total-bidders/total-bidders.component';
import { CollectiveDashboardComponent } from './collective-dashboard/collective-dashboard.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { FarmerListComponent } from './farmer-list/farmer-list.component';
import { BidderListComponent } from './bidder-list/bidder-list.component';
import { UploadFilesComponent } from './upload-files/upload-files.component';
import { BidderLandingpageComponent } from './bidder-landingpage/bidder-landingpage.component';
import { BidcropComponent } from './bidcrop/bidcrop.component';
import { ViewmarketplaceComponent } from './viewmarketplace/viewmarketplace.component';
import { ApplyInsuranceComponent } from './apply-insurance/apply-insurance.component';
import { ClaimInsuranceComponent } from './claim-insurance/claim-insurance.component';
import { MyInsuranceComponent } from './my-insurance/my-insurance.component';







@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    IndexComponent,
  ResetpasswordComponent,
    FarmerregistrationComponent,
    FarmerlandingpageComponent,
    PlacesellrequestComponent,
    ViewsoldhistoryComponent,
    CreateBidderComponent,
    AdminLoginComponent,
    AdminDashboardComponent,
    FarmerDashboardComponent,
    InsuranceApprovalComponent,
    TotalBiddersComponent,
    CollectiveDashboardComponent,
    FeedbackComponent,
    FarmerListComponent,
    BidderListComponent,
    UploadFilesComponent,
    BidderLandingpageComponent,
    BidcropComponent,
    ViewmarketplaceComponent,
    ApplyInsuranceComponent,
    ClaimInsuranceComponent,
    MyInsuranceComponent
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
