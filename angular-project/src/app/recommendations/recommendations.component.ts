import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.css']
})
export class RecommendationsComponent implements OnInit {

  constructor(private user:UserService,private http:HttpClient) { }
  arrayUser:any=[];
  arraySessions:any=[];
  arrayage:any=[];
  ngOnInit() {
    this.user.getRecommendedUsers().subscribe(data=>{
      this.arrayUser=data
      console.log(this.arrayUser)     
    });

    this.user.getRecommendedSessions().subscribe(data=>{
      this.arraySessions=data
      console.log(this.arraySessions)
    });

    this.user.getAgeGroupUser().subscribe(data=>{
      this.arrayage=data
      console.log(this.arrayage)
    });
  }

}
