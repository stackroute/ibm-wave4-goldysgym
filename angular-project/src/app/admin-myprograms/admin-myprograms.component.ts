import { Component, OnInit } from "@angular/core";
import { ProgramService } from "../program.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Component({
  selector: "app-admin-myprograms",
  templateUrl: "./admin-myprograms.component.html",
  styleUrls: ["./admin-myprograms.component.css"]
})
export class AdminMyprogramsComponent implements OnInit {
  constructor(private program: ProgramService, private http: HttpClient) {}
  arrayPrograms: any;
  cpc: any;
  x: any;
  y: any = [];
  programs: any;
  counter(i: number) {
    return new Array(i);
  }
  ngOnInit() {
    this.program.getProgramDetails1().subscribe(data => {
      this.programs = data;
      console.log(this.programs);
    });
    this.view();
  }

  view() {
    //console.log(x)
    this.program.getProgramsOfUser().subscribe(data => {
      console.log(data);
      this.arrayPrograms = data;
      console.log(this.arrayPrograms.date);
    });
  }

  viewdata(x, y) {
    this.x = x;

    this.y = y;
    console.log(y);
  }
  add(cap, pgm, slot, date) {
    console.log(date);
    console.log(slot);
    console.log(pgm);
    console.log(cap);
    let newData = this.arrayPrograms;

    console.log(newData[0]);
    this.program.putadmin(newData[0], pgm, slot, cap, date).subscribe(x => {
      console.log(x);
    });
    location.reload();
  }
}
