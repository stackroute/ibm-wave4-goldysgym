import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddSubscriptionsComponent } from './add-subscriptions/add-subscriptions.component';
import { EditSubscriptionsComponent } from './edit-subscriptions/edit-subscriptions.component';
import { AddProgramsComponent } from './add-programs/add-programs.component';
import { EditProgramsComponent } from './edit-programs/edit-programs.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';

const routes: Routes = [

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
  { path: '*', redirectTo: '/', pathMatch: 'full' }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
