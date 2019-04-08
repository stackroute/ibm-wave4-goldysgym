import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-add-subscriptions',
  templateUrl: './add-subscriptions.component.html',
  styleUrls: ['./add-subscriptions.component.css']
})
export class AddSubscriptionsComponent implements OnInit {

  // programs : any;
  

  constructor(private programService: ProgramService) { }

  ngOnInit() {
    // this.getPrograms();
  }

  // getPrograms() {
  //   this.programService.getPrograms().subscribe((x) => {
  //     this.programs= x
  //     console.log(this.programs)
  //   });

    putSubscription(data) {
      let newData = {
        
          
          "subscriptionName": data.sname,
          "description": data.sdes,
          "imageUrl": data.imageUrl,
          "duration": data.Duration,
          "amount": data.amount,
          // "user": [
          //     {
          //         "userId": "1",
          //         "startDate": "today"
          //     }
          // ]
      }
      
      this.programService.putSubscription(newData).subscribe((x) => {
        // this.data = x
        console.log(data)
      });
    }
  
  }


