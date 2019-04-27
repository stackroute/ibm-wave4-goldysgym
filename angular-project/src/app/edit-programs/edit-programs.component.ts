import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-programs',
  templateUrl: './edit-programs.component.html',
  styleUrls: ['./edit-programs.component.css']
})
export class EditProgramsComponent implements OnInit {

  programs : any;

  constructor(private programService: ProgramService, private http:HttpClient,private router:Router) { }

  ngOnInit() {
    this.getPrograms();
  }

  getPrograms() {
    this.programService.getPrograms().subscribe((x) => {
      this.programs= x
      console.log(this.programs)
    });
  }

  remove(id)
  {
    console.log(id);
    // return this.http.delete('http://localhost:3000/programs/'+id).subscribe(console.log),
    // this.programs=this.programs.filter(x=>id!=x.id);
    
    return this.programService.deleteProgram(id).subscribe(()=>{this.getPrograms()})
   }

}
