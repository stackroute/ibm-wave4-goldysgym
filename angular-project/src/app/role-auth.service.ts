import { Injectable } from '@angular/core';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class RoleAuthService implements CanActivate {

  constructor( private router: Router) { }
  userData: any;
  role: any;
  expectedRole: any;

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    this.userData=JSON.parse(localStorage.getItem('currentUser'))
    this.role = this.userData.user.role
    this.expectedRole = route.data.expectedRole;
    console.log(this.role !== this.expectedRole)
    if (this.role !== 'ADMIN') {
      this.router.navigate(['login']);
      return false;
    }
   else {
      return true;  
  }
    
  }
}
