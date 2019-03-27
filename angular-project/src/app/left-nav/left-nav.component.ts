import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-left-nav',
  templateUrl: './left-nav.component.html',
  styleUrls: ['./left-nav.component.css']
})
export class LeftNavComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  tf:any[] = [true,false,false,false,false];

  tfToggle(a){
    this.tf= [false,false,false,false,false];
    this.tf[a] = true;
  }

  // getState(a){
  //   console.log(a);
  //   return false
  // }

}
