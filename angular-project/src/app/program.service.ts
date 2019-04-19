import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Observable, from } from 'rxjs';
import {HttpParams} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  constructor(private http: HttpClient) { }

  
  tf:any[] = [false,false,false,false,false];
  
  tfToggle(a){
    this.tf= [false,false,false,false,false];
    this.tf[a] = true;
  }

  getPrograms() {
    return this.http.get(environment.dbUrlOut);
  }
 
  getProgramDetails1(){
    return this.http.get(environment.dbUrlOut);
  }
 
  getProgramDetails(id){
    
    return this.http.get(environment.dbUrlOut2+id);
  }

 
  getSubscriptionDetails(){
    return this.http.get(environment.dbUrlOut4);
  }
  getSubscriptionDetailsById(id){
    
    return this.http.get(environment.dbUrlOut4+id);
  }

  putProgram(data)
  {
  return this.http.post(environment.dbUrlOut1,data);
 } 
 putSubscription(data)
 {
 return this.http.post(environment.dbUrlOut3,data);
}

  deleteProgram(id) {
    return this.http.delete(environment.dbUrlOut2+id);
  }
  editProgram(data)
  {
   
    return this.http.put(environment.dbUrlOut2,data);
   
  }
  deleteSubscription(id) {
    return this.http.delete(environment.dbUrlOut4+id);
  }
  editSubscription(data)
  {
   
    return this.http.put(environment.dbUrlOut4,data);
   
  }


  getProgramsOfUser()
  {
    return this.http.get("http://localhost:8092/programs",);
    return this.http.get("http://localhost:3000/month");
  }
  putUser(data,time,date,name)
  {
          let params = new HttpParams();

     // Begin assigning parameters
//      const params = new URLSearchParams();
// params.set('time', time);
// params.set('date', date);
// params.set('name', name);

     params = params.append('time', time);
     params = params.append('date', date);
     params = params.append('name', name);
     console.log(data)
     console.log(params)
     let id="2019";
  return this.http.put("http://localhost:8092/user",data,{params:params});
 } 
 putadmin(data,time,date,pgm,cpc)
  {
          let params = new HttpParams();

     // Begin assigning parameters
//      const params = new URLSearchParams();
// params.set('time', time);
// params.set('date', date);
// params.set('name', name);

     params = params.append('time', time);
     params = params.append('date', date);
     params = params.append('program', pgm);
     params = params.append('capacity', cpc);

     console.log(data)
     console.log(params)
     let id="2019";
  return this.http.put("http://localhost:8092/adminupdate",data,{params:params});
 } 
}
  