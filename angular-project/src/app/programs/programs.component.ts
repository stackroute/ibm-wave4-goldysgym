import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrls: ['./programs.component.css']
})
export class ProgramsComponent implements OnInit {

  constructor(private program:ProgramService,private http:HttpClient) { }
  arrayPrograms:any=[];
  ngOnInit() {
    this.program.getProgramDetails().subscribe(data=>{
      console.log(data)
      this.arrayPrograms=data
    })
  }
}
