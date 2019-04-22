import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-add-subscriptions',
  templateUrl: './add-subscriptions.component.html',
  styleUrls: ['./add-subscriptions.component.css']
})
export class AddSubscriptionsComponent implements OnInit {
  constructor(private programService: ProgramService) { }
  ngOnInit() {   
  }
    putSubscription(data,form) {
      let newData = {
         "subscriptionName": data.sname,
          "description": data.sdes,
          "imageUrl": data.imageUrl,
          "duration": data.Duration,
          "amount": data.amount,
         }
         form.reset();
      
      this.programService.putSubscription(newData).subscribe((x) => {
       
        console.log(data)
      });
    }
  
  }


