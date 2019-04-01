import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private user:UserService,private http: HttpClient) { }
  arrayUser:any=[];
  ngOnInit() {
    this.user.getUserDetails().subscribe(data=>{
      this.arrayUser=data
      console.log(this.arrayUser)     
    });
  }

}
