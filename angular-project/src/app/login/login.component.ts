import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { LoginAuthService } from '../login-auth.service';
import { throwError, from } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: any = {};

  constructor(private userService: UserService,private router:Router,private authService: LoginAuthService) { 
    this.authService.isLoggedIn();
  }

  ngOnInit() {
  }
  loginUser(user:any){

    this.userService.loginUser(user).subscribe((response)=>{
      if(response){
        localStorage.setItem('currentUser',JSON.stringify(response));
        if(response.user.role === 'ADMIN'){
           this.router.navigate(['/admin']);
        }else if(response.user.role === 'USER'){
          this.router.navigate(['/user']);
        }else{
          this.router.navigate(['/ownerdashboard']);
        }
      }
      if((!response.user.email === user.email) && (!response.user.password === user.password)){
        return throwError({error: {message: 'Username or password is incorrect '}});
      }
  })
 
  }

}
