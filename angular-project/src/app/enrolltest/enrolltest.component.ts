import { Component, OnInit } from '@angular/core';
import { ErrorStateMatcher } from '@angular/material';
import { FormControl, FormBuilder, FormGroup, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ProgramService } from '../program.service';
import { UserService } from '../user.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';


class CrossFieldErrorMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    return control.dirty && form.invalid;
  }
}

@Component({
  selector: 'app-enrolltest',
  templateUrl: './enrolltest.component.html',
  styleUrls: ['./enrolltest.component.css']
})
export class EnrolltestComponent implements OnInit {

  showMsg: boolean = false;
  errorMsg: boolean = false;


  startDate = new Date(1990, 0, 1);
  endDate = new Date(1990, 0, 1);

  isLinear = true;
  firstFormGroup: FormGroup = new FormGroup({});
  secondFormGroup: FormGroup = new FormGroup({});
  thirdFormGroup: FormGroup = new FormGroup({});
  forthFormGroup: FormGroup = new FormGroup({});
  errorMatcher = new CrossFieldErrorMatcher();

  constructor(private formBuilder: FormBuilder, private programService: ProgramService, private userService: UserService, private route: Router) { }

  public user: any = {};
  programs: any;
  subscriptions: any = [];

  // email = new FormControl('');

  saveUser(user: any, a, b, c, userForm: any) {
    user.enabled = true;
    user = Object.assign(user, a)
    user = Object.assign(user, b)
    user = Object.assign(user, c)
    console.log(user)


    let data = {

      "firstName": user.fname,
      "lastName": user.lname,
      "email": user.email,
      "password": user.pwd,
      "gender": user.gender,
      "startDate": user.startdate.toISOString().substring(0, 10),
      "endDate": user.enddate.toISOString().substring(0, 10),
      "dateOfBirth": user.date.toISOString().substring(0, 10),
      "height": user.ht,
      "weight": user.wt,
      "subscription": this.subscription
    }
    console.log(data)
    this.userService.saveUser(data).subscribe((response) => {
      console.log(response);
      this.firstFormGroup.reset();
      this.secondFormGroup.reset();
      this.thirdFormGroup.reset();
      this.forthFormGroup.reset();
      this.errorMsg = false;
      this.showMsg = true;
    }
      ,
      (error: any) => {
        this.errorMsg = true;
        this.showMsg = false;
        console.warn(error);
      })
  }

  ngOnInit() {
    this.getPrograms();
    this.programService.getSubscriptionDetails().subscribe(data => {
      console.log(data)
      this.subscriptions = data
    })

    this.firstFormGroup = this.formBuilder.group({
      'fname': ['', Validators.required],
      'lname': ['', Validators.required],
      'email': [''],
      'pwd': ['', Validators.required],
      // 'cnfpwd': ['', Validators.required],
    },
      {
        validators: this.passwordValidator
      })
    this.secondFormGroup = this.formBuilder.group({
      ht: [null, Validators.required],
      wt: [null, Validators.required],
      date: [null, Validators.required],
      gender: [null, Validators.required],

    });

    this.forthFormGroup = this.formBuilder.group({
      radio: [null, Validators.required],
      startdate: [null, Validators.required],
      enddate: [null, Validators.required],
    });
  }
  passwordValidator(firstFormGroup: FormGroup) {
    console.log(firstFormGroup)
    // const condition = firstFormGroup.get('pwd').value !== firstFormGroup.get('cnfpwd').value;

    // return condition ? { passwordsDoNotMatch: true} : null;
    return false;
  }



  //   getErrorMessage() {
  //     // return this.email.hasError('required') ? 'You must enter a value' :
  //     //     this.email.hasError('email') ? 'Not a valid email' :
  //     //         '';
  //     return '';
  // }
  getPrograms() {
    this.programService.getProgramDetails1().subscribe((x) => {
      this.programs = x
      console.log(this.programs)
    });
  }
  subscription: any
  method(sub) {
    this.subscription = sub

  }
}
