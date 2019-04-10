import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

import { switchMap } from 'rxjs/operators';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-edit-programform',
  templateUrl: './edit-programform.component.html',
  styleUrls: ['./edit-programform.component.css']
})
export class EditProgramformComponent implements OnInit {

  constructor(private programService: ProgramService ,private route :ActivatedRoute,private service : ProgramService,private router : Router) { }
  id :any
  program:any
  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.programService.getProgramDetails(this.id).subscribe(data=>{
      console.log(data)
      this.program=data
    })
  }
  pdetails:any;
  editProgram(data) {
    let newData = {
      "programId":this.id,
      "programName": data.pname,
      "day": data.inputday,
      "timing": data.exampleRadios,
      "imageUrl": data.imageUrl,
      "programDescription": data.description,
      "trainerName": data.tname,
      "trainerDescription": data.tdescription,
      "totalSeats": data.seats
    }
    
  
    console.log(this.id)
    this.programService.editProgram(newData).subscribe(data =>{
    this.pdetails = newData
    console.log(newData)
    
    });
    

}
}
