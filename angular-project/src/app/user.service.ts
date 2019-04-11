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
    return this.http.post("http://localhost:9002/login",user,{headers:headers});

  }
  // getAllUsers(token: any): Observable<any>{
  //   const headers = new HttpHeaders({'Authorization': "Bearer "+ token});
  //   return this.http.get("http://localhost:9002/users",{headers:headers});

  // }
  // getUser(token: any): Observable<any>{
  //   const headers = new HttpHeaders({'Authorization': "Bearer "+ token});
  //   return this.http.get("http://localhost:9002/getuser ",{headers:headers});

  // }
  getUserDetails() {
    return this.http.get("http://localhost:8091/enrollments");
  }
}
