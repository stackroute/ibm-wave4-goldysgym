import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddSubscriptionsComponent } from './add-subscriptions/add-subscriptions.component';
import { EditSubscriptionsComponent } from './edit-subscriptions/edit-subscriptions.component';
import { AddProgramsComponent } from './add-programs/add-programs.component';
import { EditProgramsComponent } from './edit-programs/edit-programs.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { FollowGymatesComponent } from './follow-gymates/follow-gymates.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ProgramsComponent } from './programs/programs.component';
import { UserSubscriptionsComponent } from './user-subscriptions/user-subscriptions.component';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import{EditProgramformComponent} from './edit-programform/edit-programform.component';
import{AdminProgramdetailsComponent } from './admin-programdetails/admin-programdetails.component';
import { EnrolltestComponent } from './enrollmentPage/enrolltest.component';
import { UserMyprogramsComponent } from './user-myprograms/user-myprograms.component';

import {SubscriptionviewComponent  } from './subscriptionview/subscriptionview.component';
import{EditSubscriptionformComponent} from './edit-subscriptionform/edit-subscriptionform.component';
import { LoginAuthService } from './login-auth.service';
import { ProgramScheduleComponent } from './program-schedule/program-schedule.component';
import {AdmineditpgmComponent} from './admineditpgm/admineditpgm.component';
const routes: Routes = [

  {path:'prog-details/:id',component: ProgramDetailsComponent, canActivate:[LoginAuthService]},
  {path: 'admin-prog-details/:id', component: AdminProgramdetailsComponent, canActivate:[LoginAuthService]},
  {path: "signup", component:SignupComponent},
  {path: "login", component:LoginComponent},
  {path: "enroll", component:EnrolltestComponent},
  {path: 'subdetails/:id', component:SubscriptionviewComponent, canActivate:[LoginAuthService]},
  {
    
    path: 'admin', component: AdminDashboardComponent,  children: [
      { path: 'add-subs', component: AddSubscriptionsComponent, canActivate:[LoginAuthService] },
      { path: 'edit-subs', component: EditSubscriptionsComponent, canActivate:[LoginAuthService] },
      { path: 'add-prog', component: AddProgramsComponent, canActivate:[LoginAuthService] },
      { path: 'edit-prog', component: EditProgramsComponent, canActivate:[LoginAuthService] },
      { path: 'summary', component: SummaryPageComponent , canActivate:[LoginAuthService]},
      { path: 'edit/:id', component: EditProgramformComponent, canActivate:[LoginAuthService] },
      { path: 'edit/:id/subs', component: EditSubscriptionformComponent, canActivate:[LoginAuthService]},
      { path: '', redirectTo: '/admin/summary', pathMatch: 'full', canActivate:[LoginAuthService] },
      { path: 'pro-schedule', component: ProgramScheduleComponent, canActivate:[LoginAuthService]},
      { path: 'admineditpgmform/:id', component: AdmineditpgmComponent, canActivate:[LoginAuthService]}
   
     
    ]
  },
  {path :'user', component:UserDashboardComponent,children:[
    { path: 'follow', component: FollowGymatesComponent, canActivate:[LoginAuthService]},
    { path: 'leaderboard', component: LeaderboardComponent, canActivate:[LoginAuthService] },
    { path: 'profile', component: UserProfileComponent, canActivate:[LoginAuthService]},
    {path:'programs', component:ProgramsComponent, canActivate:[LoginAuthService]},
    {path:'mysubs', component:UserSubscriptionsComponent, canActivate:[LoginAuthService]},
    {path:'mypros',component:UserMyprogramsComponent, canActivate:[LoginAuthService]},
    { path: '', redirectTo: '/user/profile', pathMatch: 'full', canActivate:[LoginAuthService] }
  ]},
   
   { path: '**', redirectTo: '/home', pathMatch: 'full', canActivate:[LoginAuthService] },
   { path: 'home', component: HomecomponentComponent},
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
