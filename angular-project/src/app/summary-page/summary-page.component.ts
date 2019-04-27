import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-summary-page',
  templateUrl: './summary-page.component.html',
  styleUrls: ['./summary-page.component.css']
})
export class SummaryPageComponent implements OnInit {

  programs: any;
  subscriptions:any;

  constructor(private programService: ProgramService) { }

  ngOnInit() {
    this.getPrograms();
  }

  getPrograms() {
    this.programService.getPrograms().subscribe((x) => {
      this.programs = x
      console.log(this.programs)
    });
    this.programService.getSubscriptionDetails().subscribe(data=>{
     
      this.subscriptions=data
      console.log(this.subscriptions)
    })
  }


}
