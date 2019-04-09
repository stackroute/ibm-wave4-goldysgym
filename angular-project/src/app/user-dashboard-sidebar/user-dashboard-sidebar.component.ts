import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-dashboard-sidebar',
  templateUrl: './user-dashboard-sidebar.component.html',
  styleUrls: ['./user-dashboard-sidebar.component.css']
})
export class UserDashboardSidebarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  tf:any[] = [true,false,false,false,false,false];

  tfToggle(a){
    this.tf= [false,false,false,false,false,false];
    this.tf[a] = true;
  }
}
