import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from '../subscription.service';

import { ProgramService } from '../program.service';

import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-subscriptionview',
  templateUrl: './subscriptionview.component.html',
  styleUrls: ['./subscriptionview.component.css']
})
export class SubscriptionviewComponent implements OnInit {
 
  details:any
  constructor(private programService :ProgramService,private route :ActivatedRoute,private service : ProgramService,private router : Router) {}

  ngOnInit() {
   let id = this.route.snapshot.paramMap.get('id');
    console.log(id)
    this.programService.getSubscriptionDetailsById(id).subscribe(data =>{
    this.details = data
    console.log(data)
  });
}
  
  }
  

