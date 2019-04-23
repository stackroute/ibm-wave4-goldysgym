import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-trainer-management',
  templateUrl: './trainer-management.component.html',
  styleUrls: ['./trainer-management.component.css']
})
export class TrainerManagementComponent implements OnInit {
  programs:any
  constructor(private programService:ProgramService,private ) { }

  ngOnInit() {
  }

  getPrograms() {
    this.programService.getPrograms().subscribe((x) => {
      this.programs= x
      console.log(this.programs)
    });
  }

}
