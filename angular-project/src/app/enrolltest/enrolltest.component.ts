import { Component, OnInit } from '@angular/core';
import {ErrorStateMatcher} from '@angular/material';
import {FormControl,FormBuilder, FormGroup, FormGroupDirective,NgForm, Validators} from '@angular/forms';
import { ProgramService } from '../program.service';


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

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  errorMatcher = new CrossFieldErrorMatcher();

  constructor(private formBuilder: FormBuilder,private programService: ProgramService) { } 
  programs: any;
  ngOnInit() {
    this.getPrograms();

    this.firstFormGroup = this.formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this.formBuilder.group({
      secondCtrl: ['', Validators.required]
    });
    this.thirdFormGroup = this.formBuilder.group({
      thirdCtrl: ['', Validators.required]
    });
    this.firstFormGroup = this.formBuilder.group({
      fname: [null, Validators.required],
      lname: [null, Validators.required],
      pwd: [null, Validators.required],
      cnfpwd: [null, Validators.required],
    },
    {
      validator: this.passwordValidator
    })
     this.secondFormGroup = this.formBuilder.group({
      ht: [null, Validators.required],
      wt: [null, Validators.required],
      date: [null, Validators.required],
    });
  }
  passwordValidator(firstFormGroup: FormGroup) {
    const condition = firstFormGroup.get('pwd').value !== firstFormGroup.get('cnfpwd').value;

    return condition ? { passwordsDoNotMatch: true} : null;
  }

  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    return this.email.hasError('required') ? 'You must enter a value' :
        this.email.hasError('email') ? 'Not a valid email' :
            '';
}
getPrograms() {
  this.programService. getProgramDetails1().subscribe((x) => {
    this.programs = x
    console.log(this.programs)
  });
}


  
  
}
