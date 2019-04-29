import { NgModule, Component } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AddSubscriptionsComponent } from "./add-subscriptions/add-subscriptions.component";
import { EditSubscriptionsComponent } from "./edit-subscriptions/edit-subscriptions.component";
import { AddProgramsComponent } from "./add-programs/add-programs.component";
import { EditProgramsComponent } from "./edit-programs/edit-programs.component";
import { SummaryPageComponent } from "./summary-page/summary-page.component";
import { AdminDashboardComponent } from "./admin-dashboard/admin-dashboard.component";
import { HomecomponentComponent } from "./homecomponent/homecomponent.component";
import { SignupComponent } from "./signup/signup.component";
import { LoginComponent } from "./login/login.component";
import { UserDashboardComponent } from "./user-dashboard/user-dashboard.component";
import { FollowGymatesComponent } from "./follow-gymates/follow-gymates.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { ProgramsComponent } from "./programs/programs.component";
import { UserSubscriptionsComponent } from "./user-subscriptions/user-subscriptions.component";
import { ProgramDetailsComponent } from "./program-details/program-details.component";
import { EditProgramformComponent } from "./edit-programform/edit-programform.component";
import { AdminProgramdetailsComponent } from "./admin-programdetails/admin-programdetails.component";
import { EnrolltestComponent } from "./enrollmentPage/enrolltest.component";
import { UserMyprogramsComponent } from "./user-myprograms/user-myprograms.component";

import {SubscriptionviewComponent  } from './subscriptionview/subscriptionview.component';
import{EditSubscriptionformComponent} from './edit-subscriptionform/edit-subscriptionform.component';
import { LoginAuthService } from './login-auth.service';
import { AdminMyprogramsComponent } from './admin-myprograms/admin-myprograms.component';
import { RoleAuthService } from "./role-auth.service";
import { UserroleAuthService } from "./userrole-auth.service";
import { AdmineditpgmComponent } from "./admineditpgm/admineditpgm.component";
import { TrainerManagementComponent } from './trainer-management/trainer-management.component';
import { RecommendationsComponent } from './recommendations/recommendations.component';
const routes: Routes = [
  { path: "prog-details/:id", component: ProgramDetailsComponent },
  { path: "admin-prog-details/:id", component: AdminProgramdetailsComponent },
  { path: "signup", component: SignupComponent },
  { path: "login", component: LoginComponent },
  { path: "enroll", component: EnrolltestComponent },
  { path: "subdetails/:id", component: SubscriptionviewComponent },
  {
    path: "admin",
    component: AdminDashboardComponent,
    data : {
      expectedRole: "ADMIN"
    },
    canActivate: [LoginAuthService, RoleAuthService],
    children: [
      {
        path: "add-subs",
        component: AddSubscriptionsComponent,
      },
      {
        path: "edit-subs",
        component: EditSubscriptionsComponent,
      },
      {
        path: "add-prog",
        component: AddProgramsComponent,
      },
      {
        path: "edit-prog",
        component: EditProgramsComponent,
      },
      {
        path: "summary",
        component: SummaryPageComponent,
      },
      {
        path: "edit/:id",
        component: EditProgramformComponent,
      },
      {
        path: "edit/:id/subs",
        component: EditSubscriptionformComponent,
      },
      {
        path: "",
        redirectTo: "/admin/summary",
        pathMatch: "full",
      },
      {
        path: "mypros",
        component: AdminMyprogramsComponent,
      },
      {
        path: "assignedtrainers",
        component: TrainerManagementComponent,
      },
  
      {
        path: "admineditpgmform/:id",
        component: AdmineditpgmComponent,
      },
      {
        path: "subscriptionview",
        component: AdmineditpgmComponent,
      }
    ]
  },
  {
    path: "user",
    component: UserDashboardComponent,
    data : {
      expectedRole: "USER"
    },
    canActivate: [LoginAuthService, UserroleAuthService],
    children: [
      {
        path: "follow",
        component: FollowGymatesComponent,
      },
      {
        path: "profile",
        component: UserProfileComponent,
      },
      {
        path: "programs",
        component: ProgramsComponent,
      },
      {
        path: "mysubs",
        component: UserSubscriptionsComponent,
      },
      {
        path: "mypros",
        component: UserMyprogramsComponent,
      },
      {
              path: "recommendation",
              component: RecommendationsComponent,
      },
      {
        path: "",
        redirectTo: "/user/recommendation",
        pathMatch: "full",
      }
    ]
  },

  {
    path: "**",
    redirectTo: "/home",
    pathMatch: "full",
    canActivate: [LoginAuthService]
  },
  { path: "home", component: HomecomponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
