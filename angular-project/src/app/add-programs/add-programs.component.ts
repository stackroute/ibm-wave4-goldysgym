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

  putProgram(data, form) {
    let newData = {
      "programName": data.pname,
      "imageUrl": data.imageUrl,
      "programDescription": data.description,
    }
    form.reset();
    this.programService.putProgram(newData).subscribe((x) => {
      console.log(data)
    });
  }

}
