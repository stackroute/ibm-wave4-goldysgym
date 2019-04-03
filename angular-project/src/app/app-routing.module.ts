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

const routes: Routes = [

  {path:'prog-details/:id',component: ProgramDetailsComponent},
  {path: "signup", component:SignupComponent},
  {path: "login", component:LoginComponent},
  {
    // admin page routes 
    path: 'admin', component: AdminDashboardComponent, children: [
      { path: 'add-subs', component: AddSubscriptionsComponent },
      { path: 'edit-subs', component: EditSubscriptionsComponent },
      { path: 'add-prog', component: AddProgramsComponent },
      { path: 'edit-prog', component: EditProgramsComponent },
      { path: 'summary', component: SummaryPageComponent },
      { path: '', redirectTo: '/admin/summary', pathMatch: 'full' }
    ]
  },
  //User page routes
  {path :'user', component:UserDashboardComponent,children:[
    { path: 'follow', component: FollowGymatesComponent },
    { path: 'leaderboard', component: LeaderboardComponent },
    { path: 'profile', component: UserProfileComponent },
    {path:'programs', component:ProgramsComponent},
    {path:'mysubs', component:UserSubscriptionsComponent},
    { path: '', redirectTo: '/user/profile', pathMatch: 'full' }
  ]},
   // default route
   { path: '**', redirectTo: '/home', pathMatch: 'full' },
   { path: 'home', component: HomecomponentComponent},
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
