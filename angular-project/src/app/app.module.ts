import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

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
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
