import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';


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



}
