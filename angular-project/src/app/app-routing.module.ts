import { NgModule } from '@angular/core';
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

const routes: Routes = [


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
   // default route
   { path: '**', redirectTo: '/home', pathMatch: 'full' },

   { path: 'home', component: HomecomponentComponent},
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
