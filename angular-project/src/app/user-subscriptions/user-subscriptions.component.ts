import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-subscriptions',
  templateUrl: './user-subscriptions.component.html',
  styleUrls: ['./user-subscriptions.component.css']
})
export class UserSubscriptionsComponent implements OnInit {

  constructor(private user:UserService,private http:HttpClient) { }
arraySubscriptions:any=[];
  ngOnInit() {
this.user.getUserDetails().subscribe(data=>{
      this.arraySubscriptions=data
      console.log(this.arraySubscriptions)     
    });
  }
}


