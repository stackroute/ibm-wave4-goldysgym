import { Component, OnInit } from '@angular/core';
import { LoginAuthService } from '../login-auth.service';


@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  public loginuser: any= {};
  constructor(private authService: LoginAuthService,) {

    this.authService.isLoggedIn();
    this.loginuser  = JSON.parse(localStorage.getItem('currentUser'));
   }

  ngOnInit() {
  }
  
}
