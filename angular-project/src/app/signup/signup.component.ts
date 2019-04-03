import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { LoginAuthService } from '../login-auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user: any = {};  
  constructor(private userService: UserService,private authService: LoginAuthService) {
     this.authService.isLoggedIn();
   }

  ngOnInit() {  
  }
  showMsg: boolean = false;
  errorMsg: boolean = false;
  saveUser(user:any,userForm:any){
    
    user.enabled = true;
    this.userService.saveUser(user).subscribe((response)=>{
        if(response){
          console.log(response);
          userForm.reset();
          this.showMsg= true;
        }
      
    }
    ,
  (error:any)=>{
    console.warn(error);
    this.errorMsg = true;
  })
  }

}
