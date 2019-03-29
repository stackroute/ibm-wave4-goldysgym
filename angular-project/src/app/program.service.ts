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
  getProgramDetails(){
    return this.http.get(" http://localhost:9001/api/v1/programs");
  }
  getSubscriptionDetails(){
    return this.http.get("http://localhost:3000/subscriptions");
  }
  putProgram(data)
{
  return this.http.post(environment.dbUrlOut1,data);
}

  deleteProgram(id) {
    return this.http.delete(environment.dbUrlOut+id);
  }
}
