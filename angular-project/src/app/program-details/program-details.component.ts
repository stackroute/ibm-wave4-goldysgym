import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-program-details',
  templateUrl: './program-details.component.html',
  styleUrls: ['./program-details.component.css']
})
export class ProgramDetailsComponent implements OnInit {
  
  pdetails:any
  constructor(private programService : ProgramService,private route :ActivatedRoute,private service : ProgramService,private router : Router) {}

  ngOnInit() {
   let id = this.route.snapshot.paramMap.get('id');
    console.log(id)
    this.programService.getProgramDetails(id).subscribe(data =>{
    this.pdetails = data
    console.log(data)
  });
}
}
