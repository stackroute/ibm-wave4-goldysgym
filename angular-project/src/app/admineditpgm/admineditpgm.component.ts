import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-admineditpgm',
  templateUrl: './admineditpgm.component.html',
  styleUrls: ['./admineditpgm.component.css']
})
export class AdmineditpgmComponent implements OnInit {


  constructor(private programService: ProgramService, private route :ActivatedRoute, private service : ProgramService,private router : Router) { }
  id :any
  program:any
  data:any
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.programService.getProgramDetails(this.id).subscribe(data=>{
      console.log(data, "slkdjflksjdlfkjsl")
      this.program=data
     console.log(this.program)
    })
  }
  pdetails:any;
  editProgram(data) {
    let newData = {
    //  "programId":this.id,
      "programId":data.id,
      "programName": data.pname,
     
      "time": data.exampleRadios,
    
       "capacity": data.seats
    }
    
  
    console.log(this.id)
    this.programService.editProgram(newData).subscribe(data =>{
    this.pdetails = newData
    console.log(newData)
    
    });
    

}
}
