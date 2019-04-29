import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-follow-gymates',
  templateUrl: './follow-gymates.component.html',
  styleUrls: ['./follow-gymates.component.css']
})
export class FollowGymatesComponent implements OnInit {
  lname:any;
  constructor(private user:UserService,private http: HttpClient) { 
    let userData=JSON.parse(localStorage.getItem('currentUser'))

     this.lname=userData.user.firstName;
    console.log(this.lname);
  }
  arrayUser:any=[];
  followed:boolean=false;
  pfollow:boolean=false
  arrayFollow:any=[];
  ngOnInit() {
    this.user.getUserDetails().subscribe(data=>{
      this.arrayUser=data
      console.log(this.arrayUser)
      
      this.user.userfollows().subscribe(data=>{
        this.arrayFollow=data
        console.log(this.arrayFollow)
        
        this.arrayUser = this.arrayUser.map(e=>{
          // console.log(e)
          this.arrayFollow.map(function (i)  {
            console.log(e.firstName, i.name, "THIS IS CONDITION")
            if(e.firstName == i.name)
            {
              console.log("????", e.firstName == i.name)
              e.followed=true;
              
            }   
          })
          console.log(e)
          return e
        })
        
        console.log(this.arrayUser)
      });
    });

   
    
    
  //  console.log(a)
  }

  follow(fname)
  {
    this.followed=true
    console.log(fname)
    this.user.getRec(fname).subscribe();
  
  }
  unfollow(fname)
  { 
    
    this.followed=false
    console.log(fname)
    this.user.unfollow(fname).subscribe();
   
  }
}
