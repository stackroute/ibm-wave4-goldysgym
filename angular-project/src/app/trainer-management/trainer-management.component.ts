import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-trainer-management',
  templateUrl: './trainer-management.component.html',
  styleUrls: ['./trainer-management.component.css']
})
export class TrainerManagementComponent implements OnInit {
  trainers:any
  constructor(private programService:ProgramService ) { }

  ngOnInit() {
    this.getTrainers()
  }

  getTrainers() {
    this.programService.getTrainers().subscribe((data) => {
      this.trainers= data
      console.log(this.trainers)
    });
  }

}