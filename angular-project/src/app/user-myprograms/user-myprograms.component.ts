import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient, HttpHeaders} from '@angular/common/http'
@Component({
  selector: 'app-user-myprograms',
  templateUrl: './user-myprograms.component.html',
  styleUrls: ['./user-myprograms.component.css']
})
export class UserMyprogramsComponent implements OnInit {
  

  constructor(private program:ProgramService,private http:HttpClient) {
    this.view()
   }
  arrayPrograms:any;
  userData:any
  today: number = Date.now();
  showMsg: boolean = false;
  x:any;
  y:any=[];
  counter(i: number) {
    return new Array(i);
}

  ngOnInit() {
    this.userData=JSON.parse(localStorage.getItem('currentUser'))
    console.log(this.userData.user.email)
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
 publish(date,time)
 {
   console.log(date)
   console.log(time)
  let newData= this.arrayPrograms

  console.log(newData[0])
  this.program.putUser(newData[0],time,date,this.userData.user.email).subscribe(x=> {
    console.log(x)
   
  })
  this.showMsg=true;
  location.reload();
 }
  
}
