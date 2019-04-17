import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private userService:UserService,private http: HttpClient, private route: ActivatedRoute) { }
  user:any=[];
  userId: any;
  userData:any

  // const getAge = this.userData.user.dateOfBirth => Math.floor((new Date() - new Date(birthDate).getTime()) / 3.15576e+10)
  ngOnInit() {
    this.userData=JSON.parse(localStorage.getItem('currentUser'))
    console.log(this.userData.user.id)
    this.userService.getUserDetailsById(this.userData.user.id).subscribe(data=>{
      this.user=data
      console.log(this.user)     
    });
  }

}
