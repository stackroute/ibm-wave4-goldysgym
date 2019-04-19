import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-admin-myprograms',
  templateUrl: './admin-myprograms.component.html',
  styleUrls: ['./admin-myprograms.component.css']
})
export class AdminMyprogramsComponent implements OnInit {

  constructor(private program:ProgramService,private http:HttpClient) { }
  arrayPrograms:any;
  cpc: any;
  x:any;
  y:any=[];
  counter(i: number) {
    return new Array(i);
  }
  ngOnInit() {
    this.view()
     }
   
     view()
      {
        //console.log(x)
       this.program.getProgramsOfUser().subscribe(data=>{
         console.log(data)
         this.arrayPrograms=data
         console.log(this.arrayPrograms);
      }) 
     }
   
     viewdata(x,y)
     {
       this.x=x;
       
       this.y=y;
       console.log(y)
    }
    publish(date,time,pgm)
    {
      console.log(date)
      console.log(time)
      console.log(pgm)
      console.log(this.cpc)
     let newData= this.arrayPrograms
   
     console.log(newData[0])
     this.program.putadmin(newData[0],time,date,pgm,this.cpc).subscribe(x=> {
       console.log(x)
     })
     location.reload();

    // location.reload();
    }
     
   }