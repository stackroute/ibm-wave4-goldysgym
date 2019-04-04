import { Component, OnInit } from '@angular/core';
import {SubscriptionService} from '../subscription.service';
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-subscriptionview',
  templateUrl: './subscriptionview.component.html',
  styleUrls: ['./subscriptionview.component.css']
})
export class SubscriptionviewComponent implements OnInit {
  private details:any
    constructor(private subscriptionservices: SubscriptionService, private route: ActivatedRoute) {
      this.route.params.subscribe( params => {
        console.log(params)
        this.getDetail(params.subscribename)
      });
     }
  
  
    ngOnInit() {
      console.log("detail");
    }
     getDetail(currentRouteParam){
  
       this.subscriptionservices.getSubscriptionviewFromBackend(currentRouteParam).subscribe(data =>{
         console.log(data)
         this.details=data;    
       });
       console.log(this.details);
     }
  
  
  }
  

