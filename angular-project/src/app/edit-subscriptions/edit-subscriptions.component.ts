import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-subscriptions',
  templateUrl: './edit-subscriptions.component.html',
  styleUrls: ['./edit-subscriptions.component.css']
})
export class EditSubscriptionsComponent implements OnInit {
  constructor(private programService: ProgramService, private http:HttpClient,private router:Router) { }

  subscriptions:any;
ngOnInit() {
  this.getPrograms();
}


getPrograms() {
  this.programService.getSubscriptionDetails().subscribe(data=>{
     
    this.subscriptions=data
    console.log(this.subscriptions)
  });
}
remove(id)
{
  console.log(id);
  return this.programService.deleteSubscription(id).subscribe(()=>{this.getPrograms()})
 }

}
