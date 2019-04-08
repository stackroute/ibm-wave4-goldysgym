import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-subscription',
  templateUrl: './subscription.component.html',
  styleUrls: ['./subscription.component.css']
})
export class SubscriptionComponent implements OnInit {

  constructor(private program:ProgramService, private http:HttpClient) { }
  subscriptions:any=[];
  ngOnInit() {
    this.program.getSubscriptionDetails().subscribe(data=>{
      console.log(data)
      this.subscriptions=data
    })
  }

}

