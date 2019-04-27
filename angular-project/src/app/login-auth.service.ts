import { Injectable } from '@angular/core';
import { Observable,Subject} from 'rxjs';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class LoginAuthService implements CanActivate  {

  private subject = new Subject<any>();

  constructor(private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.isLoggedIn())
    return true;

    this.router.navigate(['login']);
    return false;
  }

  isLoggedIn(){
    if(localStorage.getItem('currentUser')){
      this.subject.next({status: true});
      return true
    }else{
      this.subject.next({status: false});
      return false
    }
  }

  clearStatus(){
    this.subject.next();
  }

  getStatus():Observable<any>{
    return this.subject.asObservable();
  }

  checkToken(){
  const helper = new JwtHelperService();
  const decodedToken = helper.decodeToken(localStorage.getItem('currentUser'));
  return decodedToken;

  }

  

}
