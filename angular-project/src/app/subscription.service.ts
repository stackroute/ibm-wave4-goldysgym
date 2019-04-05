import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {
  constructor(private http: HttpClient) { }
 
  getSubscriptionviewFromBackend(currentRoute){
    return this.http.get("http://localhost:3000/" + currentRoute)
  }


}

