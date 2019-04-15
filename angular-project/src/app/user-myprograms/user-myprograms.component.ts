import { Component, OnInit } from '@angular/core';
import { ProgramService } from '../program.service';
import { HttpClient, HttpHeaders} from '@angular/common/http'
@Component({
  selector: 'app-user-myprograms',
  templateUrl: './user-myprograms.component.html',
  styleUrls: ['./user-myprograms.component.css']
})
export class UserMyprogramsComponent implements OnInit {
  

  constructor(private program:ProgramService,private http:HttpClient) { }
  arrayPrograms:any=[];
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
 publish()
 {
  let newData = 
          [{
              "monthName": "April",
              "days": [
                  {
                      "date": "2019-04-21T00:00:00.000+0000",
                      "slots": [
                          {
                              "time": "Morning",
                              "programName": "thies",
                              "capacity": 25,
                              "users": [
                                  "abhinab",
                                  "saunak",
                                  "rakesh",
                                  "yash",
                                  "santosh"
                              ]
                          },
                          {
                              "time": "Evenning",
                              "programName": "Boxing",
                              "capacity": 25,
                              "users": [
                                  "abhinab",
                                  "saunak",
                                  "rakesh",
                                  "yash",
                                  "shweta"
                              ]
                          }
                      ]
                  },
                ]           
  }
]
  console.log(newData)
  this.program.putUser(newData).subscribe(x=> {
    console.log(x)
  })
 }
  
}
