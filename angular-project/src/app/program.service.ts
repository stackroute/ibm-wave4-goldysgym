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
    return this.http.get(" http://localhost:9001/api/v1/programs");
  }
  getProgramDetails(id){
    
    return this.http.get(`http://localhost:9001/api/v1/programs/${id}`);
  }

  getSubscriptionDetails(){
    return this.http.get("http://localhost:9003/api/v2/subscriptions");
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
    // console.log(id, "this is data given to backend ");
    return this.http.put(environment.dbUrlOut2,data);
    //return this.http.get(`http://localhost:9001/api/v1/programs/${id}`);
  }


}
