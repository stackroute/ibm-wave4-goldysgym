import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
    this.http = http;
  }

  saveUser(user: any): Observable<any>{
    const headers = new HttpHeaders({'Access-Control-Allow-Orgin': "*"});
    console.log(user, "this is user object in user service")
    return this.http.post("http://localhost:8091/enrollment",user,{headers:headers, responseType:"text"});

  }

  loginUser(user: any): Observable<any>{
    const headers = new HttpHeaders({'Access-Control-Allow-Orgin': "*"});
    return this.http.post("http://13.234.148.231:8080/authentication/login",user,{headers:headers});

  }
  getUserDetails() {
    return this.http.get("http://13.234.148.231:8080/enrollment/enrollments");
  }
  
  getUserDetailsById(userid) {
   
    return this.http.get(`http://localhost:8091/enrollment/${userid}`);
  }
}
