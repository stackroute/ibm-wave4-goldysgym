import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-add-subscriptions',
  templateUrl: './add-subscriptions.component.html',
  styleUrls: ['./add-subscriptions.component.css']
})
export class AddSubscriptionsComponent implements OnInit {

 
  

  constructor(private programService: ProgramService) { }

  ngOnInit() {
   
  }

  

    putSubscription(data) {
      let newData = {
        
          
          "subscriptionName": data.sname,
          "description": data.sdes,
          "imageUrl": data.imageUrl,
          "duration": data.Duration,
          "amount": data.amount,
         
      }
      
      this.programService.putSubscription(newData).subscribe((x) => {
       
        console.log(data)
      });
    }
  
  }


