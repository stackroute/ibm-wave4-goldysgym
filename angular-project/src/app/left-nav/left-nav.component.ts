import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-left-nav',
  templateUrl: './left-nav.component.html',
  styleUrls: ['./left-nav.component.css']
})
export class LeftNavComponent implements OnInit {

  constructor(private programService: ProgramService) { }

  ngOnInit() {
  }

  tf:any[] = this.programService.tf;

  tfToggle(a){
    this.programService.tfToggle(a);
  }

  

}
