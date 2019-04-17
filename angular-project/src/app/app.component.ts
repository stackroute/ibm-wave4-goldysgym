import { Component } from '@angular/core';
import { LoginAuthService } from './login-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'goldys-gym-admin';
  decodedtoken:any;
  // role:any;
  isLogin:boolean=false;
  email: any;

  constructor(private loginauth:LoginAuthService){}
  ngOnInit(){
    this.decodedtoken=this.loginauth.checkToken();
    console.log(this.decodedtoken);
    // if(this.decodedtoken){
    //   this.role=this.decodedtoken.role;
    //   this.isLogin=true;
    //   this.email=this.decodedtoken.sub;
    //   localStorage.setItem('email',this.email);
    //   localStorage.setItem('role', this.role);

    // }
  }
}
