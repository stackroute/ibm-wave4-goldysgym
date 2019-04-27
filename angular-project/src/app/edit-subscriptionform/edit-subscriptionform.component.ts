import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-edit-subscriptionform',
  templateUrl: './edit-subscriptionform.component.html',
  styleUrls: ['./edit-subscriptionform.component.css']
})
export class EditSubscriptionformComponent implements OnInit {
  constructor(private programService: ProgramService,private route: ActivatedRoute ) { }
  id :any
  subscription:any
 
  ngOnInit() { 
    this.id = this.route.snapshot.paramMap.get('id');
    this.programService.getSubscriptionDetailsById(this.id).subscribe(data=>{
      console.log(data)
      this.subscription=data
    })
    
  }
  sub:any;
    editSubscription(data,form) {
      let newData = {
         "subscriptionName": data.sname,
          "description": data.sdes,
          "imageUrl": data.imageUrl,
          "duration": data.Duration,
          "amount": data.amount,
         }
         form.reset();
         console.log(this.id)
         this.programService.editSubscription(newData).subscribe(data =>{
         this.sub = newData
         console.log(newData)
           });
    }
  
  }
