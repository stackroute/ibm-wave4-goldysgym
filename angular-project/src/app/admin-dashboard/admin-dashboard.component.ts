import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../login-auth.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {


  public loginuser: any= {};
  constructor(private authService: LoginAuthService,) {

    this.authService.isLoggedIn();
    this.loginuser  = JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit() {
  }

}
