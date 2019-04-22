import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-add-programs',
  templateUrl: './add-programs.component.html',
  styleUrls: ['./add-programs.component.css']
})
export class AddProgramsComponent implements OnInit {

  constructor(private programService: ProgramService) { }

  ngOnInit() {
   
  }

  putProgram(data) {
    let newData = {
      "programName": data.pname,
      "day": data.inputday,
      "timing": data.exampleRadios,
      "imageUrl": data.imageUrl,
      "programDescription": data.description,
      "trainerName": null,
      "trainerDescription":null, 
      "totalSeats": data.seats
    }
    this.programService.putProgram(newData).subscribe((x) => {
      // this.data = x
      console.log(data)
    });
  }

}
