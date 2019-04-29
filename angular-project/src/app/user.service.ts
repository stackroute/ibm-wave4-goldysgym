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
    return this.http.post("http://13.234.148.231:8080/enrollment/enrollment",user,{headers:headers, responseType:"text"});

  }

  loginUser(user: any): Observable<any>{
    const headers = new HttpHeaders({'Access-Control-Allow-Orgin': "*"});
    return this.http.post("http://13.234.148.231:8080/authentication/login",user,{headers:headers});

  }
  getUserDetails() {
    return this.http.get("http://13.234.148.231:8080/enrollment/enrollments");
  }
  
  getUserDetailsById(userid) {
   
    return this.http.get(`http://13.234.148.231:8080/enrollment/enrollment/${userid}`);
  }
  getRec(fname){
      //String lname=localStorage.getItem("")
      let lname="mrit";
      console.log(fname)
      return this.http.post(`http://localhost:8081/user/api/v1/relation/${lname}/${fname}`,{})
    }
    //recommends the users friend of friend suggestion
    getRecommendedUsers()
    {
      let user="mrit";
      console.log(user)
      return this.http.get(`http://localhost:8081/user/api/v1/followedusers/${user}`,{})
    }
    //recommends the programs which his friends will like
    getRecommendedSessions()
    {
      let user="mrit";
      console.log(user)
      return this.http.get(`http://localhost:8081/user/api/v1/recommend/programs/${user}`,{})
    }
    getAgeGroupUser()
    {
      let user="mrit";
      console.log(user)
      return this.http.get(`http://localhost:8081/user/api/v1/agegroup/${user}`,{})
    }
    unfollow(fname)
    {
      //String lname=localStorage.getItem("")
      let lname="mrit";
      console.log(fname)
      return this.http.delete(`http://localhost:8081/user/api/v1/unfollow/${lname}/${fname}`,{})
    }
    //shows that a user follows which users
    userfollows()
    {
      let fname="mrit";
      console.log(fname)
      return this.http.get(`http://localhost:8081/user/api/v1/users/followed/${fname}`)
    }
}
