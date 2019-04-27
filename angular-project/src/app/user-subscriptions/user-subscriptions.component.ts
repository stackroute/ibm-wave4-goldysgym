import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-subscriptions',
  templateUrl: './user-subscriptions.component.html',
  styleUrls: ['./user-subscriptions.component.css']
})
export class UserSubscriptionsComponent implements OnInit {
  userData:any
  user:any
  constructor(private userService:UserService,private http:HttpClient) { }
arraySubscriptions:any=[];
  ngOnInit() {
    this.userData=JSON.parse(localStorage.getItem('currentUser'))
    console.log(this.userData.user.id)
    this.userService.getUserDetailsById(this.userData.user.id).subscribe(data=>{
      this.user=data
      console.log(this.user)   
  });
  }
}


