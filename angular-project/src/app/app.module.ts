import { BrowserModule,} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from  '@angular/common/http'; 
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LeftNavComponent } from './left-nav/left-nav.component';
import { AddProgramsComponent } from './add-programs/add-programs.component';
import { AddSubscriptionsComponent } from './add-subscriptions/add-subscriptions.component';
import { EditProgramsComponent } from './edit-programs/edit-programs.component';
import { EditSubscriptionsComponent } from './edit-subscriptions/edit-subscriptions.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { HerobannerComponent } from './herobanner/herobanner.component';
import { ProgramsComponent } from './programs/programs.component';
import { SubscriptionComponent } from './subscription/subscription.component';
import { ProgramService } from './program.service';
import { FooterComponent } from './footer/footer.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserDashboardSidebarComponent } from './user-dashboard-sidebar/user-dashboard-sidebar.component';
import { FollowGymatesComponent } from './follow-gymates/follow-gymates.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { UserSubscriptionsComponent } from './user-subscriptions/user-subscriptions.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import { EditProgramformComponent } from './edit-programform/edit-programform.component';
import { AdminProgramdetailsComponent } from './admin-programdetails/admin-programdetails.component';
import { SubscriptionviewComponent } from './subscriptionview/subscriptionview.component';
import { EnrolltestComponent } from './enrollmentPage/enrolltest.component';
import { MatStepperModule, MatInputModule, MatButtonModule, MatAutocompleteModule } from '@angular/material';
import { MatRadioModule} from '@angular/material';
import { MatDatepickerModule,MatNativeDateModule,MatFormFieldModule,} from '@angular/material';
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { EditSubscriptionformComponent } from './edit-subscriptionform/edit-subscriptionform.component';
import { UserMyprogramsComponent } from './user-myprograms/user-myprograms.component';
import { MatTableModule } from '@angular/material/table';
import { AdminMyprogramsComponent } from './admin-myprograms/admin-myprograms.component';
import { AdmineditpgmComponent } from './admineditpgm/admineditpgm.component';
import { TrainerManagementComponent } from './trainer-management/trainer-management.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LeftNavComponent,
    AddProgramsComponent,
    AddSubscriptionsComponent,
    EditProgramsComponent,
    EditSubscriptionsComponent,
    SummaryPageComponent,
    AdminDashboardComponent,
    HomecomponentComponent,
    HerobannerComponent,
    ProgramsComponent,
    SubscriptionComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    ProgramDetailsComponent,
    EditProgramformComponent,
    AdminProgramdetailsComponent,
    SubscriptionviewComponent,
    UserDashboardComponent,
    UserDashboardSidebarComponent,
    FollowGymatesComponent,
    UserProfileComponent,
    UserSubscriptionsComponent,
    ProgramDetailsComponent,
    EnrolltestComponent,
    EditSubscriptionformComponent,
    UserMyprogramsComponent,
    AdminMyprogramsComponent,
    AdmineditpgmComponent,
    TrainerManagementComponent,
    RecommendationsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatInputModule,
    MatButtonModule,
    MatAutocompleteModule,
    BrowserAnimationsModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatCardModule,
    MatCheckboxModule,
    MatTableModule
  ],
  providers: [ProgramService],
  bootstrap: [AppComponent]
})
export class AppModule { }
